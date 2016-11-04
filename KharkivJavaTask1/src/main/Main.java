package main;

import container.Container;
import entity.Laptop;
import entity.Product;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Container container = new Container();
        Product  a = new Product("A",15000);
        Product  b = new Product("B",17000);
        Product  c = new Product("C",10000);
        Product  d = new Product("D",12000);

        container.add(a);
        container.add(b);
        container.add(c);
        container.add(d);

       /* Product[] p = new Product[4];
        p[0] = a;
        p[1] = b;
        p[2] = c;
        p[3] = d;



        for (Product i:p) {
            System.out.println(i);
        }*/
        
        /*Collection collection = new Container();
        collection.add("66");
        collection.add("66");
        collection.add("66");
        collection.add("66");
        System.out.println(collection);*/

        //container.addAll(2,collection);
        //Iterator<Object> it = container.filterIteratorByCost(true,10000);
        //Iterator<Object> it = container.filterIteratorByName("C");
        Iterator<Object> it = container.iterator();



        System.out.println("---------------\nOut of iterator:");
        /*while (true){
            System.out.print(it.next() + " ");
        }*/
        for (int i =0; i < container.size() + 1; i ++){
            System.out.println(it.next() + " " + i + " " +  container.size() + "\n");
        }
    }
}
