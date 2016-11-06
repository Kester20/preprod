package services;

import entity.product.Product;
import repository.ProductRepository;

/**
 * Created by Arsal on 03.11.2016.
 * template service for product
 */
public interface ProductService {

	/**
	 * gets product by id
	 *
	 * @param id product
	 * @return product
	 */
	public Product getProductById(int id);

	/**
	 * @return template repository for product
	 */
	public ProductRepository getProductRepository();
}
