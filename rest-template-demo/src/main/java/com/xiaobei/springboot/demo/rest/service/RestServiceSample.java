package com.xiaobei.springboot.demo.rest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xiaobei.springboot.demo.common.CustomConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceSample {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 针对特定的类指定特殊的序列化方式
     * @param messageConverters
     */
    @Autowired
    public void setObjectMapper(AbstractGenericHttpMessageConverter[] messageConverters) {
        for (AbstractGenericHttpMessageConverter messageConverter : messageConverters) {
            if(MappingJackson2HttpMessageConverter.class.equals(messageConverter.getClass())) {
                MappingJackson2HttpMessageConverter jackson2HttpMessageConverter
                        = (MappingJackson2HttpMessageConverter) messageConverter;
                jackson2HttpMessageConverter.registerObjectMappersForType(CustomConfig.class, map -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
                    map.put(MediaType.ALL, objectMapper);
                });
            }
        }
    }

    public void postTest(CustomConfig customConfig) {
        String url = "http://localhost:8080/sample/someString";
        ResponseEntity<String> result = restTemplate.postForEntity(url, customConfig, String.class);
        System.out.println(result);
    }
}
