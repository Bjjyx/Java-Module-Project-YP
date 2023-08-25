import java.util.Scanner;

public class MainMenu {
    private Calculator calculator;

    //Стартовое меню
    public void start(){

        System.out.println("Приветствую UserName!\nНа скольких человек необходимо разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        for(;;){
            try{
                int peopleCount = scanner.nextInt();
                if (peopleCount <= 1){
                    System.out.println("Введено не корректное количество человек, пожалуйста попробуйте снова");
                } else {
                    calculator = new Calculator(peopleCount);
                    additionalMenu();
                    break;
                }
            } catch (Exception e){
                System.out.println("Ошибка ввода. Необходимо ввести целое число");
                scanner.nextLine();
            }
        }

    }
    //Дополнительное меню для работы непосредственно с калькулятором
    private void additionalMenu(){

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equalsIgnoreCase("Завершить")){

            calculator.addProduct(addProductName(), addProductCost());
            command = scanner.next();

        }

        showChequeAndProducts();

    }
    //Метод для передачи названия товара
    private String addProductName(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара");
        return scanner.nextLine();

    }
    //Метод для передачи стоимости товара
    private double addProductCost(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите стоимость");
        for(;;) {
            try {
                double cost = scanner.nextDouble();
                if (cost <= 0) {
                    System.out.println("Введена не корректная сумма, попробуйте ещё раз");
                } else {
                    System.out.println("Товар успешно добавлен");
                    System.out.println("Хотите добавить еще товар?\nДля продолжения введите любой символ\nДля завершения введите \"Завершить\"");
                    return cost;
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода суммы\nНеобходимо вводить числа с плавающей точкой, разделяя их запятой или целое число\nПопробуйте снова");
                scanner.nextLine();
            }
        }
    }
    //Выводим сумму на человека и название товаров
    private void showChequeAndProducts(){

        System.out.println("Добавленные товар:");
        calculator.getProductList();
        double cheque = calculator.peopleCheque();
        String message = "Сумма на человека %.2f %s";
        if (((int) cheque % 100) > 10 && ((int) cheque % 100 < 15)){
            System.out.printf((message) + "%n", cheque, "рублей");
        } else {
            switch ((int) cheque % 10) {
                case (1) -> System.out.printf((message) + "%n", cheque, "рубль");
                case (2), (3), (4) -> System.out.printf((message) + "%n", cheque, "рубля");
                default -> System.out.printf((message) + "%n", cheque, "рублей");
            }
        }
    }

}
