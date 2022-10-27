package com.xxg.blog.mapper;

import com.xxg.blog.pojo.ArticleCategoryReferenced;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.ManagedBean;

/**
 * @Entity ArticleCategoryReferenced
 */
@Mapper
public interface ArticleCategoryReferencedMapper extends BaseMapper<ArticleCategoryReferenced> {

    int insertSelective(ArticleCategoryReferenced articleCategoryReferenced);
}




