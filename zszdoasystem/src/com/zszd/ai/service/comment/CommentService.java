package com.zszd.ai.service.comment;

import java.util.List;

import com.zszd.ai.pojo.Comment;
/**
 * 
 * @ClassName       CommentService
 * @Description    OA论坛模块评论细分模块接口
 * @author            lizx
 * @date           2018-1-21        上午11:36:05
 */
public interface CommentService {
    /**
     * 
     * @Title          addCommentInfo
     * @Description    添加评论信息
     * @Tags           @param comment
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:36:11
     */
	int addCommentInfo(Comment comment);
	/**
	 * 
	 * @Title          getAllCommentByPostId
	 * @Description    根据帖子ID获取帖子所有评论信息
	 * @Tags           @param postId
	 * @Tags           @return   
	 * @Return         List<Comment>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:36:20
	 */
	List<Comment> getAllCommentByPostId(int postId);
	/**
	 * 
	 * @Title          getAllComentInfo
	 * @Description    获取所有评论信息
	 * @Tags           @return   
	 * @Return         List<Comment>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:36:29
	 */
	//List<Comment> getAllComentInfo();
	/**
	 * 
	 * @Title          getCommentByCommentId
	 * @Description    根据评论ID获取评论内容
	 * @Tags           @param commentId
	 * @Tags           @return   
	 * @Return         Comment   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:36:37
	 */
	Comment getCommentByCommentId(int commentId);
    /**
     * 
     * @Title          updateCommentInfo
     * @Description    更新评论信息
     * @Tags           @param comment
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:36:46
     */
	int updateCommentInfo(Comment comment);
	/**
	 * 
	 * @Title          deleteCommentById
	 * @Description    根据评论ID删除评论内容
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:36:53
	 */
	int deleteCommentById(int id);
}
