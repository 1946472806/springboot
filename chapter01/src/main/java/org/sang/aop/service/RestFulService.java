package org.sang.aop.service;

import org.sang.dao.RestFulTableDao;
import org.sang.model.RestfulTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestFulService {
    @Autowired
    RestFulTableDao restFulTableDao;

    public List<RestfulTable> getauthor(String author) {
        System.out.println("..................." + author);
        return restFulTableDao.getAuthorLike(author);
    }
}
