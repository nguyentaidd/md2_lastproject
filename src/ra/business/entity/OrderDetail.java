package ra.business.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int orderDetailId;
    private Product product;
    private Order order;
    private int quantity;
    private float price;
    private float totalMoney;

    public OrderDetail(){

    }

    public OrderDetail(int orderDetailId, Product product, Order order, int quantity, float price, float totalMoney) {
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.totalMoney = totalMoney;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
}
