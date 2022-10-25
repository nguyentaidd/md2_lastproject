package ra.business.entity;

import java.io.Serializable;

public class FlowerProduct implements Serializable{
    private Flower flower;
    private int quantity;

    public FlowerProduct(){

    }

    public FlowerProduct(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
