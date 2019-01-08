package com.tensquare.dao;/**
 * Created by Administrator on 2019/1/8.
 */


import com.tensquare.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rp
 * @create 2019/1/8
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {

    /**
     * 检索
     * @param
     * @return
     */
    Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
