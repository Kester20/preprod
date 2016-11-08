package wrapper;

import java.io.*;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * class wrapper for reading file
 */
public class FireReaderWrapper {

    private String fileName;

    public FireReaderWrapper(String fileName) {
        this.fileName = fileName;
    }

    /**
     * reads file and displays content
     * @throws IOException
     */
    public void readFile() throws IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        for (int i = 0;  i < file.length(); i++){
            line = br.readLine();
            if(line == null){
                break;
            }
            System.out.println(line);
        }
        br.close();
    }
}
