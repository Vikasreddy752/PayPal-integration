package com.hulkhiretech.payments.Service;

import com.hulkhiretech.payments.Pojo.TokenRes;
import com.hulkhiretech.payments.Service.PaymentInteface.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final TokenService tokenService;

    public TokenRes createorder() {
        TokenRes token = tokenService.getacessToken();
        return token;
    }
}
