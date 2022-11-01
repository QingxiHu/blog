package com.xxg.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 文章标签 
 * @author Administrator
 * @TableName article_tag_referenced
 */
@TableName(value ="article_tag_referenced")
@Data
public class ArticleTagReferenced implements Serializable {
    /**
     * 引用id
     */
    @TableId(type = IdType.AUTO)
    private Long atrId;

    /**
     * 文章id
     */
    private Long articleId;

    /**
     * 标签id
     */
    private Long tagId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}