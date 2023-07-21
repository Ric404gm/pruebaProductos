package com.prueba.productos.productos.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEnt,Long> {
    

    @Transactional
    @Modifying
    @Query(" delete from  ProductoEnt p  where p.Id = ?1 ")
    void deletePoductById(Long id);


}
