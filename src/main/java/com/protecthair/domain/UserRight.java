package com.protecthair.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRight {
    private Integer rightLevel;

    private Integer userId;

}