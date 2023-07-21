package com.prueba.productos.productos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.prueba.productos.productos.dto.ProductoDto;
import com.prueba.productos.productos.persistence.ProductoEnt;
import com.prueba.productos.productos.persistence.ProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService{
    
    private final ProductoRepository productoRepository;

    
    @Autowired
    public ProductoServiceImpl (ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }


    @Override
    public String alta(ProductoDto productoDto) {
        

        try
        {

            ProductoEnt ent = new ProductoEnt();
            ent.setNombre(productoDto.getNombre());
            ent.setPrecio(productoDto.getPrecio());
            return  productoRepository.save(ent ) != null   ?  "OK":  "ERROR" ;
        }
        catch(DataAccessException accessException){
            return "ERROR";
        }
        
    }

    @Override
    public List<ProductoDto> consultar() {
        List<ProductoDto> currentResult =  new ArrayList<>(); 

        try
        {


            List<ProductoEnt> productoEnts  =  productoRepository.findAll();

            productoEnts.stream().forEach( item -> {
                     currentResult.add(new ProductoDto().
                        id(item.getId()).
                            nombre(item.getNombre()).
                                precio(item.getPrecio()));
            });
            
            return   currentResult ;
        }
        catch(DataAccessException accessException){
            return currentResult;
        }

    }



    @Override
    public String modificar(ProductoDto productoDto) {
  
        

        try
        {
            
            Optional<ProductoEnt> productoEnts  =  productoRepository.findById(productoDto.getId());

            if(productoEnts.isPresent())
            {
                productoEnts.get().setNombre(productoDto.getNombre());
                productoEnts.get().setPrecio(productoDto.getPrecio());
                productoRepository.save(productoEnts.get());
                return "OK";
            }
            else 
            {
                return "ERROR";
            }
            
        }
        catch(DataAccessException accessException){
            return "ERROR";
        }
    }
    @Override
    public String eliminar(ProductoDto productoDto) {
  
        

        try
        {
            if(productoRepository.findById( productoDto.getId()).isPresent())
            {
                productoRepository.deletePoductById(productoDto.getId());
                return " OK";
            }
            else {
                return " ERROR " ;
            }
        }
        catch(DataAccessException accessException){
            return "ERROR";
        }
    }
}
