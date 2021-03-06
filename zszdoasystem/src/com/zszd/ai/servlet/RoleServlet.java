package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.zszd.ai.pojo.Role;
import com.zszd.ai.service.sysfunctions.RoleService;
import com.zszd.ai.service.sysfunctions.RoleServiceImpl;

/**
 * 
 * @ClassName:       RoleServlet
 * @Description:    角色管理
 * @author:            lizx
 * @date:            2018-1-20        下午4:47:29
 */
@WebServlet(urlPatterns = { "/role" }, name = "role")
public class RoleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		PrintWriter out = response.getWriter();

		RoleService roleService = new RoleServiceImpl();
		String opr = request.getParameter("opr");
		if ("list".equals(opr)) {
			List<Role> list = roleService.queryAllRoleInfo();
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/role/role_list.jsp").forward(
					request, response);
		} else if ("query".equals(opr)){
			List<Role> list = roleService.queryAllRoleInfo();
			Map<Integer,String> roleMap = new HashMap<Integer,String>();
		    if(list!=null){
		    	for (Role role : list) {
		    		roleMap.put(role.getId(), role.getRoleName());
				}
		    }
		    String roleJson = JSON.toJSONString(roleMap);
			out.print(roleJson);
		}
	}
}
