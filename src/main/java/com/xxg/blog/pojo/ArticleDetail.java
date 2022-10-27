package com.xxg.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 文章详情 
 * @TableName article_detail
 */
@TableName(value ="article_detail")
@Data
public class ArticleDetail implements Serializable {
    /**
     * 文章详情id
     */
    @TableId(type = IdType.AUTO)
    private Long articleDetailId;

    /**
     * 文章markdown内容
     */
    private String contentMd;

    /**
     * 文章html内容
     */
    private String contentHtml;

    /**
     * 文章id
     */
    private Long articleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}