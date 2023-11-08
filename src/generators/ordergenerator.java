package generators;

import DB_Connection.Connection_postgres;
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
            order.getPaymentInformation().GetFromUser();






        System.out.println("Enter one of those choices: \n1- add item\n2-see available items\n3-done");
        int value = 1;
        value = scanner.nextInt();


        while (3 != value) {

            switch (value)
            {
                case 1:{
                    Item item = new Item();
                    item.GetData();
                    order.AddItem(item);
                }break;
                case 2:
                {
                    Connection_postgres.queryitems();
                }break;
                default:break;
            }



            System.out.println("Enter one of those choices: \n1- add item\n2-see available items\n3-done");
            value = scanner.nextInt();
        }

        //adding items is done



        System.out.println("your total is " + order.getTotal());
        paymentService.pay();



    }

}
