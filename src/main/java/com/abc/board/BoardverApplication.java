package com.abc.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.abc.board.model.dao")
public class BoardverApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardverApplication.class, args);
    }
}