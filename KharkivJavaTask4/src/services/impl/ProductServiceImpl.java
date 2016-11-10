package services.impl;

import entity.product.Product;
import repository.ProductRepository;
import repository.factory.RepositoryFactory;
import repository.impl.ProductRepositoryImpl;
import services.ProductService;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	public ProductServiceImpl(RepositoryFactory factory) {
		this.productRepository = factory.getProductRepository();
	}

	@Override
	public void addProductToList(Product product) {
		productRepository.getList().add(product);
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
