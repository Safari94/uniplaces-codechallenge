package com.uniplaces.codechallenge.service.implementation;

import com.uniplaces.codechallenge.model.Unit;
import com.uniplaces.codechallenge.model.UnitRelationship;
import com.uniplaces.codechallenge.service.interfaces.UnitsService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UnitsServicesImpl implements UnitsService {


    private static Unit unitRepo = new Unit();


    @Override
    public void addUnit(Unit unit) {
        unitRepo = unit;

    }

    @Override
    public void deleteAllUnits() {

        unitRepo = null;

    }


    @Override
    public Collection<UnitRelationship> getUnitybyName(String name) {

        //Create a treeset with comparator that will store the output in unit order, if unit name is equal check type name
        PriorityQueue<UnitRelationship> output = new PriorityQueue<>(new UnitRelationshipComparator());

        Stack<Unit> stack = new Stack<>();
        if (unitRepo == null) {
            return output;
        }

        stack.push(unitRepo);

        while (!stack.empty()) {

            Unit unit = stack.peek();
            System.out.println("Stack value: " + unit.toString());
            stack.pop();

            //Check if the node sub-unit is empty
            if (!unit.getSubunit().isEmpty()) {

                for (Unit u1 : unit.getSubunit()) {

                    if (u1.getUnit().equals(name)) {
                        //Before write to output tree check for the size
                        if (output.size() == 100) {
                            return output;
                        }
                        System.out.println("Unit value: " + unit.toString());
                        output.add(new UnitRelationship("parent", unit.getUnit()));

                        for (Unit u : unit.getSubunit()) {

                            if (!u.getUnit().equals(name)) {
                                if (output.size() == 100) {
                                    return output;
                                }
                                output.add(new UnitRelationship("sibling", u.getUnit()));
                                System.out.println("Unit value: " + unit.toString());
                                //If its not final node, push to stack
                                if (!u.getSubunit().isEmpty()) {
                                    stack.push(u);
                                }
                            } else {

                                if (!u.getSubunit().isEmpty()) {

                                    for (Unit us : u.getSubunit()) {
                                        if (output.size() == 100) {
                                            return output;
                                        }
                                        output.add(new UnitRelationship("child", us.getUnit()));
                                    }
                                }

                            }
                        }
                    } else {
                        //Only push for stack node that are not final, i.e subunit not empty
                        if (!u1.getSubunit().isEmpty()) {
                            stack.push(u1);
                        }
                    }
                }
            }
        }
        System.out.println(output);

        return output;
    }


    @Override
    public Unit getAll() {
        return unitRepo;
    }

}
    class UnitRelationshipComparator implements Comparator<UnitRelationship>{

        @Override
        public int compare(UnitRelationship ur1,UnitRelationship ur2){

            return ur1.getUnit().compareTo(ur2.getUnit());
        }



}
