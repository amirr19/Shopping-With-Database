package ir.maktab32.ex4.q2;

public  abstract class Product {
    String name;
    String field;
    int cost;
    int quantity;

    public Product(String name, String field, int cost, int quantity){
        this.name=name;
        this.field=field;
        this.cost=cost;
        this.quantity=quantity;
    }

    public void  setQuantity (int quantity){
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getField() {
        return field;
    }
}
