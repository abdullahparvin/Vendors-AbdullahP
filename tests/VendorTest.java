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

    @Test
    void restockCandy5() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.restock(5);
        Assertions.assertEquals(15, product.getStock());
    }

    @Test
    void restockCandy10() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.restock(10);
        Assertions.assertEquals(20, product.getStock());
    }

    @Test
    void restockCandyNegative20() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.restock(-20);
        Assertions.assertEquals(10, product.getStock());
    }

    @Test
    void restockCandyTooMuch() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.restock(Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MAX_VALUE, product.getStock());
    }

    @Test
    void restockCandyTooLittle() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.restock(Integer.MIN_VALUE);
        Assertions.assertEquals(10, product.getStock());
    }

    @Test
    void autoRestockGumWhenEmpty() {
        String item = "Gum";
        vendor.addMoney(5);
        Assertions.assertEquals(5, vendor.getBalance());
        vendor.purchase(item);
        Item product = vendor.getStock(item);
        int amount = product.getStock();
        Assertions.assertEquals(0, vendor.getBalance());
        Assertions.assertEquals(10, amount);
    }

    @Test
    void ChangeGumName() {
        String item = "Gum";
        Item product = vendor.getStock(item);
        product.setName("Trident Gum");
        Assertions.assertEquals("Trident Gum", product.getName());
    }

    @Test
    void ChangeCandyName() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        product.setName("Snickers");
        Assertions.assertEquals("Snickers", product.getName());
    }

    @Test
    void NoChangeCandyName() {
        String item = "Candy";
        Item product = vendor.getStock(item);
        Assertions.assertEquals("Candy", product.getName());
    }

    @Test
    void showAllVendors() {
        Vending vendor1 = new Vending(5, 0);
        Vending vendor2 = new Vending(10, 2);
        Vending vendor3 = new Vending(1, 3);
        Vending vendor4 = new Vending(2, 2);
        Vending vendor5 = new Vending(8, 9);

        VendorMarket market = new VendorMarket(vendor1);
        market.addVendor(vendor2);
        market.addVendor(vendor3);
        market.addVendor(vendor4);
        market.addVendor(vendor5);

        StringBuilder expectedInventory = new StringBuilder();
        expectedInventory.append(vendor1.printInventory()).append("\n");
        expectedInventory.append(vendor2.printInventory()).append("\n");
        expectedInventory.append(vendor3.printInventory()).append("\n");
        expectedInventory.append(vendor4.printInventory()).append("\n");
        expectedInventory.append(vendor5.printInventory()).append("\n");

        String expected = expectedInventory.toString().trim();
        String actual = market.printMarket().trim();

        assertEquals(expected, actual);
    }










}