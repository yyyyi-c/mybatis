package com.itheima.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class QueryVo implements Serializable {
    private List<Integer> ids;
}
