package com.example.diaugia;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Decisions> allDec = new ArrayList<>(3);
    private Integer unitsSize;
    private ArrayList<Integer> totals = new ArrayList<>();
    private ArrayList<String> units = new ArrayList<>();

    public University(String name) {
        this.name = name;

    }

    public void setDecisions(ArrayList<Integer> p, int year) {
        //initialize arrayList allDec
        for (int i=0;i<4;i++) {allDec.add(new Decisions(p, "null"));}

        if (year==2020) allDec.add(0, new Decisions(p, Integer.toString(year)));
        else if (year==2021) allDec.add(1, new Decisions(p, Integer.toString(year)));
        else if (year==2022) allDec.add(2, new Decisions(p, Integer.toString(year)));
        else System.out.println("IM OUT");
    }

    public ArrayList<Decisions> getDecisions() {
        return allDec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnitsSize() {
        return unitsSize;
    }

    public void setUnitsSize(Integer unitsSize) {
        this.unitsSize = unitsSize;
    }

    public ArrayList<Integer> getTotals() {
        return totals;
    }

    public void setTotals(ArrayList<Integer> totals) {
        this.totals = totals;
    }

    public ArrayList<String> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<String> units) {
        this.units = units;
    }
}
