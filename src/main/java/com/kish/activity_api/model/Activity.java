package com.kish.activity_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    private String activity;
    private String type;
    private String link;
    private String key;
    private Integer participants;
    private Double availability;
    private Double price;
    private String accessibility;
    private String duration;
    private String kidFriendly;

//    Sample json response:
//    {
//        "activity": "Learn Express.js",
//        "availability": 0.25,
//        "type": "education",
//        "participants": 1,
//        "price": 0.1,
//        "accessibility": "Few to no challenges",
//        "duration": "hours",
//        "kidFriendly": true,
//        "link": "https://expressjs.com/",
//        "key": "3943506"
//    }
}


