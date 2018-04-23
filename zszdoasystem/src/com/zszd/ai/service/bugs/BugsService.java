package com.zszd.ai.service.bugs;

import java.util.List;

import com.zszd.ai.pojo.Bugs;
/**
 * 
 * @ClassName       BugsService
 * @Description    Bug模块接口
 * @author            lizx
 * @date            2018-1-21        上午10:06:54
 */
public interface BugsService {
    /**
     * 
     * @Title          queryAllDebugsInfo
     * @Description    查询所有的bug信息
     * @Tags           @return   
     * @Return         List<Bugs>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:34:10
     */
	List<Bugs> queryAllDebugsInfo();
    /**
     * 
     * @Title          addBugsInfo
     * @Description    添加bug记录
     * @Tags           @param bugs
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:35:25
     */
	int addBugsInfo(Bugs bugs);

	/**
	 * 
	 * @Title          getBugsById
	 * @Description    根据bugID获取bug记录
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Bugs   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:35:33
	 */
	Bugs getBugsById(int id);

	/**
	 * 
	 * @Title          updateBugsInfo
	 * @Description    更新bug信息
	 * @Tags           @param bugs
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:35:47
	 */
	int updateBugsInfo(Bugs bugs);
	/**
	 * 
	 * @Title          queryAllDebugsInfoByCompanyId
	 * @Description    本公司只查看本公司的bug记录
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<Bugs>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-30        上午11:35:23
	 */
	List<Bugs> queryAllDebugsInfoByCompanyId(int companyId);
	/**
	 * 
	 * @Title          queryAllDebugsInfoByCompanyIdAndName
	 * @Description    只能查看分配给自己的bug  开发人员
	 * @Tags           @param companyId
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         List<Bugs>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-30        下午12:45:37
	 */
	List<Bugs> queryAllDebugsInfoByCompanyIdAndName(int companyId, String name);

}
