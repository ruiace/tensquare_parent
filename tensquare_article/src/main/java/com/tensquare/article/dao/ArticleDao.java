package com.tensquare.article.dao;

import com.tensquare.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
    /**
     * 审核
     * @param id
     */
    @Modifying
    @Query(value = "update tb_article set state='1' where id=?1",nativeQuery = true)
    void examine(String id);


    /**
     * 点赞
     * @param id
     * @return
     */
    @Modifying
    @Query("update tb_article a set thumbup=thumbup+1 where id=?1")
    int updateThumbup(String id);

}
