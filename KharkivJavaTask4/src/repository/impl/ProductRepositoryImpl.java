package repository.impl;

import entity.product.Product;
import repository.ProductRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public class ProductRepositoryImpl implements ProductRepository, Serializable {

	/**
	 * List of products
	 */
	private List<Product> list = new ArrayList();

	@Override
	public List<Product> getList() {
		return list;
	}

	@Override
	public void setList(List<Product> list) {
		this.list = list;
	}

	@Override
	public Product getProductById(int id) {
		Product product = null;
		for (Product p : getList()) {
			if (p.getId() == id) {
				product = p;
				break;
			}
		}
		return product;
	}
}
