import java.util.HashMap;


/**
 * Class for a Vending Machine.  Contains a hashtable mapping item names to item data, as
 * well as the current balance of money that has been deposited into the machine.
 */
class Vending {
    private static HashMap<String, Item> Stock = new HashMap<String, Item>();
    private double balance;

    Vending(int numCandy, int numGum) {
        Stock.put("Candy", new Item(1.25, numCandy, false, "Candy"));
        Stock.put("Gum", new Item(.5, numGum, true, "Gum"));
        this.balance = 0;
    }

    /**
     * resets the Balance to 0
     */
    void resetBalance() {
        this.balance = 0;
    }

    /**
     * returns the current balance
     */
    double getBalance() {
        return this.balance;
    }

    /**
     * adds money to the machine's balance
     *
     * @param amt how much money to add
     */
    void addMoney(double amt) {
        if (amt > 0) {
            this.balance = this.balance + amt;
        }

        if (this.balance < 0) {
            balance = Integer.MAX_VALUE;
        }
    }

    /**
     * attempt to purchase named item.  Message returned if
     * the balance isn't sufficient to cover the item cost.
     *
     * @param name The name of the item to purchase ("Candy" or "Gum")
     */
    void purchase(String name) {
        if (Stock.containsKey(name)) {
            Item item = Stock.get(name);
            if (balance >= item.price) {
                int amount = (int) (balance / item.price);
                if (item.getStock() >= amount) {
                    item.purchase(amount);
                    System.out.println("You bought " + amount + " " + name);
                    this.balance = this.balance - (item.price * amount);
                } else {
                    int stock = item.getStock();
                    item.purchase(item.getStock());
                    System.out.println("You bought " + stock + " " + name);
                    this.balance = this.balance - (item.price * stock);
                }
                if (this.balance > 0) {
                    System.out.println("Here's your change: " + this.balance);
                    resetBalance();
                }
            } else
                System.out.println("Gimme more money");
        } else System.out.println("Sorry, don't know that item");
    }

    /**
     * return item from stock
     *
     * @param item the item being retrived
     */
    Item getStock(String item) {
        return Stock.get(item);
    }

    /**
     * prints inventory information
     *
     *
     */
    String printInventory() {
        StringBuilder inventory = new StringBuilder();
        for (String key : Stock.keySet()) {
            Item product = Stock.get(key);
            inventory.append(product.DetailsToString());
        }
        return inventory.toString();

    }


    /**
     *removes item from stock
     *
     * @param name product to be removed
     */
    void removeItem(String name) {
        Stock.remove(name);
    }

    /**
     * gets information on the best selling item
     *
     *
     */
    String getBestSeller() {
        Item mostPopular = null;
        for (Item item : Stock.values()) {
            if (mostPopular == null || item.getPurchaseCount() > mostPopular.getPurchaseCount()) {
                mostPopular = item;
            }
        }
        return mostPopular != null ? mostPopular.name : "No purchases yet.";
    }

    /**
     * gives a summary of customer purchases
     *
     *
     */
    String getPurchaseSummary() {
        StringBuilder summary = new StringBuilder("Purchase Summary:\n");
        for (String key : Stock.keySet()) {
            Item item = Stock.get(key);
            summary.append(item.name).append(": Purchased ").append(item.getPurchaseCount()).append("\n");
        }
        return summary.toString();
    }
}

class Examples {
}

