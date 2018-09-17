package com.niit.userdao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface ProductDAO {
public List<Product> findAllProducts();
public Product findProductById(int ProductId);
public Product findProductByName(String ProductName);
public boolean addProduct(Product product);
public boolean updateProduct(Product product);
public boolean deleteProduct(int productId);
List<Category> getAllCategories();
Product getProduct(int id);

}
