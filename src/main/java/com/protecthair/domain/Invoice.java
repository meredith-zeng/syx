package com.protecthair.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    private String teamName;

    private String code;

    @JsonFormat(pattern = "yyyyMMdd")
    private Date date;

    private String number;

    private String price;

    private String verify;


}
