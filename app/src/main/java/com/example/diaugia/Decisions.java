package com.example.diaugia;

import java.util.ArrayList;

public class Decisions {
    private Integer praxeisSize = -1;
    private Integer anakliseis =-1;
    private Integer pneumatika =-1;
    String year;

    public Decisions(ArrayList<Integer> praxeis, String year) {
        this.year = year;
        this.praxeisSize = praxeis.get(0);
        this.anakliseis = praxeis.get(1);
        this.pneumatika = praxeis.get(2);
    }

    public Integer getPraxeisSize() {
        return praxeisSize;
    }

    public void setPraxeisSize(Integer praxeisSize) {
        this.praxeisSize = praxeisSize;
    }

    public Integer getAnakliseis() {
        return anakliseis;
    }

    public void setAnakliseis(Integer anakliseis) {
        this.anakliseis = anakliseis;
    }

    public Integer getPneumatika() {
        return pneumatika;
    }

    public void setPneumatika(Integer pneumatika) {
        this.pneumatika = pneumatika;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
