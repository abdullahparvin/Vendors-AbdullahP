import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {

    static Vending vendor;

    @BeforeEach
    public void setUp() {
        vendor = new Vending(10, 10);
    }

    @Test
    void addMoney() {
        vendor.addMoney(2.00);
        Assertions.assertEquals(2.00, vendor.getBalance());
    }

    @Test
    void addTooMuch() {
        vendor.addMoney(Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, vendor.getBalance());
    }

    @Test
    void addNegative() {
        vendor.addMoney(-2);
        Assertions.assertEquals(0, vendor.getBalance());
    }

    @Test
    void addTooLittle() {
        vendor.addMoney(Integer.MIN_VALUE);
        Assertions.assertEquals(0, vendor.getBalance());
    }

    @Test
    void buyOneCandyNoMoney() {
        String item = "Candy";
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(10, amount);
    }

    @Test
    void buyOneGumNoMoney() {
        String item = "Gum";
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(10, amount);
    }

    @Test
    void buyOneGum() {
        String item = "Gum";
        vendor.addMoney(0.5);
        Assertions.assertEquals(0.5, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(9, amount);
    }

    @Test
    void buyGumTooMuchMoney() {
        String item = "Gum";
        vendor.addMoney(2);
        Assertions.assertEquals(2, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(6, amount);
    }

    @Test
    void buyGumTooMuchMoneyWithChange() {
        String item = "Gum";
        vendor.addMoney(2.75);
        Assertions.assertEquals(2.75, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(5, amount);
    }

    @Test
    void buyEntireStockCandy() {
        String item = "Candy";
        vendor.addMoney(12.50);
        Assertions.assertEquals(12.50, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(0, amount);
    }

    @Test
    void buyEntireStockCandyTooMuchMoney() {
        String item = "Candy";
        vendor.addMoney(20);
        Assertions.assertEquals(20, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(0, amount);
    }



}