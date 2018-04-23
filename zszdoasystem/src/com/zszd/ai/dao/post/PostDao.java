package com.zszd.ai.dao.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Post;

/**
 * 帖子DAO接口
 * 
 * @author lizx 20180103
 * 
 */
public interface PostDao {

	Post getPostByPostId(@Param("id") Integer id);

	int addPostInfo(Post post);

	int updatePost(Post post);

	int updateCommentCount( Post post);

	int updatePostInfo( Post post);

	int deletePostById(@Param("id") Integer id);

	int getPostInfoCountLikeName( @Param("keywords")String keywords);

	List<Post> queryPotRecordPageLikeName(@Param("p") Page p,
			@Param("keywords") String keywords);

}
