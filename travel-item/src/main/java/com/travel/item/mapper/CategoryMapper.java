package com.travel.item.mapper;

import com.travel.common.mapper.BaseMapper;
import com.travel.item.pojo.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select * from category ")
    List<Category> selectAllCategory();
}
