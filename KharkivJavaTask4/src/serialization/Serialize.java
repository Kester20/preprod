package serialization;

import entity.product.Product;
import repository.ProductRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Arsal on 09.11.2016.
 * serializes list of product
 */
public class Serialize {

	public static void serialize(ProductRepository productRepository) throws IOException {
		OutputStream fos = new FileOutputStream("ser.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(productRepository.getList());
		oos.flush();
		oos.close();
	}

	public static List<Product> deSerialize(String fileName) throws IOException, ClassNotFoundException {
		InputStream fis = new FileInputStream(fileName);
		ObjectInputStream oin = new ObjectInputStream(fis);
		List<Product> list = (ArrayList<Product>) oin.readObject();
		return list;
	}

	public static void serializeSeveralTimes(ProductRepository productRepository, int times) throws IOException {
		OutputStream fos = new FileOutputStream("serSeveralTimes.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		for (int i = 0; i < times; i++) {
			oos.writeObject(productRepository.getList());
		}
		oos.flush();
		oos.close();
	}

	public static void saveGZip(String filename) throws IOException {
		byte[] buffer = new byte[1024];

		GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream("ser.gz"));

		FileInputStream fileInputStream = new FileInputStream("serSeveralTimes.out");
		int len;
		while ((len = fileInputStream.read(buffer)) > 0) {
			gZIPOutputStream.write(buffer, 0, len);
		}
		fileInputStream.close();
		gZIPOutputStream.finish();
		gZIPOutputStream.close();

	}

}
