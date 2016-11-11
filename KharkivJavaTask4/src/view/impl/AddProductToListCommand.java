package view.impl;

import services.ReaderProductService;
import view.Command;

import java.text.ParseException;

/**
 * Created by Said_Sulaiman_Arsala on 11/10/2016.
 * template for add to list of products
 */
public class AddProductToListCommand implements Command {

    private ReaderProductService readerProductService;

    public AddProductToListCommand(ReaderProductService readerProductService) {
        this.readerProductService = readerProductService;
    }

    /**
     * reads products and adds them to the list
     *
     * @throws ParseException
     */
    @Override
    public void exec() throws ParseException {
        //System.out.println("ENTER THE PRODUCT NAME");
        readerProductService.read();
    }
}
