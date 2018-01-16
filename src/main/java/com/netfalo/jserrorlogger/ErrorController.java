package com.netfalo.jserrorlogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ErrorController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping(value = "error/report", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void reportError(@RequestBody Error error) {
        mongoTemplate.insert(error);
    }
}
