package com.wjchen.demo.base;

import com.wjchen.demo.model.User;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseModel {
    /**
     * id 使用uuid,32位字符串
     */
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;

    /**
     * 创建时间
     */
    @Column(name="createdate")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name="updatedate")
    private Date updateDate;

    /**
     * 创建人
     */
    @OneToOne
    @JoinColumn(name="creatorid",referencedColumnName = "id")
    private User creator;

    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
