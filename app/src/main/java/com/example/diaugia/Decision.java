package com.example.diaugia;

import java.util.ArrayList;

public class Decision {
    private Integer decisionsSize = -1;
    private Integer anakliseis =-1;
    private Integer privateData =-1;
    Integer year;

    public Decision(ArrayList<Integer> praxeis, Integer year) {
        this.year = year;
        this.decisionsSize = praxeis.get(0);
        this.anakliseis = praxeis.get(1);
        this.privateData = praxeis.get(2);
    }

    public Integer getDesicionSize() {
        return decisionsSize;
    }

    public Integer getAnakliseis() {
        return anakliseis;
    }

    public Integer getPrivateData() {
        return privateData;
    }

    public Integer getYear() {
        return year;
    }

}
