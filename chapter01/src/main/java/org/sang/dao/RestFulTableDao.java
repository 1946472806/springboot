package org.sang.dao;

import org.sang.model.RestfulTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestFulTableDao extends JpaRepository<RestfulTable, Integer> {
    //    List<RestfulTable> getRestfulTableByAuthorLike(String author);
    @Query(value = "select b from t_restful b where b.author = :author")
    List<RestfulTable> getAuthorLike(@Param("author") String author);
}
