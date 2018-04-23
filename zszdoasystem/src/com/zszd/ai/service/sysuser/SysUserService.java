package com.zszd.ai.service.sysuser;

import java.util.List;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.SysUser;
/**
 * 
 * @ClassName       SysUserService
 * @Description    系统用户接口
 * @author            lizx
 * @date           2018-1-21        上午11:45:42
 */
public interface SysUserService {
	/**
	 * 
	 * @Title          insert
	 * @Description    班主任录入用户信息
	 * @Tags           @param sysUser
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:45:48
	 */
	int insert(SysUser sysUser);
	/**
	 * 
	 * @Title          query
	 * @Description    查询OA系统的用户信息
	 * @Tags           @param sysUser
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:45:56
	 */
	int query(SysUser sysUser);
	/**
	 * 
	 * @Title          updateLoginRecord
	 * @Description    更新登录记录 包括最后登录时间，登录次数，是否登录，登录IP地址
	 * @Tags           @param sysUser
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:46:04
	 */
	int updateLoginRecord(SysUser sysUser);
	/**
	 * 
	 * @Title          queryLoginCountsByName
	 * @Description    根据用户名称查询登录次数
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:46:10
	 */
	int queryLoginCountsByName(String name);
	/**
	 * 
	 * @Title          getUserIdByUserName
	 * @Description    根据用户名称查询用户ID
	 * @Tags           @param name
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-21        上午11:46:17
	 */
    int getUserIdByUserName(String name);
    /**
     * 
     * @Title          getUserInfoByUserName
     * @Description    根据用户名称查询用户信息
     * @Tags           @param name
     * @Tags           @return   
     * @Return         SysUser   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:46:25
     */
    SysUser getUserInfoByUserName(String name);
    /**
     * 
     * @Title          updateUserPasswordInfo
     * @Description    更新用户密码信息
     * @Tags           @param sysUser
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:46:32
     */
    int updateUserPasswordInfo(SysUser sysUser);
    /**
     * 
     * @Title          updateSysUser
     * @Description    更新用户信息
     * @Tags           @param sysUser
     * @Tags           @return   
     * @Return         int   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:46:38
     */
    int updateSysUser(SysUser sysUser);
    /**
     * 
     * @Title          getAllUserInfo
     * @Description    获取所有用户信息
     * @Tags           @return   
     * @Return         List<SysUser>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:46:46
     */
    List<SysUser>  getAllUserInfo();
    /**
     * 
     * @Title          getAllOnLineUserInfo
     * @Description    获取所有在线用户信息
     * @Tags           @return   
     * @Return         List<SysUser>   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:46:55
     */
    List<SysUser>  getAllOnLineUserInfo();

    /**
     * 
     * @Title          insertNewEmployee
     * @Description    录入新员工信息
     * @Tags           @param sysUser
     * @Tags           @param employee
     * @Tags           @return   
     * @Return         boolean   
     * @throws
     * @author           lizx
     * @date           2018-1-21        上午11:47:19
     */
    boolean insertNewEmployee(SysUser sysUser, Employee employee);
    
    /**
     * 
     * @Title          login
     * @Description    用户登录
     * @Tags           @param userName
     * @Tags           @param password
     * @Tags           @return   
     * @Return         SysUser   
     * @throws
     * @author           lizx
     * @date           2018-2-12        下午3:38:45
     */
	SysUser login(String userName, String password) throws Exception;
	
	/**
	 * 查询所有系统用户
	 * @Title          queryAllSysUserInfo
	 * @Description    TODO
	 * @Tags           @return   
	 * @Return         List<SysUser>   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-14        下午9:53:49
	 */
	List<SysUser> queryAllSysUserInfo(); 
	
	    
}
