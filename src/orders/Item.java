package orders;

import java.util.Scanner;

public class Item {
    static int itemId = 1;
    private int id;
    private String name;
    private int price;

    public void GetData()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Item name");
        setName(scanner.next());
        System.out.println("Enter Item Price");
        setPrice(scanner.nextInt());
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
