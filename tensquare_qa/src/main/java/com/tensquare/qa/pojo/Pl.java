package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈标签和问题对应关系实体类〉
 *
 * @author rp
 * @create 2019/1/6
 */

@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable{

    @Id
    private  String problemid;

    @Id
    private  String labelid;

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getLabelid() {
        return labelid;
    }

    public void setLabelid(String labelid) {
        this.labelid = labelid;
    }
}