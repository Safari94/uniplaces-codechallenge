# uniplaces-codechallenge

Code challenge that I did during the recruitment process for the position of Software Engineer at Uniplaces.
Spring Framework to build Rest API and Swagger 2 for the documentation


# Units with sub-units

As you know Uniplaces is an online marketplace for booking accommodations, 
and as you expect we try to have as much Properties as we can.
For this challenge we want you to implement a REST API to store, delete and list properties.

### The problem
Properties are very special objects of our domain. Properties an have multiple Units.
Units in other and can have sub-units, and these sub-units can contain more sub-units.
Assume that units have a unique name (at the same level) and that ALL units are defined in a single request.

### Objective

1) Create an REST endpoint to add multiple Units with their relations in one POST request:

Request:

```json
{
   "unit":"property 1",
   "subunit":[
      {
         "unit":"kitchen",
         "subunit":[
            {
               "unit":"balcony"
            },
            {
               "unit":"window"
            }
         ]
      },
      {
         "unit":"bedroom",
         "subunit":[
            {
               "unit":"double-bed"
            },
            {
               "unit":"sofa-bed"
            },
            {
               "unit":"window"
            },
            {
               "unit":"bathroom",
               "subunit":[
                  {
                     "unit":"toilet"
                  },
                  {
                      "unit":"window"
                  }
               ]
            }
         ]
      }
   ]
}
```

`POST /units`

2) Create an endpoint to delete all Units.

`DELETE /units`

3) Create an endpoint to query by name Units with a maximum of 100 results.
This list should return all the matched Units with their relationship type (child, sibling and parent) to the searched unit.
The results **should be sorted** by the unit name.

`GET /units?name=window`

Response: 


```
[
    {
        "type": "sibling",
        "unit": "balcony"
    },
    {
        "type": "parent",
        "unit": "bedroom"
    },
    {
        "type": "sibling",
        "unit": "double-bed"
    },
    {
        "type": "parent",
        "unit": "kitchen"
    },
    {
        "type": "sibling",
        "unit": "sofa-bed"
    },
    ....
]
```
