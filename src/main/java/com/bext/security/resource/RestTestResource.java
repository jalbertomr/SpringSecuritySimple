package com.bext.security.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/test")
public class RestTestResource {

    @GetMapping
    public String test() {
        return "recurso Rest /rest/test accesado OK.";
    }
}
