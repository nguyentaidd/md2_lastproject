package ra.business.entity;

import java.io.Serializable;

public class Catalog implements Serializable {
    private int catalogId;
    private String catalogName;
    private String catalogDescription;
    private int catalogPriority;
    private boolean catalogStatus;

    public Catalog(){

    }

    public Catalog(int catalogId, String catalogName, String catalogDescription,
                   int catalogPriority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.catalogDescription = catalogDescription;
        this.catalogPriority = catalogPriority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDescription() {
        return catalogDescription;
    }

    public void setCatalogDescription(String catalogDescription) {
        this.catalogDescription = catalogDescription;
    }

    public int getCatalogPriority() {
        return catalogPriority;
    }

    public void setCatalogPriority(int catalogPriority) {
        this.catalogPriority = catalogPriority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }




}
