package com.example.salestax.model;

public enum ProductType {


    FOOD(0.0, 5.0) {
        @Override
        public double getTaxRate(Boolean isImpoterd) {
            if (isImpoterd) return salesTaxRate + getImportDutyRate();
            return salesTaxRate;
        }


    }, MEDICINE(0.0, 5.0) {
        @Override
        public double getTaxRate(Boolean isImpoterd) {

            if (isImpoterd) return salesTaxRate + getImportDutyRate();
            return salesTaxRate;

        }


    }, BOOK(0.0, 5.0) {
        @Override
        public double getTaxRate(Boolean isImpoterd) {

            if (isImpoterd) return salesTaxRate + getImportDutyRate();
            return salesTaxRate;

        }


    }, OTHER(10.0, 5.0) {
        @Override
        public double getTaxRate(Boolean isImpoterd) {

            if (isImpoterd) return salesTaxRate + getImportDutyRate();
            return salesTaxRate;


        }


    };


    double salesTaxRate = 0.0;
    double importDutyRate = 0.0;

    ProductType(double salesTaxRate, double importDutyRate) {
        this.salesTaxRate = salesTaxRate;
        this.importDutyRate = importDutyRate;
    }


    public abstract double getTaxRate(Boolean isImpoterd);

    public double getImportDutyRate() {
        return importDutyRate;
    }


}

