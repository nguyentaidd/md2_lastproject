package ra.business.entity;

import java.io.Serializable;

public class Flower implements Serializable {
    private int flowerId;
    private String flowerName;
    private FlowerType flowerType;
    private float importFlower;
    private float exportFlower;
    private String flowerDescription;
    private boolean flowerStatus;

    public Flower(){

    }

    public Flower(int flowerId, String flowerName, FlowerType flowerType,
                  float importFlower, float exportFlower, String flowerDescription,
                  boolean flowerStatus) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.flowerType = flowerType;
        this.importFlower = importFlower;
        this.exportFlower = exportFlower;
        this.flowerDescription = flowerDescription;
        this.flowerStatus = flowerStatus;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public FlowerType getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }

    public float getImportFlower() {
        return importFlower;
    }

    public void setImportFlower(float importFlower) {
        this.importFlower = importFlower;
    }

    public float getExportFlower() {
        return exportFlower;
    }

    public void setExportFlower(float exportFlower) {
        this.exportFlower = exportFlower;
    }

    public String getFlowerDescription() {
        return flowerDescription;
    }

    public void setFlowerDescription(String flowerDescription) {
        this.flowerDescription = flowerDescription;
    }

    public boolean isFlowerStatus() {
        return flowerStatus;
    }

    public void setFlowerStatus(boolean flowerStatus) {
        this.flowerStatus = flowerStatus;
    }



}
