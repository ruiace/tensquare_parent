package com.tensquare.base.dao;

import com.tensquare.base.pojo.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by rp on 2018/12/29.
 * JpaRepository提供了基本的增删改查
   JpaSpecificationExecutor用于做复杂的条件查询
 */
public interface LabelDao extends JpaRepository<Label,String>,JpaSpecificationExecutor<Label>{

    List<Label> findAllByRecommendEquals(String recommend);

    List<Label> findAllByStateEquals(String state);
}
