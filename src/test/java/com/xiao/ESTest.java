package com.xiao;

import com.xiao.domain.User;
import com.xiao.es.UserRepository;
import com.xiao.es.UserSearchService;
import com.xiao.es.UserService;
import com.xiao.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ESTest {
    @Resource
    UserSearchService userSearchService;
    @Resource
    UserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    UserRepository userRepository;
    @Test
    public void testInsert() {
//        userService.batchInsert(userMapper.selectAll());
        User user = userMapper.selectById(1);
        user.setName("小灰灰");
        userService.insert(user);
        userService.insertBatch(List.of(user));
        System.out.println(userService.findById(1));

    }
    @Test
    public void testSelect() {
        System.out.println(userService.findById(1));
        System.out.println(userService.findById(2));
        System.out.println(userService.findById(3));
    }
    @Test
    public void testSearch() {
        System.out.println(userSearchService.searchUsers("", 10, ".com"));
    }
    @Test
    public void selfMethod() {
        System.out.println(userRepository.findByAgeGreaterThan(10));
        System.out.println(userRepository.findByAgeAfter(10));
    }
}
