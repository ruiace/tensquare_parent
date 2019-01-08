package com.tensquare.service;

import com.tensquare.dao.ArticleSearchDao;
import com.tensquare.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author rp
 * @create 2019/1/8
 */
@Service
public class ArticleSearchService {


    @Autowired
    private ArticleSearchDao articleSearchDao;
    /**
     * 增加文章
     * @param article
     */
    public void add(Article article){
        articleSearchDao.save(article);
    }


    public Page<Article> findByTitleLike(String keywords, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return articleSearchDao.findByTitleOrContentLike(keywords,keywords, pageRequest);
    }

}