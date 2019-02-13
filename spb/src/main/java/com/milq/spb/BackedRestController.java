package com.milq.spb;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "backed")
public class BackedRestController {
    private RestTemplate restTemplate = new RestTemplate();
    private String backendServiceHost;
    private int backendServicePort;
    private int id;

    @RequestMapping(value = "/backed" ,method = RequestMethod.GET,produces = "text/plain")
    public String backed(){
        String backendServiceURL =  String.format("http://%s:%d/api/backend?id={id}",backendServiceHost,backendServicePort);
        ResponseDTO responseDTO = restTemplate.getForObject(backendServiceURL,ResponseDTO.class,id);
        return "value:"+responseDTO.getValue()+" id "+ responseDTO.getId();
    }

    public int getBackendServicePort() {
        return backendServicePort;
    }

    public void setBackendServicePort(int backendServicePort) {
        this.backendServicePort = backendServicePort;
    }

    public String getBackendServiceHost() {
        return backendServiceHost;
    }

    public void setBackendServiceHost(String backendServiceHost) {
        this.backendServiceHost = backendServiceHost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
