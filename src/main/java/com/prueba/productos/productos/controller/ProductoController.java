package com.prueba.productos.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.productos.productos.dto.ProductoDto;
import com.prueba.productos.productos.service.ProductoService;

@RestController
@RequestMapping("/products")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    
    @GetMapping( value = "/consultar" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  List<ProductoDto> consultar(){
        return  productoService.consultar();
    }


    @PostMapping( value = "/alta" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String alta( ProductoDto productoDto){
        return  productoService.alta(productoDto);
    
    }

    @PutMapping( value = "/modificar" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String alta( @RequestBody ProductoDto productoDto , @RequestParam(name = "id") Long id     ){
        return  productoService.modificar(productoDto.id(id));
    
    }

    @PostMapping( value = "/eliminar" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public  String alta( @RequestParam(name = "id") Long id ){
        return  productoService.eliminar(new ProductoDto().id(id));

    }    


}
