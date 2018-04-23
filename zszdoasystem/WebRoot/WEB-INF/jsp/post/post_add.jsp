<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<div id="right">
	<div id="add">
		<form action="${pageContext.request.contextPath}/sys/post/toaddPost.html" method="post">
			<table>
				<tr>
					<td style="width:100px">帖子类型：&nbsp;&nbsp;</td>
					<td><select name="postType" required>
							<option value="Java动态">Java动态</option>
							<option value="公司动态">公司动态</option>
							<option value="技术分享" selected>技术分享</option>
							<option value="其他">其他</option>
					</select>
					</td>
				</tr>
				<tr>
					<td style="width:100px">帖子标题：&nbsp;&nbsp;</td>
					<td><input id="postTitle" type="text" name="postTitle" />
					</td>
				</tr>
				<tr>
					<td style="width:100px">帖子内容：&nbsp;&nbsp;</td>
					<td><textarea id="postContent" name="postContent" rows="20"
							cols="70" onblur="if(this.value==''){this.value='帖子内容尽量丰富哦'}"
							onfocus="if(this.value=='帖子内容尽量丰富哦'){this.value=''}">帖子内容尽量丰富哦</textarea>
					</td>
				</tr>
				<tr>
					<td style="width:80px"><input type="submit" value="提交">
					</td>
					<td><input type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</section>
<%@ include file="../common/footer.jsp"%>
<script type="text/javascript">
	$(function() {
		$("form").submit(function() {
			var postTitle = $("#postTitle").val();
			if (postTitle.trim() == "") {
				alert("标题不能为空！");
				return false;
			}

			var postContent = $("#postContent").val();
			if (postContent.trim() == "") {
				alert("内容不能为空！");
				return false;
			}

			return true;
		});
	});
</script>
