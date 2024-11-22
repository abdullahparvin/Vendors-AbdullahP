class Item {
    double price;
    int stock;

    Item(double price, int numPieces) {
        this.price = price;
        this.stock = numPieces;
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
    }

    int getStock () {
        return stock;
    }
}