package com.zszd.ai.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zszd.ai.pojo.SysUser;
import com.zszd.ai.service.employee.EmployeeService;
import com.zszd.ai.service.employee.EmployeeServiceImpl;
import com.zszd.ai.service.post.PostService;
import com.zszd.ai.service.post.PostServiceImpl;
import com.zszd.ai.service.sysuser.SysUserServiceImpl;
/**
 * 头像
 * @author lizx 20180103
 *
 */
@WebServlet(urlPatterns = { "/photo" }, name = "photo")
public class PhotoServlet extends HttpServlet {

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
		PostService postService = new PostServiceImpl();
		String opr = request.getParameter("opr");
		PrintWriter out = response.getWriter();
		ServletContext application = this.getServletContext();// 获取application
		if ("upload".equals(opr)) {
			String name = request.getParameter("loginname");
		
			EmployeeService employeeService = new EmployeeServiceImpl();
			String employeeName = employeeService
					.getEmployeeNameByLoginName(name);
			
			String uploadFileName = "";
			String fieldName = ""; // 获取表单name属性值
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			SysUser sysUser = new SysUser();
			String relaFilePath = "statics/upload/";// 相对路径
			String absFilePath = application.getRealPath(relaFilePath) ;

			List<String> fillType = Arrays.asList(".jpg", ".gif", ".bmp",".png");
			if (isMultipart) {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(1024 * 30000);// 300kb
				try {
					List<FileItem> items = upload.parseRequest(request);
					Iterator<FileItem> iter = items.iterator();
					while (iter.hasNext()) {
						FileItem item = iter.next();
						fieldName = item.getFieldName();
						if (item.isFormField()) {
							if (fieldName.equals("user")) {
								sysUser.setName(item.getString());
								//out.print(item.getString("UTF-8")+ "正在上传头像。<br/>");
							}

						} else {
							uploadFileName = item.getName();// /pp.p.jpg
							// 先获取后缀名 .jpg
							String ext = uploadFileName
									.substring(uploadFileName.lastIndexOf("."));
							if (!fillType.contains(ext)) {// 判断文件类型是否匹配
								out.print("<script type='text/javascript'>");
								out.print("alert('注意文件格式只能是jpg,gif,bmp,请重新上传！！');");
								out.print("location.href=\"" + basePath
										+ "jsp/photo/photo_upload.jsp\";");
								out.print("</script>");
//								out.print("很遗憾，上传失败！<br/>");
//								out.print("注意文件格式只能是jpg,gif,bmp,请重新上传！<br/>");
							} else {
//								uploadFileName = fieldName + "_"
//										+ System.currentTimeMillis()
//										+ (int) (Math.random() * 1000) + ext;
								uploadFileName = employeeName +"的头像" +ext;
								// 上传分别控制大小 img_head 50kb img_photo 150kb
								if (fieldName.equals("photo")) {
									if (item.getSize() > 5000 * 1024) {
										throw new Exception("头像超过了5000kb");
									} else {
										sysUser.setHeadPath(relaFilePath
												+ uploadFileName);
									}
								}

								// 上传文件 file
								File file = new File(absFilePath,
										uploadFileName);
								item.write(file);
//								out.print("恭喜您，上传成功！<br/>");
//								out.print("您已经成功提交头像。<br/>上传的头像名称是：<br/>&lt&nbsp;&nbsp;"
//										+ uploadFileName + "&nbsp;&nbsp;&gt");

								// 更新系统用户头像资料
								int row = new SysUserServiceImpl()
										.updateSysUser(sysUser);
								if (row > 0) {								
									out.print("<script type='text/javascript'>");
									out.print("alert('提交头像成功，点击确认返回首页查看头像！');");
									out.print("location.href=\"" + basePath
											+ "jsp/user/userindex.jsp\";");
									out.print("</script>");
								} else {
									out.print("<script type='text/javascript'>");
									out.print("alert('提交头像失败，点击确认返回提交页面！');");
									out.print("location.href=\"" + basePath
											+ "jsp/photo/photo_upload.jsp\";");
									out.print("</script>");
								}
							}
						}
					}
				} catch (FileUploadBase.SizeLimitExceededException e) {
					out.print("<script type='text/javascript'>");
					out.print("alert('上传文件超过额定大小  30000kb,请重新上传！！');");
					out.print("location.href=\"" + basePath
							+ "jsp/photo/photo_upload.jsp\";");
					out.print("</script>");
//					out.print("上传文件超过额定大小  30000kb");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
