package com.example.diaugia;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Decision> allDec = new ArrayList<>();
    private Integer unitsSize;
    private ArrayList<Integer> totals = new ArrayList<>();
    private ArrayList<String> units = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void setDecisions(ArrayList<Integer> p, Integer year) {
        //initialize arrayList allDec
        for (int i=0;i<4;i++) {allDec.add(new Decision(p, -1));}

        if (year==2020) allDec.add(0, new Decision(p, year));
        else if (year== 2021) allDec.add(1, new Decision(p, year));
        else if (year==2022) allDec.add(2, new Decision(p, year));
        else System.out.println("IM OUT");
    }

    public ArrayList<Decision> getDecisions() {
        return allDec;
    }

    public Integer getUnitsSize() {
        return unitsSize;
    }

    public void setUnitsSize(Integer unitsSize) {
        this.unitsSize = unitsSize;
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<String> units) {
        this.units = units;
    }
}
