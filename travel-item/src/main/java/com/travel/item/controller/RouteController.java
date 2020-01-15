package com.travel.item.controller;

import com.travel.common.vo.PageResult;
import com.travel.item.pojo.Route;
import com.travel.item.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping("route")
    public ResponseEntity<PageResult<Route>> queryRouteForPage(
            @RequestParam(value = "rname",required = false) String key,
            @RequestParam(value = "cid", required = false) Integer cid,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows
    ){
        return ResponseEntity.ok(routeService.queryRouteForPage(key,cid,page,rows));
    }

    @GetMapping("route1/{name}")
    public ResponseEntity<List<Route>> queryRouteByName(@PathVariable("name") String name){
        return ResponseEntity.ok(routeService.queryRouteByName(name));
    }
}
