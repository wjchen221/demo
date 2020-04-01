package com.wjchen.demo.model;

import com.wjchen.demo.base.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_info")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Info extends BaseModel {
    @Column(name="cron")
    private String corn;

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }
}
