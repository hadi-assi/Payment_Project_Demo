package PayService;

import PaymentData.PaymentInformation;

public class CashService extends PaymentService{

    @Override
    public void CheckValidity(PaymentInformation paymentInformation) {

    }

    @Override
    public void pay() {
        System.out.println("you paid with cash");
    }
}
