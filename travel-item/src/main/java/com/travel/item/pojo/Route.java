package com.travel.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tab_route")
public class Route {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer rid;
    private String rname;
    private Double price;
    private String routeIntroduce;
    private String rflag;
    private String rdate;
    private String isThemeTour;
    private Integer count;
    private Integer cid;
    private String image;
    private Integer sid;
    private String sourceId;
}
