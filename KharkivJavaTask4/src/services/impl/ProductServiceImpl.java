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

	private RepositoryFactory repositoryFactory;
	private ProductRepository productRepository;

	public ProductServiceImpl() {
		this.repositoryFactory = new RepositoryFactory();
		this.productRepository = repositoryFactory.getProductRepository();
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
