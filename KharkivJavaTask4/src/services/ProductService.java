package services;

import entity.product.Product;
import repository.ProductRepository;

import java.util.Map;

/**
 * @author Arsalan
 * template service for product
 */
public interface ProductService {

	/**
	 * adds product to product list
	 *
	 * @param fields fields, that will be sett to new product
	 */
	public void addProductToList(String productName, Map<String, Object> fields);

	/**
	 * adds product to product list
	 *
	 * @param product product, that will be added
	 */
	public void addProductToList(Product product);

	/**
	 * gets product by id
	 *
	 * @param id product's id
	 * @return product
	 */
	public Product getProductById(int id);

	/**
	 * @return repository
	 */
	public ProductRepository getProductRepository();
}
