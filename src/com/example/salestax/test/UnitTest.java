package com.example.salestax.test;

import com.example.salestax.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static com.example.salestax.model.ProductType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UnitTest {
    public void main(String[] args) {


        testCase1();
        testCase2();
        testCase3();
    }

    @Test
    public void testCase1() {
        Product product1, product2, product3;


        ArrayList<Product> productList = new ArrayList<>();

        product1 = new Product("Book1", 12.49, BOOK, Boolean.FALSE);
        product2 = new Product("CD", 14.99, OTHER, Boolean.FALSE);
        product3 = new Product("Chocolate Bar1", 0.85, FOOD, Boolean.FALSE);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

        assertEquals(0.0, product1.getSalesTax());
        assertEquals(1.5, product2.getSalesTax());
        assertEquals(0.0, product3.getSalesTax());

        testTotalSalesTaxAndTotalBillOfListOfProducts(productList, 1.5, 29.83);
    }

    @Test
    public void testCase2() {
        Product product1, product2;


        ArrayList<Product> productList = new ArrayList<>();

        product1 = new Product("Chocolate Bar2", 10.00, FOOD, Boolean.TRUE);
        product2 = new Product("Perfume1", 47.50, OTHER, Boolean.TRUE);

        assertEquals(0.5, product1.getSalesTax());
        assertEquals(7.15, product2.getSalesTax(), 0.01);


        productList.add(product1);
        productList.add(product2);


        testTotalSalesTaxAndTotalBillOfListOfProducts(productList, 7.65, 65.15);
    }

    @Test
    public void testCase3() {
        //ProductType.setImportDutyRate(5.0);

        Product product1, product2, product3, product4;

        ArrayList<Product> productList = new ArrayList<>();

        product1 = new Product("Perfume2", 27.99, OTHER, Boolean.TRUE);
        product2 = new Product("Perfume3", 18.99, OTHER, Boolean.FALSE);
        product3 = new Product("Headache Pills", 9.75, MEDICINE, Boolean.FALSE);
        product4 = new Product("Chocolate Bar3", 11.25, FOOD, Boolean.TRUE);

        assertEquals(4.2, product1.getSalesTax());
        assertEquals(1.9, product2.getSalesTax());
        assertEquals(0.0, product3.getSalesTax());
        assertEquals(0.6, product4.getSalesTax());

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);

        testTotalSalesTaxAndTotalBillOfListOfProducts(productList, 6.7, 74.68);
    }


    private void testTotalSalesTaxAndTotalBillOfListOfProducts(ArrayList<Product> productList, double totalSalesTax, double totalBillAmount) {
        double salesTax = 0.0, billAmount = 0.0;
        for (Product product : productList
        ) {
            salesTax += product.getSalesTax();
            billAmount += product.getShelfPrice();


        }
        assertEquals(totalSalesTax, salesTax, 0.01);
        assertEquals(totalBillAmount, billAmount, 0.01);
    }
}
