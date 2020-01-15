package com.travel.item.mapper;

import com.travel.item.pojo.Route;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutesMapper {

    List<Route> queryById(Integer cid);
}
