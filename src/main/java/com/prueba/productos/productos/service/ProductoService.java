package com.prueba.productos.productos.service;

import java.util.List;

import com.prueba.productos.productos.dto.ProductoDto;

public interface ProductoService {
    

    List<ProductoDto>  consultar ();

    String modificar(ProductoDto productoDto);

    String alta(ProductoDto productoDto);

    String  eliminar(ProductoDto productoDto);

}
