package com.zszd.ai.dao.bugs;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zszd.ai.pojo.Bugs;

public interface BugsDao {

	List<Bugs> queryAllDebugsInfo();

	int addBugsInfo(Bugs bugs);

	Bugs getBugsById(@Param("id")Integer id);

	int updateBugsInfo(Bugs bugs);

	List<Bugs> queryAllDebugsInfoByCompanyId(@Param("companyId")Integer companyId);

	List<Bugs> queryAllDebugsInfoByCompanyIdAndName(@Param("companyId")Integer companyId, @Param("name")String name);

}
