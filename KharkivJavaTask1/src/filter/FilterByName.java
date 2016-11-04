package filter;

import entity.Product;

public class FilterByName implements Filter<Product> {

    private String name;

    /**
     *
     * @param name of producer of the product
     */
    public FilterByName(String name){
        this.name = name;
    }

    /**
     *
     * @param element the element to be matched against the filter
     * @return
     */
    @Override
    public boolean matches(Product element) {
        return check(element);
    }

    public boolean check(Product element){

        if(element.getName().equals(name)){
            return true;
        }
        return false;
    }
}
