package com.xiao;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.xiao.domain.User;
import com.xiao.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class CreateData {
    @Resource
    UserMapper userMapper;
    @Test
    void createUser() {
        User user = new User();
        user.setAge(10);
        user.setEmail("7347832@qq.com");
        user.setName("小红");
        userMapper.insert(user);
        User user2 = new User();
        user2.setName("小白");
        user2.setAge(20);
        user2.setEmail("787887@163.com");
        userMapper.insert(user2);
    }

    static <T> T randomT(List<T> list) {
        return list.get(randomInt(0, list.size() - 1));
    }

    static Set<Long> randomIds(int max, int count) {
        Set<Long> set = new HashSet<>();
        for (int i = 1; i <= count; i++) {
            long j = -1;
            while (set.contains(j))
                j = randomLong(1, max);
            set.add(j);
        }
        return set;
    }

    static String randomUrl() {
        return "https://" + randomS(100) + ".com";
    }

    static Date now() {
        return new Date();
    }

    static Random r = new Random();

    private static int randomInt(int L, int R) {
        return L + r.nextInt(R - L + 1);
    }

    private static long randomLong(int L, int R) {
        if (R - L + 1 <= 0) {
            int x = 1;
        }
        return L + r.nextInt(R - L + 1);
    }

    private static String randomNumStr(int len) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++)
            res.append(r.nextInt(10));
        return res.toString();
    }

    private static String randomS(int len) {
        return RandomUtil.randomString(len);
    }

    private static String uid() {
        return IdUtil.randomUUID();
    }

    private static Date randomDate() { // 距现在1年内的随机时间
        Date now = new Date();
        int i = randomInt(1, 365 * 24);
        return DateUtil.offset(now, DateField.HOUR, -i);
    }

    private static String randomIp() {
        return "192.168." + randomInt(100, 199) + "." + randomInt(100, 199);
    }

    private static String json() {
        return "{ \"id\": \"1\"}";
    }

    private static Date randomRangeDate(Date start, Date end) {
        int difSec = (int) ((end.getTime() - start.getTime()) / 1000 / 3600);
        if (difSec < 0) {
            int x = 1;
        }
        return DateUtil.offset(end, DateField.HOUR, -randomInt(0, difSec));
    }

    private static int dayDif(Date start, Date end) {
        return (int) ((end.getTime() - start.getTime()) / 1000 / 3600 / 24);
    }
}
