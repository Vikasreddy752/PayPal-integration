package com.hulkhiretech.payments.controller;

import com.hulkhiretech.payments.Pojo.CreateorderReq;
import com.hulkhiretech.payments.Pojo.TokenRes;
import com.hulkhiretech.payments.Service.PaymentServiceImpl;
import com.hulkhiretech.payments.Service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/paypal/order")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @PostMapping
    public TokenRes createorder(@RequestBody CreateorderReq createorderReq) {
        TokenRes token = paymentService.createorder();
        log.info("Createorder token: " + token);
        return  token;
    }
}
