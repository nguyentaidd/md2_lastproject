package ra.business.entity;

import java.io.Serializable;

public class FlowerType implements Serializable {
    private int flowerTypeId;
    private String flowerTypeName;
    private String flowerTypeDescription;
    private boolean flowerTypeStatus;

    public FlowerType(){

    }

    public FlowerType(int flowerTypeId, String flowerTypeName,
                      String flowerTypeDescription, boolean flowerTypeStatus) {
        this.flowerTypeId = flowerTypeId;
        this.flowerTypeName = flowerTypeName;
        this.flowerTypeDescription = flowerTypeDescription;
        this.flowerTypeStatus = flowerTypeStatus;
    }

    public int getFlowerTypeId() {
        return flowerTypeId;
    }

    public void setFlowerTypeId(int flowerTypeId) {
        this.flowerTypeId = flowerTypeId;
    }

    public String getFlowerTypeName() {
        return flowerTypeName;
    }

    public void setFlowerTypeName(String flowerTypeName) {
        this.flowerTypeName = flowerTypeName;
    }

    public String getFlowerTypeDescription() {
        return flowerTypeDescription;
    }

    public void setFlowerTypeDescription(String flowerTypeDescription) {
        this.flowerTypeDescription = flowerTypeDescription;
    }

    public boolean isFlowerTypeStatus() {
        return flowerTypeStatus;
    }

    public void setFlowerTypeStatus(boolean flowerStatus) {
        this.flowerTypeStatus = flowerStatus;
    }

}
