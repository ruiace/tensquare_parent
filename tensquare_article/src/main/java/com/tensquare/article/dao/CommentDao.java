package com.tensquare.article.dao;/**
 * Created by Administrator on 2019/1/8.
 */


import com.tensquare.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈Comment评论Dao〉
 *
 * @author rp
 * @create 2019/1/8
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    List<Comment> findByArticleid(String articleid);
}
