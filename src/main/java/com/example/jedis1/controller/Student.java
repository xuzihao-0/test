package com.example.jedis1.controller;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -5085509642669909466L;
    private String name;
    private Integer age;


}
