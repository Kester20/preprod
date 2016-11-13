package serialization;

import entity.product.Product;
import repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * @author Arsalan
 *         serializes list of product
 */
public class Serialize {

	private static final String FILE_NAME_SER = "ser.out";
	private static final String FILE_NAME_SEVERAL_SER = "serSeveralTimes.out";
	private static final String FILE_NAME_GZIP = "ser.gz";
	private static final int THOUSAND = 1000;
	private static final int ZERO = 0;

	/**
	 * serializes object
	 *
	 * @param productRepository the repository, which contains list, than will be serialized
	 * @throws IOException
	 */
	public static void serialize(ProductRepository productRepository) throws IOException {
		try (OutputStream fos = new FileOutputStream(FILE_NAME_SER);
		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(productRepository.getList());
		}
	}

	/**
	 * @param fileName file name, where it will go deserialization
	 * @return list of products
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static List<Product> deSerialize(String fileName) throws IOException, ClassNotFoundException {
		List<Product> list;
		try (InputStream fis = new FileInputStream(fileName);
		     ObjectInputStream oin = new ObjectInputStream(fis);) {
			list = (ArrayList<Product>) oin.readObject();
		}
		return list;
	}

	/**
	 * serializes object several times
	 *
	 * @param productRepository the object to be serialized
	 * @param times             - the number of times
	 * @throws IOException
	 */
	public static void serializeSeveralTimes(ProductRepository productRepository, int times) throws IOException {
		try (OutputStream fos = new FileOutputStream(FILE_NAME_SEVERAL_SER);
		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			for (int i = 0; i < times; i++) {
				oos.writeObject(productRepository.getList());
			}
		}
	}

	/**
	 * saves file to archive
	 *
	 * @throws IOException
	 */
	public static void saveGZip() throws IOException {
		byte[] buffer = new byte[THOUSAND];
		try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(FILE_NAME_GZIP));
		     FileInputStream fileInputStream = new FileInputStream(FILE_NAME_SEVERAL_SER)) {
			int len;
			while ((len = fileInputStream.read(buffer)) > ZERO) {
				gZIPOutputStream.write(buffer, ZERO, len);
			}
		}
	}

	/**
	 * @return the name of the file, which was held serialization
	 */
	public static String getFileNameSer() {
		return FILE_NAME_SER;
	}

	/**
	 * @return the name of the file, which was held serialization several times
	 */
	public static String getFileNameSeveralSer() {
		return FILE_NAME_SEVERAL_SER;
	}

	/**
	 * @return the name of the GZip archive
	 */
	public static String getFileNameGzip() {
		return FILE_NAME_GZIP;
	}
}
