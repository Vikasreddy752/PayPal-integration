package com.hulkhiretech.payments.Service;

import com.google.gson.Gson;
import com.hulkhiretech.payments.Constants.constants;
import com.hulkhiretech.payments.HttpCalls.HttpRequest;
import com.hulkhiretech.payments.HttpCalls.HttpServiceEngine;
import com.hulkhiretech.payments.Pojo.TokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final HttpServiceEngine httpServiceEngine;
    private final Gson gson;

    @Value("${paypal.client-username}")
    private String username;
    @Value("${paypal.client-password}")
    private String pasword;
    @Value("${paypal.oauth-url}")
    private String Authurl;

    public TokenRes getacessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, pasword);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add(constants.GRANT_TYPE, constants.CLIENT_ID);

        HttpRequest httpRequest  = new HttpRequest();
        httpRequest.setMethod(HttpMethod.POST);
        httpRequest.setUrl(Authurl);
        httpRequest.setHeaders(headers);
        httpRequest.setBody(formData);
        ResponseEntity<String> response= httpServiceEngine.makeHttpCall(httpRequest);
        TokenRes token = gson.fromJson(response.getBody(), TokenRes.class);
        return token;
    }
}
