package org.sang.controller;

import org.sang.model.JpaTable;
import org.sang.service.JpaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JpaTableController {
    @Autowired
    JpaTableService jpaTableService;

    @GetMapping("/findAll")
    public void findAll() {
        PageRequest pageable = PageRequest.of(1, 1);
        Page<JpaTable> page = jpaTableService.getJpaTableByPage(pageable);
        System.out.println("总页数:" + page.getTotalPages());
        System.out.println("总记录数:" + page.getTotalElements());
        System.out.println("查询结果:" + page.getContent());
        System.out.println("当前页数:" + (page.getNumber() + 1));
        System.out.println("当前页记录数:" + page.getNumberOfElements());
        System.out.println("每页记录数:" + page.getSize());
    }

//    @GetMapping("/search")
//    public void search(){
//        List<JpaTable> b1 = jpaTableService.getJpaTableByIdAndAuthor("鲁迅",10);
//        List<JpaTable> b2 = jpaTableService.getJpaTableByAuthorStartingWith("吴");
//        List<JpaTable> b3 = jpaTableService.getJpaTableByIdAndName("西",8);
//        List<JpaTable> b4 = jpaTableService.getJpaTableByPriiceGreaterThen(30F);
//        JpaTable b = jpaTableService.getMaxIdJpaTable();
//
//        System.out.println("b1:"+b1);
//        System.out.println("b2:"+b2);
//        System.out.println("b3:"+b3);
//        System.out.println("b4:"+b4);
//        System.out.println("b:"+b);
//    }

    @GetMapping("/save")
    public void save() {
        JpaTable jpaTable = new JpaTable();
        jpaTable.setAuthor("鲁迅");
        jpaTable.setName("呐喊");
        jpaTable.setPrice(23F);
        jpaTableService.addJpaTable(jpaTable);
    }
}
