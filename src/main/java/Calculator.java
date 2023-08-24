import java.util.ArrayList;

public class Calculator {

    private final int peopleCount;
    private double chequeSum;
    private final ArrayList<Product> productArrayList = new ArrayList<>();


    Calculator(int peopleCount){
        this.peopleCount = peopleCount;
    }
    //Добавление продукта и подсчет суммы
    public void addProduct(String name, double cost){
        Product product = new Product(name, cost);
        productArrayList.add(product);
    }
    //Вывод списка товаров на экран
    public void getProductList(){
        productArrayList.forEach(product -> System.out.println(product.getName()));
    }
    //Подсчитывает и возвращает сумму, которую должен заплатить человек
    public double peopleCheque(){
        productArrayList.forEach(product -> chequeSum = chequeSum + product.getCost());
        return chequeSum/(double) peopleCount;
    }

}
