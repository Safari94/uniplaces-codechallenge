package com.uniplaces.codechallenge.restcontroller;



import com.uniplaces.codechallenge.model.Unit;
import com.uniplaces.codechallenge.model.UnitRelationship;
import com.uniplaces.codechallenge.service.interfaces.UnitsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@Api(value="This controller contains a set of endpoints for post, delete and get units")
@RequestMapping("/api")
public class UnityController {

    @Autowired
    private UnitsService unitsService;


    @PostMapping("/units")
    public void postUnits(@Valid @RequestBody Unit unit){
        this.unitsService.addUnit(unit);
    }


    @DeleteMapping("/units")
    public void deleteAll(){
        this.unitsService.deleteAllUnits();
    }



    @GetMapping("/units")
    public Collection<UnitRelationship> getUnits(@RequestParam("name") @Min(value = 2) String name){
        return this.unitsService.getUnitybyName(name);
    }

}
