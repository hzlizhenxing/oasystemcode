package com.zszd.ai.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Employee;

public interface EmployeeDao {

	List<Employee> queryAllEmployeeInfo();

	int queryWorkPointByName(@Param("name")String name);

	int queryIdByName(@Param("name")String name);

	int updateEmployeeWorkPoint(Employee employee);

	int updateALLEmployee(Employee employee);
	
	int queryWorkPointById(@Param("id")Integer id);

	String queryNameById(@Param("id")Integer id);

	int getEmployeeCountByGroupId(@Param("devgroupId")Integer devgroupId);
	
	Employee queryEmployeeInfoById(@Param("id")Integer id);

	int updateEmployeeInfo(Employee employee);

	String getEmployeeNameByLoginName(@Param("name")String loginname);

	List<Integer> queryIdLikeName(@Param("name")String name);

	Employee getEmployeeInfoByLoginName(@Param("name")String name);

	int insert(Employee employee);

	int queryWorkPointByAbbr(@Param("name")String name);

	int updateAllInfo(Employee employee);

	List<Employee> queryAllEmployeeInfoByCompanyId(@Param("companyId")Integer companyId);

	List<Employee> queryAllEmployeeInfoByClassLeader(@Param("name")String name);

	List<Employee> queryAllClassLeader();

	List<Employee> queryAllClassTeacher();

	int getEmployeeCount(@Param("queryEmployeeName")String queryEmployeeName, @Param("queryDevgroupName")String queryDevgroupName,
			@Param("queryDepartmentName")String queryDepartmentName, @Param("queryCompanyName")String queryCompanyName,
			@Param("_queryUserRole")Integer _queryUserRole);

	int getEmployeeCountByClassLeader(@Param("queryEmployeeName")String queryEmployeeName, @Param("queryDevgroupName")String queryDevgroupName,
			@Param("queryDepartmentName")String queryDepartmentName, @Param("queryCompanyName")String queryCompanyName,
			@Param("_queryUserRole")Integer _queryUserRole, @Param("name")String name);

	List<Employee> getEmployeeListBy(@Param("queryEmployeeName")String queryEmployeeName, @Param("queryDevgroupName")String queryDevgroupName,
			@Param("queryDepartmentName")String queryDepartmentName, @Param("queryCompanyName")String queryCompanyName,
			@Param("_queryUserRole")Integer _queryUserRole, @Param("currentPage")Integer currentPage,
			@Param("pageSize")Integer pageSize,@Param("sort") String sort);

	List<Employee> getEmployeeListByClassLeader(@Param("queryEmployeeName")String queryEmployeeName, @Param("queryDevgroupName")String queryDevgroupName,
			@Param("queryDepartmentName")String queryDepartmentName, @Param("queryCompanyName")String queryCompanyName,
			@Param("_queryUserRole")Integer _queryUserRole, @Param("name")String name,
			@Param("currentPage")Integer currentPage,
			@Param("pageSize")Integer pageSize,@Param("sort") String sort);

	Employee checkabbrExist(@Param("abbr") String abbr);

}
