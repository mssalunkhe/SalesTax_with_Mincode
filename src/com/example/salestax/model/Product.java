package com.example.salestax.model;

import com.example.salestax.utility.FormatUtility;

public class Product {
    private final String name;
    private final double originalPrice;
    private final ProductType type;
    private final Boolean isimported;

    public Product(String name, Double price, ProductType type, Boolean isImported) {
        this.name = name;
        this.originalPrice = price;
        this.type = type;
        this.isimported = isImported;

    }

    public String getName() {
        return name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getShelfPrice() {
        return originalPrice + getSalesTax();
    }

    public ProductType getType() {
        return type;
    }

    public Boolean isImported() {
        return isimported;
    }


    private double calculateSalesTax() {
        ProductType productType = getType();
        double taxRate = productType.getTaxRate(isImported());
        double salesTax = getOriginalPrice() * taxRate / 100;
        return Double.parseDouble(FormatUtility.format(salesTax));


    }

    public double getSalesTax() {
        return calculateSalesTax();
    }
}
