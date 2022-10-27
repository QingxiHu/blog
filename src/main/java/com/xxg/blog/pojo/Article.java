package com.xxg.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 文章 
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 博文ID
     */
    @TableId(type = IdType.AUTO)
    private Long articleId;

    /**
     * 发布日期
     */
    private Date pushData;

    /**
     * 发表用户
     */
    private String articleUser;

    /**
     * 博文标题
     */
    private String title;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    /**
     * 浏览量
     */
    private Integer readCount;

    /**
     * 是否置顶
     */
    private String topFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 文章摘要
     */
    private String articleSummary;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}