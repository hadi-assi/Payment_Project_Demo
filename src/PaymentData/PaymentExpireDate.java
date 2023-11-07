package PaymentData;

import java.time.Year;
import java.util.Calendar;
import java.util.Scanner;

public class PaymentExpireDate {
    private byte month;
    private short year;

    public void CheckValidity()
    {
        Calendar cal = Calendar.getInstance();
        int Currentyear = cal.get(Calendar.YEAR);
        int CurrentMonth = cal.get(Calendar.MONTH) + 1;
        if(year < Currentyear || (year == Currentyear && month<CurrentMonth))
        throw new IllegalStateException("your card is expired");
    }

    public void GetDateFromUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter card expiry Date(m yyyy)");
        month = scanner.nextByte();
        year = scanner.nextShort();
    }


    public byte getMonth() {
        return month;
    }

    public void setMonth(byte month) {
        this.month = month;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }
}
