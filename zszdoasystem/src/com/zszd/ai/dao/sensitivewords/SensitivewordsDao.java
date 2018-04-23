package com.zszd.ai.dao.sensitivewords;

import java.util.List;

import com.zszd.ai.pojo.Sensitivewords;
/**
 * 敏感词DAO接口
 * @author lizx 20180103
 *
 */
public interface SensitivewordsDao {

	List<Sensitivewords> getAllSensitivewords();

	int addSensitiveWordsInfo(Sensitivewords sensitivewords);

}
