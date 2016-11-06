package services.impl;

import entity.product.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import services.ProductService;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl() {
		this.productRepository = new ProductRepositoryImpl();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.getProductById(id);
	}

	@Override
	public ProductRepository getProductRepository() {
		return productRepository;
	}

}
