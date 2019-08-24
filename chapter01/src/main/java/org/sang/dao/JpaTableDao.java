package org.sang.dao;

import org.sang.model.JpaTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaTableDao extends JpaRepository<JpaTable, Integer> {
//    List<JpaTable> getJpaTableByAuthorStartingWith(String author);
//    List<JpaTable> getJpaTableByPriceGreaterThan(Float price);

    @Query(value = "select b.name from jpatable b where b.id=(select max(a.id) from jpatable a )", nativeQuery = true)
    String getMaxIdJapTable();

    @Query(value = "select b.name from jpatable b where b.id>:id and b.author=:author")
    String getJpaTableByIdAndAuthor(@Param("author") String author, @Param("id") Integer id);

    @Query(value = "select b.name from jpatable b where b.id<?2 and b.name like %?1%")
    String getJpaTableByIdAndName(String name, Integer id);
}
