package com.zszd.ai.service.post;

import java.util.List;

import com.zszd.ai.pojo.Page;
import com.zszd.ai.pojo.Post;
/**
 * 
 * @ClassName       PostService
 * @Description    OA论坛模块细分板块帖子接口
 * @author            lizx
 * @date           2018-1-21        上午11:42:18
 */
public interface PostService {
   
	/**
	 * 
	 * @Title          getPostByPostId
	 * @Description    根据帖子ID查找帖子
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Post   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:42:28
	 */
	Post getPostByPostId(int id);
	/**
	 * 
	 * @Title          addPostInfo
	 * @Description    添加帖子信息
	 * @Tags           @param post
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:42:35
	 */
	int addPostInfo(Post post);
	/**
	 * 
	 * @Title          updatePost
	 * @Description    更新帖子的点击数
	 * @Tags           @param post
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:42:41
	 */
	int updatePost(Post post);
	/**
	 * 
	 * @Title          updatePostInfo
	 * @Description    更新帖子所有信息
	 * @Tags           @param post
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:42:48
	 */
	int updatePostInfo(Post post);
	/**
	 * 
	 * @Title          deletePostById
	 * @Description    根据帖子ID删除帖子内容
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:42:55
	 */
	int deletePostById(int id);
    /**
     * 
     * @Title          getPostInfoCountLikeName
     * @Description    根据关键词查询帖子数量
     * @Tags           @param keywords
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:43:02
     */
	int getPostInfoCountLikeName(String keywords);
    /**
     * 
     * @Title          queryPostInfoLikeNamePage
     * @Description    根据帖子关键性和分页数量查询帖子信息
     * @Tags           @param p
     * @Tags           @param keywords
     * @Tags           @return   
     * @Return         List<Post>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:43:12
     */
	List<Post> queryPostInfoLikeNamePage(Page p, String keywords);
	
}
