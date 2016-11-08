package chainResponsibility.handlers;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Said_Sulaiman_Arsala on 11/8/2016.
 * handles the request and search file by name
 */
public class HandlerByName extends RequestHandler {

    private String byName;

    public HandlerByName(String byName) {
        this.byName = byName;
    }

    public String getByName() {
        return byName;
    }

    @Override
    public List<File> handleRequest(List<File> fileList) {
        Iterator iterator = fileList.iterator();
        while (iterator.hasNext()){
            File file = (File) iterator.next();
            if(!file.getName().equals(getByName())){
                iterator.remove();
            }
        }
        if(successor != null){
            successor.handleRequest(fileList);
        }
        return fileList;
    }
}
