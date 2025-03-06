package com.xiao.es;

import com.xiao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserSearchService {

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    public List<User> searchUsers(String keyword, int minAge, String emailDomain) {
        // 1. 构建多条件组合查询
        Criteria criteria = Criteria.where("name") // 姓名包含关键词
                .contains(keyword)
                .and("age").greaterThanEqual(minAge) // 年龄 >= 最小值
                .and("email").endsWith(emailDomain); // 邮箱后缀匹配

        // 2. 分页和排序配置
        Pageable pageable = PageRequest.of(0, 10); // 第1页，每页10条
        Sort sort = Sort.by(Sort.Direction.DESC, "age"); // 按年龄降序

        // 3. 构建完整查询
        Query query = new CriteriaQuery(criteria)
                .setPageable(pageable)
                .addSort(sort);

        // 4. 执行查询
        SearchHits<User> searchHits = elasticsearchOperations.search(query, User.class);

        // 5. 封装结果
        return searchHits.stream()
                .map(hit -> {
                    User user = hit.getContent();
                    hit.getHighlightField("name");
                    return user;
                })
                .collect(Collectors.toList());
    }
}