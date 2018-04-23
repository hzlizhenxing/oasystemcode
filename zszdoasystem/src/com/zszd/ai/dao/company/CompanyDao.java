package com.zszd.ai.dao.company;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Classes;
import com.zszd.ai.pojo.Company;


public interface CompanyDao {
	/**
	 * 
	 * 
	 * @Title          insertCompany
	 * @Description    添加公司信息
	 * @Tags           @param company
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:40:00
	 */
	int insertCompany( Company company);
	/**
	 * 
	 * @Title          updateCompany
	 * @Description    修改公司信息
	 * @Tags           @param company
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:39:53
	 */
	int updateCompany( Company company);

	/**
	 * 
	 * @Title          queryCompanyById
	 * @Description    通过查询公司信息
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         Company   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:39:42
	 */
	Company queryCompanyById(@Param("id")Integer id);
	/**
	 * 
	 * @Title          queryCompanyInfo
	 * @Description    查询所有公司信息
	 * @Tags           @return   
	 * @Return         List<Company>   
	 * @throws
	 * @author           lvjc
	 * @date           2018-1-21        下午8:39:30
	 */
	List<Company> queryCompanyInfo();
	/**
	 * 
	 * @Title          countDepartmentByCompanyId
	 * @Description    通过公司id获得部门数量
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:30:33 PM
	 */
	int countDepartmentByCompanyId(@Param("companyId")Integer companyId);
	/**
	 * 
	 * @Title          deleteCompanyById
	 * @Description    通过id删除公司
	 * @Tags           @param id
	 * @Tags           @return   
	 * @Return         int   
	 * @throws
	 * @author           lvjc
	 * @date           Jan 25, 2018        7:31:27 PM
	 */
	int deleteCompanyById(@Param("id")Integer id);
	List<Company> queryCompanyInfoByClassLeader(@Param("name")String name);
	int getCompanyCount(@Param("queryClassName")String queryClassName, @Param("queryCompanyName")String queryCompanyName);
	List<Company> getCompanyListBy(@Param("queryClassName")String queryClassName,
			@Param("queryCompanyName")String queryCompanyName, @Param("currentPage")int currentPage, @Param("pageSize")int pageSize);
	
}
