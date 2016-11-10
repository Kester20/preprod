package services.impl;

import abstractFactory.map.MapFactory;
import services.ProductService;
import services.ReaderProductService;

import java.util.Scanner;

/**
 * Created by Arsal on 10.11.2016.
 * reads products from console
 */
public class ReaderProductFromConsoleServiceImpl implements ReaderProductService {

	private ProductService productService;
	private MapFactory mapFactory;

	/**
	 * initializes fields
	 * @param productService product service
	 * @param mapFactory map factory
	 */
	public ReaderProductFromConsoleServiceImpl(ProductService productService, MapFactory mapFactory) {
		this.productService = productService;
		this.mapFactory = mapFactory;
	}

	@Override
	public void read() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of product:");
		productService.addProductToList(mapFactory.getFactoryMap().get(scanner.next()).createInstance(0));
	}
}
