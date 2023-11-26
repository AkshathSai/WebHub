package com.akshathsaipittala.webhub.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebSubAPI {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/reset")
    public ResponseEntity<String> handleWebSubSubscriptionAndNotification(
            RequestEntity<String> requestBody,
            @RequestParam(required = false, name = "hub.challenge") String challenge) {

        var string = requestBody.getBody();
        log.info("request: {} ", string);
        if (StringUtils.hasText(challenge)) {
            return ResponseEntity.ok(challenge);
        }

        return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
    }

}
