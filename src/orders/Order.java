package orders;

import PaymentData.PaymentInformation;
import PaymentData.PaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Order {
    static int counter = 1;
    private int id;
    private List<Item> items;
    private PaymentMethod paymentMethod;
    private PaymentInformation paymentInformation;


    public Order() {
        id = counter++;
        items = new ArrayList<>();
        paymentInformation = new PaymentInformation();
    }

    public int getTotal()
    {
        int sum = 0;
        for(Item x:items)
        {
            sum+= x.getPrice();
        }
        return sum;
    }

    public void AddItem(Item item)
    {
        items.add(item);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }


}
