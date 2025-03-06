package com.xiao.es;

import com.xiao.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    // 自定义查询方法
    List<User> findByName(String name);
    List<User> findByAgeGreaterThan(Integer age);
    List<User> findByAgeAfter(Integer age);
}
