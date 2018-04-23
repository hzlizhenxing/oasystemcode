package com.zszd.ai.service.sensitivewords;

import com.zszd.ai.pojo.Sensitivewords;

import java.util.List;
/**
 * 
 * @ClassName       SensitivewordsService
 * @Description    敏感词管理
 * @author            lizx
 * @date           2018-1-21        上午11:44:58
 */
public interface SensitivewordsService {
    /**
     * 
     * @Title          getAllSensitivewords
     * @Description    查询所有的敏感词
     * @Tags           @return   
     * @Return         List<Sensitivewords>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:45:05
     */
	List<Sensitivewords> getAllSensitivewords();
	/**
	 * 
	 * @Title          addSensitiveWordsInfo
	 * @Description    新增敏感词
	 * @Tags           @param sensitivewords
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:45:11
	 */
	int addSensitiveWordsInfo(Sensitivewords sensitivewords);
}
