package com.travel.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.common.enmus.ExceptionEnum;
import com.travel.common.exception.LyException;
import com.travel.common.vo.PageResult;
import com.travel.item.mapper.RouteMapper;
import com.travel.item.pojo.Route;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Slf4j
public class RouteService {

    @Autowired
    private RouteMapper routeMapper;

    public PageResult<Route> queryRouteForPage(String rname, Integer cid, Integer page, Integer rows){
        //1 分页查询
        PageHelper.startPage(page,rows);
        //2 查询条件
        Example example = new Example(Route.class);
        Example.Criteria criteria1 = example.createCriteria();
        //2.1 搜索条件
        if(StringUtils.isNotBlank(rname)){
            criteria1.andLike("rname","%"+rname+"%");
        }
        Example.Criteria criteria2 = example.createCriteria();
        if(cid != null){
            criteria2.orEqualTo("cid",cid);
        }
        example.and(criteria1);
        example.and(criteria2);
        //3 排序方式
        example.setOrderByClause("rid ASC");
        //4 查询
        List<Route> routes = routeMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(routes)){
            throw new LyException(ExceptionEnum.QUERY_ROUTE_ERROR);
        }
        //5 解析结果并返回
        PageInfo<Route> pageInfo = new PageInfo<>(routes);
        return new PageResult<Route>(pageInfo.getTotal(),pageInfo.getPages(),routes,page);
    }

    public List<Route> queryRouteByName(String name){
        Example example = new Example(Route.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(name)){
            criteria.andLike("rname","%"+name+"%");
        }
        List<Route> list = routeMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(list)){
            log.info("查询失败");
        }
        return list;
    }
}
