package com.prueba.productos.productos;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.prueba.productos.productos.dto.ProductoDto;
import com.prueba.productos.productos.service.ProductoService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProductosApplicationTests {

	@Autowired
	ProductoService productoService;		 	

	@Test
	@Order(1)
	void createProduct_ok_result  () {

		String result = productoService.alta(new ProductoDto().nombre(" leche").precio(10.0)  );
		Assert.hasText(result,"OK");
	}


	@Test
	@Order(1)
	void modifyProduct_Ok_result()
	{
		String result = productoService.modificar(new ProductoDto().id(1L).nombre(" leche").precio(10.0)  );
		Assert.hasText(result,"OK");		
	}

	@Test
	@Order(3)
	void listProducts_And_ConttainsItem()
	{
		  
		Assert.hasText(productoService.consultar().get(0).getNombre(), " leche"); 		
	}


	@Test
	@Order(4)
	void  deleteItem_Ok_Result()
	{
		  
		 
		Assert.hasText(productoService.eliminar( new ProductoDto().id(1L) ),"OK");
	}




}
