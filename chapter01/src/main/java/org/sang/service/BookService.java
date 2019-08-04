package org.sang.service;

import org.sang.mapper.BookMapper;
import org.sang.model.Book;
import org.sang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public int addBook(Book book){
        return bookMapper.addBook(book);
    }

    public int updateBook(Book book){
        return bookMapper.updateBookById(book);
    }

    public int deleteBookById(Integer id){
        return bookMapper.deleteBookById(id);
    }

    public Book getBookById(Integer id){
        return bookMapper.getBookById(id);
    }

    public List<Book> getAllBooks(){
        return bookMapper.getAllBooks();
    }
//    mybatis配置的mapper  end
}
