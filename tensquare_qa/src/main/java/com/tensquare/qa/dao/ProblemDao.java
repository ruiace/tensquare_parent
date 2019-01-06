package com.tensquare.qa.dao;

import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
    /**
     * 根据标签ID查询最新问题列表
     * @param labelid
     * @param pageable
     * @return
     */
    @Query(value = "select p form tb_problem p where id in (select problemid from tb_pl where labelid = ?1 ) order BY  replytime desc",nativeQuery = true)
    Page<Problem> findNewListByLabelId(String labelid, Pageable pageable);


    /**
     * 根据标签ID查询热门问题列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "select p from tb_problem p where id in( select problemid from tb_pl where labelid=?1 ) order by reply desc",nativeQuery = true)
    Page<Problem> findHotListByLabelId(String labelId, Pageable pageable);


    /**
     * 根据标签ID查询等待回答列表
     * @param labelId
     * @param pageable
     * @return
     */
    @Query(value = "select p from tb_problem p where id in( select problemid from tb_pl where labelid=?1 ) and reply=0 order by createtime desc",nativeQuery = true)
    Page<Problem> findWaitListByLabelId(String labelId, Pageable pageable);
}
