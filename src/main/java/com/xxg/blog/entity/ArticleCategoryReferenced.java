package com.xxg.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章分类 
 * @author Administrator
 * @TableName article_category_referenced
 */
@TableName(value ="article_category_referenced")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCategoryReferenced implements Serializable {
    /**
     * 引用id
     */
    @TableId(type = IdType.AUTO)
    private Long acrId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 类目id
     */
    private Long categoryId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}