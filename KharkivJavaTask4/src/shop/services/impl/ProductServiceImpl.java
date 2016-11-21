package shop.services.impl;

import shop.abstractBuilder.map.BuilderMap;
import shop.entity.product.Product;
import shop.repository.ProductRepository;
import shop.repository.factory.RepositoryFactory;
import shop.services.ProductService;

import java.util.Map;

/**
 * @author Arsalan
 * template shop.repository for product
 */
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private BuilderMap mapBuilder;

	public ProductServiceImpl(RepositoryFactory factory) {
		this.productRepository = factory.getProductRepository();
		this.mapBuilder = new BuilderMap();
	}

	@Override
	public void addProductToList(String productName, Map<String, Object> fields) {
		productRepository.getList().add(mapBuilder.getBuilderMap().get(productName).createInstance(fields));
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
