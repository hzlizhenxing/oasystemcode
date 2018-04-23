package com.zszd.ai.dao.sysfunctions;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Role;

public interface RoleDao {

	List<Role> queryAllRoleInfo();

	String queryRoleNameByRoleId(@Param("roleId")Integer roleId);

	List<Role> queryAllRoleInfoByCompany();

}
