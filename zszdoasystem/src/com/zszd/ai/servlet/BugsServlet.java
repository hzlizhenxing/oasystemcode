package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Bugs;
import com.zszd.ai.service.bugs.BugsService;
import com.zszd.ai.service.bugs.BugsServiceImpl;

@WebServlet(urlPatterns = { "/bugs" }, name = "bugs")
public class BugsServlet extends HttpServlet {

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
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";

		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");

		PrintWriter out = response.getWriter();

		BugsService bugsService = new BugsServiceImpl();
		String opr = request.getParameter("opr");
		if ("list".equals(opr)) {
			List<Bugs> list = null;
			if (roleId == 6) {
				list = bugsService.queryAllDebugsInfoByCompanyIdAndName(companyId,name);
			}else if (roleId == 4 || roleId == 5) {
				list = bugsService.queryAllDebugsInfoByCompanyId(companyId);
			} else {
				list = bugsService.queryAllDebugsInfo();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/bugs/bugs_list.jsp").forward(
					request, response);
		} else if ("add".equals(opr)) {
			String title = request.getParameter("bugsTitle");
			String content = request.getParameter("bugsContent");
			Bugs bugs = new Bugs();
			bugs.setUserName(name);
			bugs.setTitle(title);
			bugs.setContent(content);

			int row = bugsService.addBugsInfo(bugs);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('bug提交成功，点击确认回到bug页面！');");
				out.print("location.href=\"" + basePath + "bugs?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('bug提交失败，请重新添加！');");
				out.print("location.href=\"" + basePath
						+ "jsp/bugs/bugs_add.jsp\";");
				out.print("</script>");
			}
		} else if ("modify".equals(opr)) {
			String id = request.getParameter("id");
			Bugs bugs = bugsService.getBugsById(Integer.valueOf(id));
			request.setAttribute("bugs", bugs);
			request.getRequestDispatcher("jsp/bugs/bugs_modify.jsp").forward(
					request, response);
		} else if ("submitModify".equals(opr)) {
			String title = request.getParameter("bugsTitle");
			String content = request.getParameter("bugsContent");
			String id = request.getParameter("id");
			Bugs bugs = new Bugs();
			bugs.setId(Integer.valueOf(id));
			bugs.setTitle(title);
			bugs.setContent(content);
			int row = bugsService.updateBugsInfo(bugs);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('bug信息更新成功，点击确认返回bug信息列表！');");
				out.print("location.href=\"" + basePath + "bugs?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('bug信息更新失败，点击确认返回bug信息列表！');");
				out.print("location.href=\"" + basePath + "bugs?opr=list\";");
				out.print("</script>");
			}
		} else if("submitCheck".equals(opr)){
			String id = request.getParameter("id");
			String title = request.getParameter("bugsTitle");
			String content = request.getParameter("bugsContent");
			String resolveDevName=request.getParameter("resolveDevName");
			Bugs bugs = new Bugs();
			bugs.setId(Integer.valueOf(id));
			bugs.setState("开发中");
			bugs.setResolveDevName(resolveDevName);
			bugs.setTitle(title);
			bugs.setContent(content);
			
			int row = bugsService.updateBugsInfo(bugs);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('状态更新成功，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "bugs?opr=list\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('状态更新失败，点击确认返回需求信息列表！');");
				out.print("location.href=\"" + basePath + "bugs?opr=list\";");
				out.print("</script>");
			}
		}else if("check".equals(opr)){
			String id = request.getParameter("id");
			Bugs bugs = bugsService.getBugsById(Integer.valueOf(id));
			request.setAttribute("bugs", bugs);
			request.getRequestDispatcher("jsp/bugs/bugs_check.jsp").forward(
					request, response);
		} 
	}
}
