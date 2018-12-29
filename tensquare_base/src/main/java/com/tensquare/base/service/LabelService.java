package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rp on 2018/12/29.
 * 标签业务服务层
 */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;


    /**
     * 查询全部标签
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 添加标签
     * @param label
     */
    public void add(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }


    /**
     * 删除标签
     * @param id
     */
    public void deleteLabel(String id){
        labelDao.deleteById(id);
    }


    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Label searchMap){
        Specification<Label> specification = createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    private Specification<Label> createSpecification(Label searchMap) {
        Specification<Label> specification = new Specification<Label>() {

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                String lablename = searchMap.getLablename();
                String state = searchMap.getState();
                String recommend = searchMap.getRecommend();
                if(StringUtils.isNotEmpty(lablename)){
                    predicateList.add(criteriaBuilder.like(root.get("labelname").as(String.class),"%" + lablename + "%"));
                }
                if(StringUtils.isNotEmpty(state)){
                    predicateList.add(criteriaBuilder.equal(root.get("state").as(String.class),state));
                }
                if(StringUtils.isNotEmpty(recommend)){
                    predicateList.add(criteriaBuilder.equal(root.get("recommend").as(String.class),recommend));
                }

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return specification;
    }

    /**
     * 分页查询
     * @param lable
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findSearch(Label lable,int page, int size){
        Specification<Label> specification = createSpecification(lable);
        PageRequest pageRequest = PageRequest.of(page-1,size);
        return labelDao.findAll(specification,pageRequest);
    }

}
