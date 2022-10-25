package ra.business.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private int productId;
    private boolean productStatus;
    private String productName;
    private float exportPrice;
    private String content;
    private Catalog catalog;
    private ArrayList<FlowerProduct> listFlower = new ArrayList<>();

    public Product(){

    }

    public Product(int productId, boolean productStatus, String productName, float exportPrice,
                   String content, Catalog catalog, ArrayList<FlowerProduct> listFlower) {
        this.productId = productId;
        this.productStatus = productStatus;
        this.productName = productName;
        this.exportPrice = exportPrice;
        this.content = content;
        this.catalog = catalog;
        this.listFlower = listFlower;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public ArrayList<FlowerProduct> getListFlower() {
        return listFlower;
    }

    public void setListFlower(ArrayList<FlowerProduct> listFlower) {
        this.listFlower = listFlower;
    }
}
