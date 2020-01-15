package com.travel.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.travel.common.enmus.ExceptionEnum;
import com.travel.common.exception.LyException;
import com.travel.common.utils.JsonUtils;
import com.travel.common.vo.PageResult;
import com.travel.item.mapper.CategoryMapper;
import com.travel.item.mapper.RouteMapper;
import com.travel.item.pojo.Category;
import com.travel.item.pojo.Route;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public List<Category> queryCategory(){
        String key = "category";
        List<Category> categoryList = null;
        boolean boo = redisTemplate.hasKey(key);
        if(!boo){
            categoryList = categoryMapper.selectAllCategory();
            if(CollectionUtils.isEmpty(categoryList)){
                throw new LyException(ExceptionEnum.QUERY_CATEGORY_ERROR);
            }
            String json = JsonUtils.serialize(categoryList);
            if(StringUtils.isBlank(json)){
                log.error("数据有误");
            }
            redisTemplate.opsForValue().set(key,json);
        }else {
            String categories = redisTemplate.opsForValue().get(key).toString();
            categoryList = JsonUtils.parse(categories,List.class);
        }

        return categoryList;
    }



}
