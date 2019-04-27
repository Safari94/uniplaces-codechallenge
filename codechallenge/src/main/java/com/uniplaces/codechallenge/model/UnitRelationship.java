package com.uniplaces.codechallenge.model;

import java.io.Serializable;
import java.util.Comparator;

public class UnitRelationship implements Serializable,Comparable<UnitRelationship> {

    private String type;
    private String unit;

    public UnitRelationship() {
    }

    public UnitRelationship(String type, String unit) {
        this.type = type;
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public int compareTo(UnitRelationship ur){

        return this.getUnit().compareTo(ur.getType());
    }

    @Override
    public String toString(){

        return "{ type: "+this.type+", unit: "+this.unit+"}";

    }

}



