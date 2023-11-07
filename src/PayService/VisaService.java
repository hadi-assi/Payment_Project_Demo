package PayService;

import PaymentData.PaymentInformation;

public class VisaService extends PaymentService{

    @Override
    public void CheckValidity(PaymentInformation paymentInformation)
    {
        paymentInformation.CheckLen();
        paymentInformation.CheckExpiry();
    }

    @Override
    public void pay() {
        System.out.println("you paid using Visa service");
    }
}
