package com.protecthair.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private String teamName;

    private int code;

    private String date;

    private String number;

    private String price;


}
