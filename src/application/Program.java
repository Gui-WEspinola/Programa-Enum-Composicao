package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client Data:");
        System.out.print("Name: ");
        String clientName = scanner.nextLine();

        System.out.print("Email: ");
        String clientEmail = scanner.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scanner.next());

        Client costumer = new Client(clientName, clientEmail, birthDate); // Criado o cliente

        scanner.nextLine();
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String orderStatus = scanner.nextLine();

        System.out.print("How many items to this order? ");
        int itemNumber = scanner.nextInt();

        Order order = new Order(new Date(), OrderStatus.valueOf(orderStatus), costumer);

        for (int i = 0; i < itemNumber; i++) {
            scanner.nextLine();
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            String productName = scanner.nextLine();

            System.out.print("Product price: ");
            double productPrice = scanner.nextDouble();

            Product product = new Product(productName, productPrice);

            System.out.print("Quantity: ");
            Integer productQuantity = scanner.nextInt();

            OrderItem simpleOrder = new OrderItem(productQuantity, productPrice, product);

            order.addItem(simpleOrder);
        }
        System.out.println(order);
    }
}
