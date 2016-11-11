package wrapper;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Arsalan
 *         class wrapper for reading file
 */
public class FileReaderWrapper implements Iterable {

    private String fileName;

    public FileReaderWrapper(String fileName) {
        this.fileName = fileName;
    }

    /**
     * reads file and displays content
     *
     * @throws IOException
     */
    public void readFile() throws IOException {
        Iterator iterator = new FileIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Override
    public Iterator iterator(){
        return new FileIterator();
    }

    private class FileIterator implements Iterator<String> {
        Scanner scanner;

        public FileIterator() {
            try {
                scanner = new Scanner(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }
    }
}
