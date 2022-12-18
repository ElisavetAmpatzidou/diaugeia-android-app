package com.example.diaugia;

import java.util.ArrayList;

public class Decision {
    private Integer decisionsSize = -1;
    private Integer anakliseis =-1;
    private Integer pneumatika =-1;
    Integer year;

    public Decision(ArrayList<Integer> praxeis, Integer year) {
        this.year = year;
        this.decisionsSize = praxeis.get(0);
        this.anakliseis = praxeis.get(1);
        this.pneumatika = praxeis.get(2);
    }

    public Integer getDesicionSize() {
        return decisionsSize;
    }

    public void setDesicionSize(Integer praxeisSize) {
        this.decisionsSize = praxeisSize;
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

    public Integer getYear() {
        return year;
    }

}
