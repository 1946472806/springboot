package org.sang.dao;

import org.sang.model.JpaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaTableDao extends JpaRepository<JpaTable,Integer> {
    List<JpaTable> getJpaTableByAuthorStartingWith(String author);
    List<JpaTable> getJpaTableByPriceGreaterThan(Float price);

    @Query(value = "select b from JpaTable b where b.id=(select max(a.id) from JpaTable a )",nativeQuery = true)
    JpaTable getMaxIdJapTable();

    @Query(value = "select b from JpaTable b where b.id>:id and b.author=:author")
    List<JpaTable> getJpaTableByIdAndAuthor(@Param("author") String author,@Param("id") Integer id);

    @Query(value = "select b from JpaTable b where b.id<?2 and b.name like %?1%")
    List<JpaTable> getJpaTableByIdAndName(String name,Integer id);
}
