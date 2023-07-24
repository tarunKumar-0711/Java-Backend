package com.multipledb.db2repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multipledb.db2entities.Product;

@Repository
public interface Db2Repository extends JpaRepository<Product, Integer>{

}
