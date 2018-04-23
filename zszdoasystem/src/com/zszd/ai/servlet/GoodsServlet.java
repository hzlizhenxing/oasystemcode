package com.zszd.ai.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Goods;
import com.zszd.ai.service.GoodsService;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.impl.GoodsServiceImpl;

@WebServlet(urlPatterns = { "/goods" }, name = "GoodsServlet")
public class GoodsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");
		ServletContext application = this.getServletContext();// 获取application
		String opr = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		GoodsService goodsService = new GoodsServiceImpl();
		if (opr.equals("list")) {
			List<Goods> list = goodsService.getAllGoodsInfo();
			String loginname = (String) session.getAttribute("login");
			EmployeeService employeeService = new EmployeeServiceImpl();
			Employee employee = employeeService
					.getEmployeeInfoByLoginName(loginname);
			request.setAttribute("employee", employee);
			request.setAttribute("list", list);
			if (roleId==2) {
				request.getRequestDispatcher("jsp/welfare/wpChange/adminwp_list.jsp")
				.forward(request, response);
			}else{
				request.getRequestDispatcher("jsp/welfare/wpChange/wp_list.jsp")
				.forward(request, response);
			}
		} else if (opr.equals("view")) {// 展示当月可兑换商品的信息
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH) + 1;
			List<Goods> list = goodsService.getAllGoodsInfoByDate(year, month);
			String loginname = (String) session.getAttribute("login");
			EmployeeService employeeService = new EmployeeServiceImpl();
			Employee employee = employeeService
					.getEmployeeInfoByLoginName(loginname);
			request.setAttribute("employee", employee);
			request.setAttribute("list", list);
			if (roleId==2) {
				request.getRequestDispatcher("jsp/welfare/wpChange/adminwp_list.jsp")
				.forward(request, response);
			}else{
				request.getRequestDispatcher("jsp/welfare/wpChange/wp_list.jsp")
				.forward(request, response);
			}

		} else if (opr.equals("add")) {
			String goodsName = request.getParameter("goodsName");
			String goodsImagesPath = request.getParameter("goodsImagesPath");
			String goodsPrice = request.getParameter("goodsPrice");
			String goodsStock = request.getParameter("goodsStock");

			Goods goods = new Goods();
			goods.setGoodsName(goodsName);
			goods.setGoodsImagesPath(goodsImagesPath);
			goods.setGoodsPrice(Integer.parseInt(goodsPrice));
			goods.setGoodsStock(Integer.parseInt(goodsStock));

			int row = goodsService.addGoodsInfo(goods);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('商品提交成功，点击确认回到商品页面！');");
				out.print("location.href=\"" + basePath
						+ "goods?opr=view\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('商品已提交，请查看已提交的商品！');");
				out.print("location.href=\"" + basePath
						+ "goods?opr=view\";");
				out.print("</script>");
			}

		}
	}
}
