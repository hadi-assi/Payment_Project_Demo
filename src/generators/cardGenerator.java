package generators;

import PaymentData.PaymentExpireDate;
import PaymentData.PaymentInformation;

import java.util.*;

public class cardGenerator {

    public Map<Long, PaymentInformation> generate()
    {
        Map<Long, PaymentInformation> l = new HashMap<>();
        for(int i=0 ;i<10;i++){
            PaymentInformation p = generatecard();
            l.put(p.getCardNumber() , p);
        }
        return l;

    }
    public PaymentInformation generatecard()
    {
        PaymentInformation paymentInformation = new PaymentInformation();

        Random rand = new Random();
        paymentInformation.setCardholderName("abd");

        paymentInformation.setCvv((short) (rand.nextInt(999 - 100 + 1) + 100));//100-999
        paymentInformation.setCardNumber(rand.nextLong((long) (1e16-1 - 1e15 + 1)) + (long)1e15);

        PaymentExpireDate paymentExpireDate = new PaymentExpireDate();
        paymentExpireDate.setYear((short)rand.nextInt(3000));
        paymentExpireDate.setMonth((byte) (rand.nextInt(11)+1));

        paymentInformation.setExpireDate(paymentExpireDate);
        return paymentInformation;
    }
}
