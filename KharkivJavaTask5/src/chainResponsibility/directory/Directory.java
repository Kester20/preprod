package chainResponsibility.directory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Arsalan
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
                    resultList.add(temp);
                    fill(temp.getAbsolutePath());
                } else {
                    resultList.add(temp);
                }
            }

        }
    }

    /**
     * @return result list
     */
    public List<File> getResultList() {
        return resultList;
    }
}
