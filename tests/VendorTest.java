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



}