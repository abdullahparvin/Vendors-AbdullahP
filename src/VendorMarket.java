import java.util.ArrayList;

/**
 * Class for a Vending Market.  Contains a list of the available vendors in the market
 */
public class VendorMarket {

    ArrayList<Vending> vendors = new ArrayList<>();

    VendorMarket(Vending vendor) {
        vendors.add(vendor);
    }

    /**
     * adds vendor to the market
     *
     * @param vendor vendor to be added
     */
    void addVendor(Vending vendor) {
        vendors.add(vendor);
    }

    /**
     * displays inventory of all vendors in market
     *
     *
     */
    String printMarket() {
        StringBuilder marketInventory = new StringBuilder();
        for (Vending vendor: vendors){
            marketInventory.append(vendor.printInventory() + "\n");
        }
        return marketInventory.toString();
    }
}
