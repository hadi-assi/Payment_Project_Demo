import DB_Connection.Connection_postgres;
import PayService.PaymentService;
import generators.cardGenerator;
import generators.ordergenerator;
import PaymentData.PaymentInformation;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("hello to my payment system!\n");
        System.out.println("enter option number in all following options please\n");

//        generate cards


        System.out.println("1-pay\n2-see available cards\n3-done");

        cardGenerator g = new cardGenerator();

        PaymentService.cards = (Map<Long, PaymentInformation>) g.generate();
        Scanner scanner = new Scanner(System.in);


        int res = 1;
        res = scanner.nextInt();

        while(3 != res)
        {
            switch (res)
            {
                case 1 : ordergenerator.gen();break;
                case 2:
                    System.out.println("available cards:");
                    System.out.println(PaymentService.cards);
                    break;

                default:
                    System.out.println("bye");
                    break;
            }
            System.out.println("1-pay\n2-cards (see available cards)\n3-done");
            res = scanner.nextInt();

        }

//        Connection_postgres connectionPostgres = new Connection_postgres();
//        connectionPostgres.Start_connection();




    }
}