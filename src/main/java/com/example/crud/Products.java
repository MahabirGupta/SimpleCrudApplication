package com.example.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
    @Id
    private Integer productId;
    private String productName;
    private Integer supplierID;
    private String categoryID;
    private Integer quantityPerUnit;
    private Double unitPrice;
    private Byte unitsInStock;
    private Byte unitsOnOrder;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Integer supplierID) {
        this.supplierID = supplierID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Byte getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(Byte unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Byte getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Byte unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }
}
