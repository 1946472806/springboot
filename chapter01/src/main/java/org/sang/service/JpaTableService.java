package org.sang.service;

import org.sang.dao.JpaTableDao;
import org.sang.model.JpaTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTableService {
    @Autowired
    JpaTableDao jpaTableDao;

    public void addJpaTable(JpaTable jpaTable){
        jpaTableDao.save(jpaTable);
    }

    public Page<JpaTable> getJpaTableByPage(Pageable pageable){
        return jpaTableDao.findAll(pageable);
    }

//    public List<JpaTable> getJpaTableByAuthorStartingWith(String author){
//        return jpaTableDao.getJpaTableByAuthorStartingWith(author);
//    }

//    public List<JpaTable> getJpaTableByPriiceGreaterThen(Float price){
//        return jpaTableDao.getJpaTableByPriceGreaterThan(price);
//    }

//    public JpaTable getMaxIdJpaTable(){
//        return jpaTableDao.getMaxIdJapTable();
//    }

    public String getJpaTableByIdAndAuthor(String author,Integer id){
        return jpaTableDao.getJpaTableByIdAndAuthor(author,id);
    }

    public String getJpaTableByIdAndName(String name,Integer id){
        return jpaTableDao.getJpaTableByIdAndName(name,id);
    }
}
