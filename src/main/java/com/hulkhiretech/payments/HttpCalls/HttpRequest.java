package com.hulkhiretech.payments.HttpCalls;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

@Data
public class HttpRequest {
    HttpMethod method;
    String url;
    Object body;
    HttpHeaders headers;
}
