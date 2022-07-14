package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    private List<OrderItem> itemsList = new ArrayList<>();

    public void addItem(OrderItem item) {
        itemsList.add(item);
    }

    public void removeItem(OrderItem item) {
        itemsList.remove(item);
    }

    public Double total() {
        Double total = 0.0;
        for (OrderItem o : itemsList) {
            total += o.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nORDER SUMMARY:\n");
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("OrderStatus: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order Items: \n");
        for (OrderItem o : itemsList) {
            sb.append(o.toString() + "\n");
        }
        sb.append("Total Price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}

