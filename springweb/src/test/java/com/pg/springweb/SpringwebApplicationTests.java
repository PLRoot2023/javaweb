package com.pg.springweb;

import com.pg.springweb.entity.Person;
import org.apache.logging.log4j.util.PropertySource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class SpringwebApplicationTests {

   private  Stream<Person> personStream;

    @BeforeEach
    void beforeEash() {
        Person p1 = new Person();
        p1.setId(1);
        p1.setAge(9);
        p1.setName("xiaoli_1");
        p1.setAddress("address_1");
        p1.setTime(LocalTime.MIN);

        Person p2 = new Person();
        p2.setId(2);
        p2.setAge(20);
        p2.setName("xiaoli_2");
        p2.setAddress("address_2");
        p2.setTime(LocalTime.MIN);


        Person p3 = new Person();
        p3.setId(3);
        p3.setAge(10);
        p3.setName("xiaoli_3");
        p3.setAddress("address");
        p3.setTime(LocalTime.MIN);


        Person p4 = new Person();
        p4.setId(3);
        p4.setAge(11);
        p4.setName("xiaoli_4");
        p4.setAddress("address");
        p4.setTime(LocalTime.MIN);

        personStream = Stream.of(p1,p2,p3,p4);

    }



    @Test
    void test1() {

        Map<Integer, Person> collect = personStream.collect(Collectors.toMap(Person::getId, Function.identity(),(v1,v2)->{
            v1.setAddress(v1.getAddress()+v2.getAddress());
            return v1;
        },TreeMap::new));
        Person person = collect.get(2);
        System.out.println(person);


    }

    @Test
    void test2() {
        TreeMap<Integer, String> collect1 = personStream.collect(Collectors.toMap(Person::getId, Person::getName, String::concat, TreeMap::new));

        System.out.println(collect1);
    }


    @Test
    public void test2_groupBy(){

        Map<String, List<Person>> collect =
                personStream.collect(Collectors.groupingBy(Person::getAddress));


        for (String s : collect.keySet()) {
            System.out.println(s);
        }

        System.out.println("----------------"+collect.size());

    }


    /**
     * 统计年龄
     */
    @Test
    public void test3_count(){
        Map<String, Long> collect = personStream.collect(Collectors.groupingBy(Person::getAddress, Collectors.summingLong(Person::getAge)));

        System.out.println(collect);
    }


    /**
     * 获取同地址最大
     */
    @Test
    public void test4_compare(){
        Map<String, Optional<String>> collect = personStream.collect(Collectors.groupingBy(Person::getAddress, Collectors.mapping(Person::getName, Collectors.minBy(Comparator.comparing(String::toString)))));

        System.out.println(collect);


    }

    @Test
    public void test5_reduce(){
        //第三个函数 第三个函数主要是用于多线程合并
//        Integer reduce = personStream.parallel().map(Person::getAge).reduce(0, Integer::sum,(int1, int2)->{
//            System.out.println(int1+":"+int2);
//        return int1 +int2;});
        Integer reduce = personStream.parallel().map(Person::getAge).reduce(Integer.valueOf(0), (age1, age2) -> (age1 + age2),(int1,int2)->{
            System.out.println(int1+":"+int2);
            return int1 +int2;});

        System.out.println(reduce);
    }

    @Test
    public void test6_baseObj(){
//        IntStream intStream =
    }
}
