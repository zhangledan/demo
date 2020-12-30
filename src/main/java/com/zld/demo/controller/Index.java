package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-30
 */
@RestController
@RequestMapping("/index")
public class Index {
    @GetMapping("/**/users")
    public String index() {
        return "hello world";
    }
}
