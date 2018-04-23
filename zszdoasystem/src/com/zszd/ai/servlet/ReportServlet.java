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

import com.zszd.ai.pojo.Report;
import com.zszd.ai.pojo.ReportType;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.report.ReportServiceImpl;
@WebServlet(urlPatterns = { "/report" }, name = "report")
public class ReportServlet extends HttpServlet {


	public ReportServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); 
		
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		String opr = request.getParameter("opr");
		HttpSession session = request.getSession();// 获取session
		String name = (String) session.getAttribute("login");
		int roleId = (Integer) session.getAttribute("roleId");
		int companyId = (Integer) session.getAttribute("companyId");
		PrintWriter out = response.getWriter();
		ReportServiceImpl reportService=new ReportServiceImpl();
		String reportId = request.getParameter("reportId");
		List<ReportType> reportTypelist=reportService.getAllReportType();
		request.setAttribute("reportTypelist", reportTypelist);
		if (opr.equals("list")){
			EmployeeService employeeService = new EmployeeServiceImpl();
			String employeeName = employeeService
					.getEmployeeNameByLoginName(name);
			List<Report> list=null;
			if (roleId == 6) {
				list = reportService.getUserbyuserName(employeeName);
			} else if(roleId ==5 || roleId == 4){
				list = reportService.getAllReportListByCompanyId(companyId);
			} else{
				list = reportService.getAllReportList();
			}
			request.setAttribute("list", list);
			request.getRequestDispatcher("jsp/report/report_list.jsp")
					.forward(request, response);
		}else if ("modify".equals(opr)) {
			Report report = reportService.getReportbyId(Integer.valueOf(reportId));
					
			request.setAttribute("report", report);
			request.getRequestDispatcher(
					"jsp/report/report_modify.jsp").forward(request,
					response);
		
		}else if("delete".equals(opr)){
			out.print("<script type='text/javascript'>");
			out.print("alert('确认要删除吗？点击确认删除！');");
			out.print("location.href=\"" + basePath
					+ "report?opr=deletereport&reportId="
					+ reportId + "\";");
			out.print("</script>");
		}else if ("deletereport".equals(opr)) {
			EmployeeService employeeService = new EmployeeServiceImpl();
			String employeeName = employeeService
					.getEmployeeNameByLoginName(name);
		
			
			if (reportService.deleteUserbyId(Integer.parseInt(reportId)) > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('成功删除该工作日志，点击确认返回工作日志信息列表！');");
				out.print("location.href=\"" + basePath
						+ "report?opr=list&loginname=admin\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('删除工作日志失败，请联系管理员！点击确认返回工作日志信息列表！');");
				out.print("location.href=\"" + basePath
						+ "report?opr=list&loginname=admin\";");
				out.print("</script>");
			}
			
		}else if ("toadd".equals(opr)) {
			
			request.getRequestDispatcher("jsp/report/report_add.jsp")
					.forward(request, response);
		}else if("add".equals(opr)){
			String reporttype=request.getParameter("reporttype");
			
			ReportType rtype=null;
			rtype=reportService.gettypeIdByReportTypename(reporttype);
			Integer typeId=rtype.getId();
			String answer=request.getParameter("question");
			String finish=request.getParameter("finishwork");
			String plan=request.getParameter("plan");
			String remark=request.getParameter("remark");
			EmployeeService employeeService = new EmployeeServiceImpl();
			String employeeName = employeeService
					.getEmployeeNameByLoginName(name);
			Report report=new Report();
			report.setTypeId(typeId);
			report.setUsername(employeeName);
			report.setQuestion(answer);
			report.setFinishwork(finish);
			report.setPlan(plan);
			report.setRemark(remark);
			try {
				int  row = reportService.addReport(report);
				boolean flag=false;
				if(row>0){
					flag=true;
				}
				if (flag) {				
					out.print("<script type='text/javascript'>");
					out.print("alert('工作日志提交成功，点击确认返回工作日志列表！');");
					out.print("location.href=\"" + basePath
							+ "report?opr=list&loginname=" + name + "\";");
					out.print("</script>");
				} else {
					out.print("<script type='text/javascript'>");
					out.print("alert('工作日志提交失败，请重新添加！');");
					out.print("location.href=\"" + basePath
							+ "jsp/report/report_add.jsp\";");
					out.print("</script>");
				}
			} catch (Exception e) {
				out.print("<script type='text/javascript'>");
				out.print("alert('工作日志提交失败，请重新添加！');");
				out.print("location.href=\"" + basePath
						+ "jsp/report/report_add.jsp\";");
				out.print("</script>");
			}
			
			
		}else if ("submitModify".equals(opr)) {
			String reporttype=request.getParameter("reporttype");
			
			
			ReportType rtype=reportService.gettypeIdByReportTypename(reporttype);
			Integer typeId=rtype.getId();
			String question=request.getParameter("question");
			String finish=request.getParameter("finishwork");
			String plan=request.getParameter("plan");
			String remark=request.getParameter("remark");
		
		
			String reportIdchange = request.getParameter("reportIdchange");
			Report report=new Report();
			
	
			report.setId(Integer.valueOf(reportIdchange));
			report.setTypeId(typeId);
			report.setQuestion(question);
			report.setFinishwork(finish);
			report.setPlan(plan);
			report.setRemark(remark);
			int row = reportService.modifyReport(report);
			if (row > 0) {
				out.print("<script type='text/javascript'>");
				out.print("alert('工作日志更新成功，点击确认返回工作日志信息列表！');");
				out.print("location.href=\"" + basePath
						+ "report?opr=list&loginname=" + name + "\";");
				out.print("</script>");
			} else {
				out.print("<script type='text/javascript'>");
				out.print("alert('工作日志更新失败，点击确认返回工作日志信息列表！');");
				out.print("location.href=\"" + basePath
						+ "report?opr=list&loginname=" + name + "\";");
				out.print("</script>");
			}
		
		}
	}

	
	public void init() throws ServletException {
	
	}

}
