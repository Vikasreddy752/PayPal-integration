package com.hulkhiretech.payments.Pojo;

import lombok.Data;

@Data
public class CreateorderReq {
    private String currency;
    private String amount;

}
