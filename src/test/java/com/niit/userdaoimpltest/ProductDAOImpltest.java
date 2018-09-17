package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.Product;
import com.niit.userdao.ProductDAO;

import junit.framework.TestCase;

public class ProductDAOImpltest extends TestCase
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");

	public void testFindAllProducts() 
	{
		List<Product> productList=productDAO.findAllProducts();
		
		assertNotNull(productList);	
		
	}

		public void testFindProductById() 
	{
		Product product1=productDAO.findProductById(1);
		assertNotNull(product1);
		int expectedId=1;
		int actualId=product1.getId();
		assertTrue(expectedId==actualId);	
	}

	public void testFindProductByName() 
	{
		Product product2=productDAO.findProductByName("shoes");
		assertNotNull(product2);
		String expectedName="shoes";
		String actualName=product2.getProductName();
		assertTrue(expectedName.equals(actualName));
		
	}

	public void testAddProduct() 
	{
		Product product=new Product();
		product.setId(2);
		product.setProductName("boots");
		product.setProductDescription("good");
		product.setProductSize(8);
		product.setProductQuantity(10);
		product.setProductPrice(100);
		assertEquals(true,productDAO.addProduct(product));
		
	}

	public void testUpdateProduct() 
	{
		Product product3=productDAO.findProductById(2);
		product3.setProductName("adidas");
		product3.setProductQuantity(10);
		productDAO.updateProduct(product3);
		assertTrue(product3.getProductQuantity()==10);
		
	}
	
	public void testDeleteProduct() 
	{
		Product product4=productDAO.findProductById(123);
		assertEquals(true,productDAO.deleteProduct(product4.getId()));
		
	}

}
