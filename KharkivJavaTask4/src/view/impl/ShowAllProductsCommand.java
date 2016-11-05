package view.impl;

import storage.Products;
import view.Command;

/**
 * Created by Arsal on 05.11.2016.
 * template command for print list of products
 */
public class ShowAllProductsCommand implements Command {

    /**
     * shows all products
     */
    @Override
    public void exec() {
        System.out.println(Products.printList());
    }
}
