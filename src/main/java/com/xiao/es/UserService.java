package com.xiao.es;

import com.xiao.domain.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    UserRepository userRepository;
    public User insert(User user) {
        return userRepository.save(user);
    }
    public void insertBatch(List<User> users) {
        userRepository.saveAll(users);
    }
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id.toString());
    }
}
