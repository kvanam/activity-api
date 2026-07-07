package com.kish.activity_api.controller;

import com.kish.activity_api.model.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequestMapping("/api/v1/activity")
@RestController
public class ActivityController {

    private final RestTemplate restTemplate;
    // TODO: Ref: https://bored-api.appbrewery.com/
    private final String ACTIVITY_URL = "https://bored-api.appbrewery.com/random";

    public ActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<Activity> getRandomActivity() {
        ResponseEntity<Activity> responseEntity = restTemplate.getForEntity(ACTIVITY_URL, Activity.class);
        Activity activity = responseEntity.getBody();
        log.info("Activity Received: {}", activity);
        return ResponseEntity.ok(activity);
    }
}
