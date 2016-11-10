package serialization;

import entity.product.Laptop;
import org.junit.Before;
import org.junit.Test;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 */
public class SerializeTest {

    private ProductRepository productRepository;

    @Before
    public void initial(){
        productRepository = new ProductRepositoryImpl();
        productRepository.getList().add(new Laptop(55,"a",55,"aa", 15.6));
    }

    @Test
    public void testSerializeSeveralTimes() throws IOException {
        Serialize.serializeSeveralTimes(productRepository, 15000);
        File file = new File(Serialize.getFileNameSeveralSer());
        assertTrue(file.exists());
    }

    @Test
    public void testSavesToArchive() throws IOException {
        Serialize.saveGZip();
        File file = new File(Serialize.getFileNameGzip());
        assertTrue(file.exists());
    }

}