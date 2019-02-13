package com.milq.spb;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@ConfigurationProperties(prefix = "spb")
public class HomeRestController {

    private String uri;

    @RequestMapping(method = RequestMethod.GET, value = "/def",produces = "text/plain")
    public String welcome(){
        return "uri: "+uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
