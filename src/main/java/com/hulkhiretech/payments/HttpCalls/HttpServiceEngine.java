package com.hulkhiretech.payments.HttpCalls;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
@Slf4j
public class HttpServiceEngine {

    private  RestClient restClient;
    public HttpServiceEngine(RestClient.Builder restClient) {
        this.restClient = restClient.build();
    }

    public ResponseEntity<String> makeHttpCall(HttpRequest httpRequest) {
        ResponseEntity<String> responseEntity = restClient.method(HttpMethod.POST)
                .uri(httpRequest.url)
                .headers((HttpHeaders t)->{
                    t.addAll(httpRequest.headers);})
                .body(httpRequest.body)
                .retrieve()
                .toEntity(String.class);
        log.info(responseEntity.getBody());

        return responseEntity;
    }
}
