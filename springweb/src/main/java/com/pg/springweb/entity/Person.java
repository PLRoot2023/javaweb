package com.pg.springweb.entity;

import lombok.*;

import java.time.LocalTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private LocalTime time;
    private String address;

}
