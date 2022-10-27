package com.xxg.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 评论 
 * @TableName discuss
 */
@TableName(value ="discuss")
@Data
public class Discuss implements Serializable {
    /**
     * 评论ID
     */
    @TableId(type = IdType.AUTO)
    private Long discussId;

    /**
     * 评论日期
     */
    private Date createTime;

    /**
     * 点赞数
     */
    private Integer likeCount;

    /**
     * 发表用户
     */
    private Long discussUser;

    /**
     * 评论文章ID
     */
    private Long articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论ID
     */
    private Long parentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}