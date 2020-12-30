package com.example.demo.service;

import com.example.demo.bean.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ledan.zhang
 * @createdAt: 2020-12-21
 */
@Import(MyImportSelector.class)
@Configuration
public class ImportDemo {
}
