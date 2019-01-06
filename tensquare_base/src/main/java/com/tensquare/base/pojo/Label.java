package com.tensquare.base.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈标签实体类〉
 *
 * @author rp
 * @create 2018/12/19
 */
@Entity
@Table(name = "tb_label")
public class Label implements Serializable{

    /**
     * id 主键
     */
    @Id
    private String id;

    /**
     * 标签名称
     */
    private String labelname;

    /**
     * 状态 文本 0：无效 1：有效
     */
    private String state;

    /**
     *  使用数量
     */
    private Long count;

    /**
     * 关注数
     */
    private Long fans;

    /**
     * 是否推荐 0：不推荐 1:推荐
     */
    private String recommend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelname() {
        return labelname;
    }

    public void setLabelname(String labelname) {
        this.labelname = labelname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getFans() {
        return fans;
    }

    public void setFans(Long fans) {
        this.fans = fans;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}