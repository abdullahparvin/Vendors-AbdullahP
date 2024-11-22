import java.util.ArrayList;
public class VendorMarket {

    ArrayList<Vending> vendors = new ArrayList<>();

    VendorMarket(Vending vendor) {
        vendors.add(vendor);
    }

    void addVendor(Vending vendor) {
        vendors.add(vendor);
    }

    String printMarket() {
        StringBuilder marketInventory = new StringBuilder();
        for (Vending vendor: vendors){
            marketInventory.append(vendor.printInventory() + "\n");
        }
        return marketInventory.toString();
    }
}
