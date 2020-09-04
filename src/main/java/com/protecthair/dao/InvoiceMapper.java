package com.protecthair.dao;

import com.protecthair.domain.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InvoiceMapper {

    int save(Invoice invoice);

    List<Invoice> show(String name);
}
