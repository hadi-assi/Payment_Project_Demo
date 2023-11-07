package PaymentData;

import PayService.PaymentService;
import PaymentData.PaymentExpireDate;

import java.util.Scanner;

public class PaymentInformation {

    private String cardholderName;
    private short cvv;
    private PaymentExpireDate expireDate;
    private long CardNumber;

    public PaymentInformation() {
        expireDate = new PaymentExpireDate();
    }

    public void CheckLen()
    {
        String s = String.valueOf(CardNumber);
        int len = s.length();
        if(len!=16)
        {
            throw new IllegalStateException("card number should be 16 digits long");
        }
    }
    public void CheckExpiry()
    {
        expireDate.CheckValidity();
    }

    public void CheckAvailability(){
        if(!PaymentService.cards.containsKey(CardNumber))throw new IllegalStateException("card not in system");
    }

    public void GetFromUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter cardholder name");
        cardholderName = scanner.next();

        System.out.println("enter card number");
        CardNumber = scanner.nextLong();
        CheckLen();

        System.out.println("enter card cvv");
        cvv = scanner.nextShort();

        expireDate.GetDateFromUser();
        CheckExpiry();
        //check if card is available
        CheckAvailability();

    }





    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public PaymentExpireDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(PaymentExpireDate expireDate) {
        this.expireDate = expireDate;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.CardNumber = cardNumber;
    }
}
