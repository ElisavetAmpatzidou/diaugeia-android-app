package com.example.diaugia;

import java.util.ArrayList;

public class University {
    private String name;
    private ArrayList<Decisions> allDec = new ArrayList<>();
    private Integer unitsSize;
    private ArrayList<Integer> totals = new ArrayList<>();
    private ArrayList<String> units = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void setDecisions(ArrayList<Integer> p, String year) {
        allDec.add(new Decisions(p, year));
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
