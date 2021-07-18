package com.kss.jt.domain;

import lombok.Data;

import java.io.Serializable;
/*节点对象*/
@Data
public class Node implements Serializable {
    private static final long serialVersionUID = 996017245447618632L;
    private Integer id;
    private String name;
    private Integer parentId;
}
