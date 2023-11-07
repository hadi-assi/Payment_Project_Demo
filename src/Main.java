import PayService.PaymentService;
import generators.cardGenerator;
import generators.ordergenerator;
import PaymentData.PaymentInformation;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello to my payment system!");

        //generate cards


        System.out.println("1-pay\n2-cards (see available cards)\n3-done");

        cardGenerator g = new cardGenerator();

        PaymentService.cards = (Map<Long, PaymentInformation>) g.generate();
        Scanner scanner = new Scanner(System.in);


        String res;
        res = scanner.next();

        while(!res.equals("done"))
        {
            switch (res)
            {
                case "pay" : ordergenerator.gen();break;
                case "cards":
                    System.out.println("available cards:");
                    System.out.println(PaymentService.cards);
                    break;

                default:
                    System.out.println("bye");
                    break;
            }
            System.out.println("1-pay\n2-cards (see available cards)\n3-done");
            res = scanner.next();

        }




    }
}