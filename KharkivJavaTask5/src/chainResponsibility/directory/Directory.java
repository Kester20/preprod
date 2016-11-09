package chainResponsibility.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * contains all files in specific directory
 */
public class Directory {

    private List<File> resultList;

    /**
     * initialize list of files
     */
    public Directory() {
        resultList = new ArrayList<>();
    }

    /**
     * fill the list of files
     *
     * @param directory - specific directory
     */
    public void fill(String directory) {
        File file = new File(directory);
        if (file.isDirectory()) {
            for (File temp : file.listFiles()) {
                if (temp.isDirectory()) {
                    File subFile = new File(temp.getAbsolutePath());
                    resultList.add(subFile);
                    fill(subFile.getAbsolutePath());
                } else {
                    resultList.add(temp);
                }
            }

        }
    }

    /**
     * @return list of files
     */
    public List<File> getResultList() {
        return resultList;
    }
}
