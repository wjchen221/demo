package com.wjchen.demo.model;

import com.wjchen.demo.base.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author
 * @date 2020/04/17 15:46
 */
@Entity
@Table(name="t_task")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Task extends BaseModel {

    /**
     * 任务名
     */
    @Column(name="name")
    private String name;

    /**
     * 任务corn
     */
    @Column(name="corn")
    private String corn;

    /**
     * 状态
     */
    @Column(name="state")
    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
