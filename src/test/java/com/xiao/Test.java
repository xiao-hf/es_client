package com.xiao;

import com.xiao.domain.Time;
import com.xiao.mapper.TimeMapper;
import jakarta.annotation.Resource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {
    @Resource
    public TimeMapper timeMapper;

    @org.junit.jupiter.api.Test
    public void test() {
        Time time = timeMapper.selectByPrimaryKey(1L);
        System.out.println(time.getTime());
    }
}
