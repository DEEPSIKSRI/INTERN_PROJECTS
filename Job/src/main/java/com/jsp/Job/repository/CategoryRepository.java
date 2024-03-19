package com.jsp.Job.repository;

import com.jsp.Job.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.catalog.Catalog;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository< Category,Long > {
    boolean existsCategoriesByCategory ( String categoryName );


    @Query("select ct.categoryId from Category as ct where ct.category=:category")
    Long findByCategory( String category );

    List< Category > findTop10ByOrderByCategoryAsc();
}