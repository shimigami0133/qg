package com.seimens.qualitygate.service.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QgServiceHttp {
    @Autowired
    private RestTemplate restTemplate;
    public String getStatus(String name){
        String g = restTemplate.getForObject("http://ies-iesd-qgweb.ies.mentorg.com:8080/qualitygates/wa/SKIPLIST-2019.1_INT/junit_test_result/gatestatus.xml",String.class);
        return g;
    }
}
