package com.travel.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "category")
public class Category {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String cname;
}
