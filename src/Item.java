class Item {
    double price;
    int stock;

    boolean autoRestock;

    String name;

    Item(double price, int numPieces, boolean restockable, String name) {
        this.price = price;
        this.stock = numPieces;
        this.autoRestock = restockable;
        this.name = name;
    }

    void restock(int amount) {
        if (amount > 0) {
            this.stock = this.stock + amount;
        }

        if(this.stock < 0) {
            stock = Integer.MAX_VALUE;
        }
    }

    void purchase(int amount) {
        this.stock = this.stock - amount;
        if(this.autoRestock) {
            checkStock();
        }
    }

    int getStock () {
        return stock;
    }

    void checkStock () {
        if (this.stock == 0) {
            restock(10);
        }
    }

    public void setAutoRestock(boolean autoRestock) {
        this.autoRestock = autoRestock;
    }

    String getName () {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}