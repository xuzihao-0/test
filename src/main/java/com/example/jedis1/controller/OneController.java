package com.example.jedis1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;
import sun.management.Agent;

@RestController
public class OneController {
    @Autowired
    private StringRedisTemplate stringredisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("redis1")
    public String qq(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        Student student = new Student();
        student.setAge(18);
        student.setName("xuzihao");
        redisTemplate.opsForValue().set("xu", student);
        Object xu = redisTemplate.opsForValue().get("xu");
        System.out.println(xu);
        return student.toString();


    }


    @GetMapping("redis")
    public Student sty(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        Student student = new Student("xuzihao",18);
        redisTemplate.opsForValue().set("tstudent",student);
        Student tuser = (Student) redisTemplate.opsForValue().get("tstudent");
        System.out.println(tuser);
        return tuser;

    }


    @PostMapping("hello")
    public String ss(@RequestBody String qq){
        System.out.println(qq);
//        stringredisTemplate.opsForValue().set("ggg", "qqqq");
//        String ggg = stringredisTemplate.opsForValue().get("ggg");



        return "hello";
    }
    @PostMapping("two")
    public String tt(@RequestParam(value = "name") String name, @RequestParam(value = "age") Integer age)
    {
        System.out.println(name);
        System.out.println(age);
        return "two";
    }
    @PostMapping("three")
    public Student qq(@RequestBody Student student)
    {

        System.out.println(student);
        return student;
    }


}
