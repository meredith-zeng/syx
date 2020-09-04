package com.protecthair.result;

import com.protecthair.domain.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceResult<T> {
    private String FileName;

    private String code;

    private Invoice data;

    private String message;

    private String ocrIdentifyTime;



}
