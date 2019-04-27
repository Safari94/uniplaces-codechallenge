package com.uniplaces.codechallenge.model;

import org.springframework.lang.Nullable;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Unit implements Serializable {

    @Size(min=3,message ="Unit name should have at least more than 3 chars")
    private String unit;
    @Nullable
    private Set<Unit> subunit=new HashSet<>();

    public Unit() {
    }

    private Unit(String name){
        this.unit = name;
    }

    public Unit(String unit, Set<Unit> subunit) {
        this.unit = unit;
        this.subunit = subunit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Set<Unit> getSubunit() {
        return subunit;
    }

    public void setSubunit(Set<Unit> subunit) {
        this.subunit = subunit;
    }

    @Override
    public String toString(){

        return "Unit: "+this.unit;
    }

}
