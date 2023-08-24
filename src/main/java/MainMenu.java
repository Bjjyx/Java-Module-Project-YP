import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);
    private Calculator calculator;

    //Стартовое меню
    public void start(){

        System.out.println("Приветствую UserName!\nНа скольких человек необходимо разделить счёт?");
        for(;;){

//            int peopleCount = scanner.nextInt();
            String peopleCountStr = scanner.next();
            if (peopleCountStr.matches("\\d*")){
                int peopleCount = Integer.parseInt(peopleCountStr);
                if (peopleCount <= 1){
                    System.out.println("Введено не корректное количество человек, пожалуйста попробуйте снова");
                } else {
                    calculator = new Calculator(peopleCount);
                    additionalMenu();
                    break;
                }
            } else {
                System.out.println("Ошибка ввода количества человек. необходимо ввести целое число");
            }

        }

    }
    //Дополнительное меню для работы непосредственно с калькулятором
    private void additionalMenu(){

        String command = "";

        while (!command.equalsIgnoreCase("Завершить")){

            addProduct();
            command = scanner.next();

        }

        showChequeAndProducts();

    }
    //Метод добавления товаров
    private void addProduct(){

        System.out.println("Введите название товара");
        String name = scanner.next();
        System.out.println("Введите стоимость товара");
        String costStr = scanner.next();
        if (costStr.matches("(\\d)*.(\\d)+")){
            double cost = Double.parseDouble(costStr);
            if (cost < 0.00){
                System.out.println("Введена не корректная сумма");
            } else {
                calculator.addProduct(name, cost);
                System.out.println("Товар успешно добавлен");
                System.out.println("Хотите добавить еще товар?\nДля продолжения введите любой символ\nДля завершения введите \"Завершить\"");
            }
        } else {
            System.out.println("Ошибка ввода суммы\nНеобходимо вводить числа с плавающей точкой, разделяя их запятой\nПопробуйте снова");
        }


    }
    //Выводим сумму на человека и название товаров
    private void showChequeAndProducts(){

        System.out.println("Добавленные товар:");
        calculator.getProductList();
        double cheque = calculator.peopleCheque();
        String message = "Сумма на человека %.2f %s";
        if (cheque < 1.00 || cheque >= 10.00){
            System.out.printf((message) + "%n", cheque, "рублей");
        } else if (cheque >= 1.00 && cheque < 2.00) {
            System.out.printf((message) + "%n", cheque, "рубль");
        } else if (cheque >= 2.00 && cheque < 10.00) {
            System.out.printf((message) + "%n", cheque, "рубля");
        }
    }

}
