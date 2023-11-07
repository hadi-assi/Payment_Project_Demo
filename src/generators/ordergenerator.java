package generators;

import PayService.CashService;
import PayService.MasterCardService;
import PayService.PaymentService;
import PayService.VisaService;
import PaymentData.PaymentMethod;
import orders.Item;
import orders.Order;

import java.util.Scanner;

public class ordergenerator {

    public static void gen(){


        Order order = new Order();

        PaymentMethod paymentMethod;


        System.out.println("enter your payment method (CASH , VISA , MASTERCARD)");
        Scanner scanner = new Scanner(System.in);

        paymentMethod = PaymentMethod.valueOf(scanner.next());

        PaymentService paymentService;
        switch (paymentMethod)
        {
            case PaymentMethod.VISA: paymentService = new VisaService();break;
            case PaymentMethod.MASTERCARD: paymentService = new MasterCardService();break;
            case PaymentMethod.CASH: paymentService = new CashService();break;
            default: throw  new IllegalStateException("no such payment method");

        }
        if(paymentMethod != PaymentMethod.CASH)
        {
            order.getPaymentInformation().GetFromUser();
            order.getPaymentInformation().CheckAvailability();
        }





        System.out.println("Enter one of those choices: \n1- Add item\n2- Done");
        String value = "add";
        value = scanner.next();

        while (!value.equals("done")) {
            Item item = new Item();
            item.GetData();
            order.AddItem(item);

            System.out.println("Enter one of those choices: \n1-Add\n2-Done");
            value = scanner.next();
        }

        //adding items is done



        System.out.println("your total is " + order.getTotal());
        paymentService.pay();



    }

}
