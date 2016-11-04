package filter;

import entity.Product;


public class FilterByCost implements Filter<Product> {

    private boolean more;
    private double criterion;

    /**
     *
     * @param more look for more or less than the specified criteria(true - more, false - less)
     * @param criterion look for more or less then criterion
     */
    public FilterByCost(boolean more, double criterion){
        this.more = more;
        this.criterion = criterion;
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
        if(more){
            if(element.getCost() > criterion){
                return  true;
            }
        }else{
            if(element.getCost() < criterion){
                return  true;
            }
        }
        return false;
    }

}
