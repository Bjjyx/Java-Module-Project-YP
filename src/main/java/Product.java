public class Product {

    private final String name;
    private final double cost;

    Product(String name, double cost){
        this.cost = cost;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public double getCost(){
        return cost;
    }

}
