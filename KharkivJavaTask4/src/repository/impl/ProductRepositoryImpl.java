package repository.impl;

import entity.product.Laptop;
import entity.product.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arsal on 03.11.2016.
 * template repository for product
 */
public class ProductRepositoryImpl implements ProductRepository {

	/**
	 * List of products
	 */
	private static List<Product> list = new ArrayList<Product>() {{
		add(new Laptop(0, "Aer1", 15000, "Acer", 15.6));
		add(new Laptop(1, "Bvc", 10000, "Samsung", 15.6));
		add(new Laptop(2, "NBc", 25000, "Apple", 15.6));
		add(new Laptop(3, "ART", 15000, "Asus", 15.6));
		add(new Laptop(4, "Aqq", 20000, "Dell", 15.6));
		add(new Laptop(5, "Aqq", 20000, "Dell", 15.6));
		add(new Laptop(6, "Aqq", 20000, "Dell", 15.6));
		add(new Laptop(7, "Aqq", 20000, "Dell", 15.6));
	}};

	/**
	 * @return list of products
	 */
	public static List<Product> getList() {
		return list;
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
