package PayService;

import orders.Order;
import PaymentData.PaymentInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PaymentService {



    public static Map<Long, PaymentInformation> cards = new HashMap<>();
    protected static final List<Order> orders = new ArrayList<>();
    protected static final List<Order> visaOrders = new ArrayList<>();
    protected static final List<Order> mastercardOrders = new ArrayList<>();

    public abstract void CheckValidity(PaymentInformation paymentInformation);

    public abstract void pay();


}
