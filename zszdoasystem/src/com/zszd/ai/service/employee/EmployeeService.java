package com.zszd.ai.service.employee;

import java.util.List;

import com.zszd.ai.pojo.Employee;
/**
 * 
 * @ClassName       EmployeeService
 * @Description    员工接口
 * @author            lizx
 * @date           2018-1-29        上午2:21:18
 */
public interface EmployeeService {

	List<Employee> queryAllEmployeeInfo();

	int queryWorkPointByName(String name);
		
	String queryNameById(int id);

	int getEmployeeCountByGroupId(int groupId);
	
	Employee queryEmployeeInfoById(int id);
	
	Employee getEmployeeInfoByLoginName(String name);
	
	int updateEmployeeInfo(Employee employee);
	
	String getEmployeeNameByLoginName(String loginname);

	int queryWorkPointByAbbr(String name);

	int updateAllInfo(Employee employee);

	int insert(Employee employee);

	int queryIdByName(String name);

	List<Integer> queryIdLikeName(String name);

	/**
	 * 
	 * @Title          queryAllEmployeeInfoByCompanyId
	 * @Description    查询公司的所有员工信息
	 * @Tags           @param companyId
	 * @Tags           @return   
	 * @Return         List<Employee>   
	 * @throws
	 * @author           lizx
	 * @date           2018-1-29        上午2:21:33
	 */
	List<Employee> queryAllEmployeeInfoByCompanyId(int companyId);

	List<Employee> queryAllEmployeeInfoByClassLeader(String name);

	List<Employee> queryAllClassLeader();

	List<Employee> queryAllClassTeacher();

	int getEmployeeCount(String queryEmployeeName, String queryDevgroupName,
			String queryDepartmentName, String queryCompanyName,
			int _queryUserRole);

	int getEmployeeCountByClassLeader(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole, String name);

	List<Employee> getEmployeeListBy(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole, int currentPage,
			int pageSize,String sort);

	List<Employee> getEmployeeListByClassLeader(String queryEmployeeName,
			String queryDevgroupName, String queryDepartmentName,
			String queryCompanyName, int _queryUserRole, String name,
			int currentPage, int pageSize,String sort);

	Employee checkabbrExist(String abbr);
	
	
}
