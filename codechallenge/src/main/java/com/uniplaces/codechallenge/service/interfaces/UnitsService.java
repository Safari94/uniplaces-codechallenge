package com.uniplaces.codechallenge.service.interfaces;

import com.uniplaces.codechallenge.model.Unit;
import com.uniplaces.codechallenge.model.UnitRelationship;

import java.util.Collection;

public interface UnitsService {

    public abstract void addUnit(Unit unit);

    public abstract void deleteAllUnits();

    public abstract Collection<UnitRelationship> getUnitybyName(String name);

    public abstract Unit getAll();


}
