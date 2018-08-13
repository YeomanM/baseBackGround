package com.example.demo.entity.dao;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@TableName("j_right")
public class Right implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 权限名称
     */
    @TableField("right_name")
    private String rightName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;
    /**
     * 更新人
     */
    private String updator;
    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Date updatedTime;
    /**
     * 权限路径
     */
    @TableField("right_url")
    private String rightUrl;
    @TableField("parent_id")
    private Integer parentId;
    private Integer enabled;
    private Integer deleted;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getRightUrl() {
        return rightUrl;
    }

    public void setRightUrl(String rightUrl) {
        this.rightUrl = rightUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Right{" +
        ", id=" + id +
        ", rightName=" + rightName +
        ", creator=" + creator +
        ", createdTime=" + createdTime +
        ", updator=" + updator +
        ", updatedTime=" + updatedTime +
        ", rightUrl=" + rightUrl +
        ", parentId=" + parentId +
        ", enabled=" + enabled +
        ", deleted=" + deleted +
        "}";
    }
}
