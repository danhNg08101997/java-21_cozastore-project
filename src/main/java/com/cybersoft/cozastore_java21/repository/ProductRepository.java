package com.cybersoft.cozastore_java21.repository;

import com.cybersoft.cozastore_java21.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
     List<ProductEntity> findByCategoryId(int idCategory);


}
