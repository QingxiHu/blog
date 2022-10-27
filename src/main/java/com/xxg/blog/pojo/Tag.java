package com.xxg.blog.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 标签 
 * @TableName tag
 */
@TableName(value ="tag")
@Data
public class Tag implements Serializable {
    /**
     * 标签ID
     */
    @TableId(type = IdType.AUTO)
    private Long tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签别名
     */
    private String aliasName;

    /**
     * 标签描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}