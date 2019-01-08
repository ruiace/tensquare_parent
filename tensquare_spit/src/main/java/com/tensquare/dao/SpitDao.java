package com.tensquare.dao;/**
 * Created by Administrator on 2019/1/8.
 */


import com.tensquare.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 〈一句话功能简述〉<br>
 * 〈dao层〉
 *
 * @author rp
 * @create 2019/1/8
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    /**
     * 根据上级ID查询吐槽列表（分页）
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Spit> findByParentid(String parentid, Pageable pageable);
}
