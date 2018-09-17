package com.niit.userdaoimpltest;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.model.Category;
import com.niit.userdao.CategoryDAO;

import junit.framework.TestCase;

public class CategoryDAOImpltest extends TestCase
{
	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	

	public void testFindAllCategories()
	{
		List<Category> categoryList=categoryDAO.findAllCategories();
		assertNotNull(categoryList);
		
	}

	public void testFindCategoryById() 
	{
		Category category1=categoryDAO.findCategoryById(1);
		assertNotNull(category1);
		int  expectedId=1;
		int actualId=category1.getCategoryId();
		assertTrue(expectedId==actualId);
		
	}

	public void testFindCategoryByName() 
	{
		Category category2=categoryDAO.findCategoryByName("kid");
		assertNotNull(category2);
		String expectedName="kid";
		String actualName=category2.getCategoryName();
		assertTrue(expectedName.equals(actualName));
		
	}

	public void testAddCategory() 
	{
		Category category=new Category();
		category.setCategoryId(4);
		category.setCategoryName("womens");

		assertEquals(true,categoryDAO.addCategory(category));
		
	}

	public void testUpdateCategory()
	{
		Category category3=categoryDAO.findCategoryById(4);
		category3.setCategoryName("women");
		categoryDAO.updateCategory(category3);
		String expectedName="women";
		assertTrue(expectedName.equals(category3.getCategoryName()));
		
	}

	public void testDeleteCategory() 
	{
		Category category4=categoryDAO.findCategoryById(78);
		assertEquals(true,categoryDAO.deleteCategory(category4.getCategoryId()));                                  
		
	}

}
     