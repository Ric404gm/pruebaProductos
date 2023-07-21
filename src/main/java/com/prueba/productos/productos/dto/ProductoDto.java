package com.prueba.productos.productos.dto;

import lombok.Data;

@Data
public class ProductoDto {
        
    private Long Id;
    private String nombre;
    private Double precio;

    public ProductoDto id(Long Id){
        this.Id = Id;
        return this;
    }

    public ProductoDto nombre(String nombre){
        this.nombre =nombre;
        return this;
    }
    public ProductoDto precio(Double precio){

        this.precio =precio;

        return this;
    }
    
}
