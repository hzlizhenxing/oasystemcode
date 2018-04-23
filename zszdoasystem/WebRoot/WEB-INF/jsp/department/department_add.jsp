<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form action="department?opr=submitAdd" method="post">
			<table>
				<tr>
					<td style="width:500px;">部门名称：<input type="text"
						name="departmentName" required />
					</td>
				</tr>
				<tr>
					<td style="width:500px;">电话号码：<input type="text"
						name="departmentTel" id="departmentTel" /><font color="red"
						id="telText"></font></td>
				</tr>
				<tr>
					<td style="width:500px;">传真号码：<input type="text"
						name="departmentFax" id="departmentFax"><font color="red"
						id="faxText"></font>
					</td>
				</tr>
				<tr>
					<td style="width:500px;">创建时间：<input type="date"
						name="departmentTime">
					</td>
				</tr>
				<tr>
					<td style="width:500px;">部门地址：<select id="s_province"
						name="s_province"></select> <select id="s_city" name="s_city"></select>
						<select id="s_county" name="s_county"></select>&nbsp;<input
						name="detail">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交 ">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>

<script class="resources library"
	src="http://sandbox.runjs.cn/uploads/rs/267/g3ugugjp/area.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		_init_area();
		$("#departmentTel").blur(checkTel);
		$("#departmentFax").blur(checkFax);
		function checkTel() {
			var mobile = $("#departmentTel").val();
			var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
			if (!reg.test(mobile)) {
				$("#telText").html("电话号码不正确！");
				return false;
			}
			$("#telText").html("");
			return true;
		}
		function checkFax() {
			var mobile = $("#departmentFax").val();
			var reg = /^((0\d{2,3}-\d{7,8})|(1[3584]\d{9}))$/;
			if (!reg.test(mobile)) {
				$("#faxText").html("传真号码不正确！");
				return false;
			}
			$("#faxText").html("");
			return true;
		}
	});
</script>
