package com.my.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CorssOrigin added and @PreAuthorize removed to simplify it more
 */


@CrossOrigin
@RestController
public class DummyServiceController {

    //@PreAuthorize("hasRole('ROLE_HIV_GEN_ACCESS')")
    @RequestMapping(value = "/dummy1", method = RequestMethod.GET, produces = "application/json")
    public String dummyMethod() {
        return "Response from Dummy 1";
    }

}
