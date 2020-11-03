package com.ly.sharding;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.sharding.entity.Course;
import com.ly.sharding.entity.Udict;
import com.ly.sharding.entity.User;
import com.ly.sharding.mapper.CourseMapper;
import com.ly.sharding.mapper.UdictMapper;
import com.ly.sharding.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShardingApplicationTests {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UdictMapper udictMapper;

    @Test
    void addCourse() {
        Course course = new Course();
        course.setCname("java");
        course.setUserId(111L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

    @Test
    public void findCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 517772557164740609L);
        wrapper.eq("user_id", 111);
        Course course = courseMapper.selectOne(wrapper);
        System.out.println(course);
    }

    @Test
    void addUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setUstatus("used");
        userMapper.insert(user);
    }

    @Test
    public void findUser() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "testUser");
        wrapper.eq("ustatus", "used");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void addUdict() {
        Udict udict = new Udict();
        udict.setUstatus("1");
        udict.setUvalue("选课");
        udictMapper.insert(udict);
    }

    @Test
    public void deleteUdict() {
        QueryWrapper<Udict> wrapper = new QueryWrapper<>();
        wrapper.eq("ustatus", "1");
        udictMapper.delete(wrapper);
    }

}
