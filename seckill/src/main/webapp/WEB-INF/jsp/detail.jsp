<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!-- 引入JSTL -->
<%@include file="common/tag.jsp"%>
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
<title>秒杀详情页</title>
<%@include file="common/head.jsp"%>
</head>
<body>
	<!-- 页面显示部分 -->
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="penel-heading">
				<h1>${seckill.name}</h1>
			</div>
		</div>
		<div class="panel-body">
			<h2 class="text-danger">
				<!-- 显示Time图标 -->
				<span class="glyphicon glyphicon-time"></span>
				<!-- 展示倒计时记事面板 -->
				<span class="glyphicon"></span>
			</h2>
		</div>
	</div>
	<!-- 登录弹出层 输入电话 -->
	<div id="killPhoneModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title text-center">
						<span class="glyphicon glyphicon-phone"></span>
					</h3>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-xs-8 col-xs-offset-2">
							<input type="text" name="killPhone" id="killPhoneKey"
								placeholder="填写手机号：" class="form-comtrol">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- 验证信息 -->
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span>Submit
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- JQuery countDown倒计时插件 -->
<script
	src="https://cdn.bootcss.com/jquery-countdown/2.0.2/jquery.countdown.min.js"></script>
<!-- JQuery Cookie操作插件 -->
<script
	src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- 开始编写交互逻辑 -->
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		//使用EL表达式传入参数
		seckill.detail.init({
			seckillId:"${seckill.id}",
			startTime:"${seckill.startTime.time}",
			endTime:"${seckill.endTime.time}"
			});
		});
</script>
</html>