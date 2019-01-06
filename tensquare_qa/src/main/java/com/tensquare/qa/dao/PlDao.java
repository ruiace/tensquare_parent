package com.tensquare.qa.dao;/**
 * Created by Administrator on 2019/1/6.
 */


import com.tensquare.qa.pojo.Pl;
import com.tensquare.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 〈一句话功能简述〉<br>
 * 〈标签和问题对应关系Dao〉
 *
 * @author rp
 * @create 2019/1/6
 */
public interface PlDao extends JpaRepository<Pl,String>,JpaSpecificationExecutor<Pl>{



}
