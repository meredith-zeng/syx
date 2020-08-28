package com.protecthair.dao;

import com.protecthair.domain.Certification;

public interface CertificationMapper {
    int insert(Certification record);

    int insertSelective(Certification record);
}