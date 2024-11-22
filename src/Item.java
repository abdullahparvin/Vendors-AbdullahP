class Item {
    double price;
    int stock;

    boolean autoRestock;

    String name;

    int purchaseCount;

    Item(double price, int numPieces, boolean restockable, String name) {
        this.price = price;
        this.stock = numPieces;
        this.autoRestock = restockable;
        this.name = name;
        this.purchaseCount = 0;
    }

    /**
     * restocks an item
     *
     * @param amount how much product of an item to restock
     */
    void restock(int amount) {
        if (amount > 0) {
            this.stock = this.stock + amount;
        }

        if(this.stock < 0) {
            stock = Integer.MAX_VALUE;
        }
    }

    /**
     * simulates product purchase
     *
     * @param amount how much is being purchased
     */
    void purchase(int amount) {
        this.stock = this.stock - amount;
        purchaseCount += amount;
        if(this.autoRestock) {
            checkStock();
        }
    }

    /**
     * returns the amount of stock available
     *
     *
     */
    int getStock () {
        return stock;
    }

    /**
     * checks if the stock is empty
     *
     *
     */
    void checkStock () {
        if (this.stock == 0) {
            restock(10);
        }
    }


    /**
     * sets whether a product should be autorestocked
     *
     *
     */
    public void setAutoRestock(boolean autoRestock) {
        this.autoRestock = autoRestock;
    }

    /**
     * returns name of product
     *
     *
     */
    String getName () {
        return name;
    }


    /**
     * sets name of product
     *
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns details of the product: price and quantity
     *
     *
     */
    String DetailsToString() {
        return name + ":" + price + "$ Quantity: " + stock;
    }

    /**
     * returns the number of times product has been purchased
     *
     *
     */
    public int getPurchaseCount() {
        return purchaseCount;
    }


    /**
     * reduces the price of an item
     *
     *@param percentage how much is being discounted
     */
    public void setDiscount(float percentage) {
        if (percentage > 0) {
            this.price = this.price - (this.price * (percentage / 100));
        }
    }
}