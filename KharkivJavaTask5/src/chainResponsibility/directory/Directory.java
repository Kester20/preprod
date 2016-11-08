package chainResponsibility.directory;

import chainResponsibility.entity.Request;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 */
public class Directory {

    private List<File> resultList;

    public Directory() {
        resultList = new ArrayList<>();
    }

    public void fill(String directory) {
        File file = new File(directory);
        if (file.isDirectory()) {

            for (File temp : file.listFiles()) {
                if (temp.isDirectory()) {
                    File subFile = new File(temp.getAbsolutePath());
                    resultList.add(subFile);
                    fill(subFile.getAbsolutePath());
                }else {
                    resultList.add(temp);
                }
            }

        }
    }

    public List<File> getResultList() {
        return resultList;
    }
}
