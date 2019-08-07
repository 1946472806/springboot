package org.sang.service;

import org.sang.mapper.BookMapper;
import org.sang.model.Book;
import org.sang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "book_cache")
public class BookService {
//    mysql配置的DAO  begin
//    @Autowired
//    BookDao bookDao;
//    public int addBook(Book book){
//        return bookDao.addBook(book);
//    }
//
//    public int updateBook(Book book){
//        return bookDao.updateBook(book);
//    }
//
//    public int deleteBookById(Integer id){
//        return bookDao.deleteBookById(id);
//    }
//
//    public Book getBookById(Integer id){
//        return bookDao.getBookById(id);
//    }
//
//    public List<Book> getAllBooks(){
//        return bookDao.getAllBooks();
//    }
//    mysql配置的DAO end

//    mybatis配置的mapper  begin
    @Autowired
    BookMapper bookMapper;

    @Cacheable
    public Book getBookById(Integer id){
        return bookMapper.getBookById(id);
    }

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }

    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    @CachePut(key = "#book.id")
    public int updateBook(Book book){
        return bookMapper.updateBookById(book);
    }

    @CacheEvict(key = "#id")
    public int deleteBookById(Integer id){
        return bookMapper.deleteBookById(id);
    }

//    mybatis配置的mapper  end
}
