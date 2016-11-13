package repository;

import entity.product.Product;

import java.util.List;

/**
 * @author Arsalan
 * template repository for product
 */
public interface ProductRepository {

	/**
	 * @return list of products
	 */
	public List<Product> getList();

	/**
	 * sets the list of products to specific list
	 * @param list list of products
	 */
	public void setList(List<Product> list);

	/**
	 * @param id product
	 * @return product by id
	 */
	public Product getProductById(int id);

}
