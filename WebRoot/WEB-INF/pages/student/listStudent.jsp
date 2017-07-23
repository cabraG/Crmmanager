<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#courseSelectId").change(function(){
			var courseSelectId = $(this).val();
			
			$.ajax({
				type:'POST',
				url:'${pageContext.request.contextPath}/ClssAction_ajaxCourseAndClass',
				data:{
					courseId:courseSelectId
				},
				success:function(data) {
					$("#classSelectId").empty();
					$("#classSelectId").append("<option value=''>----请--选--择----</option>");
					for(var i = 0;i<data.length;i++) {
						$("#classSelectId").append("<option value='" + data[i].classId + "'>" + data[i].className + "</option>");
					}
				}
			});
			
		});
	});
</script>
</head>

<body >
 <table border="0" cellspacing="0" cellpadding="0" width="100%">
  <tr>
    <td class="topg"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0"  class="wukuang"width="100%">
  <tr>
    <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
    <td width="39%" align="left">[在校学生管理]</td>
   
    <td width="57%"align="right">
    	<%--查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit();"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--添加 --%>
    	<a href="${pageContext.request.contextPath}/pages/student/addOrEditStudent.jsp">
    		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
    	</a>
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：添加或选择马上查询 -->
<form action="${pageContext.request.contextPath}/StudentAction_listorfind" method="post">
	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">查询条件：</td>
	    <td width="300px"><input type="text" name="targetse" size="20" value="${student.targetse}"/>（姓名|电话|QQ）</td>
	    <td width="500px">
	    	课程类别：
	    	<select id="courseSelectId" name="courseId">
			    <option value="">----请--选--择----</option>
			    <c:if test="${courselist!=null}">
			    	<c:forEach items="${courselist}" var="course">
			    		<option value="${course.courseId}"
			    		<c:if test="${courseSelect==course.courseId}">
			    				selected = 'selected'
			    			</c:if>
			    			>${course.courseName}</option>
			    	</c:forEach>
			    </c:if>
			</select>

	    	班级： <select id="classSelectId" name="classId">
			    <option value="">----请--选--择----</option>
			    <c:if test="${classlist!=null}">
			    	<c:forEach items="${classlist}" var="crmclass">
			    		<option value="${crmclass.classId}"
			    		<c:if test="${student.classId==crmclass.classId}">
			    				selected = 'selected'
			    			</c:if>
			    		>${crmclass.className}</option>
			    	</c:forEach>
			    </c:if>
			    	
			</select>
	    </td>
	    <td></td>
	  </tr>
	</table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>
<table width="100%" border="1" >
  
  <tr class="henglan" style="font-weight:bold;">

    <td width="10%" align="center">姓名</td>
    <td width="10%" align="center">入学时间</td>
    <td width="10%" align="center">班级</td>
    <td width="10%" align="center">QQ</td>
    <td width="10%" align="center">联系电话</td>
    <td width="10%" align="center">已付/应付学费</td>
    <td width="10%" align="center">状态</td>  <!-- 新生、转班、升级、退费、毕业 -->
  	
  </tr>
  <c:if test="${page!=null}">
  <c:forEach items="${page.studentlist}" var="stu">
	   <tr class="tabtd1">
		<td align="center">${stu.stuname}</td>
		<td align="center">${stu.starttime} </td>
		<td align="center">${stu.className}</td>
		<td align="center">${stu.qq}</td>
		<td align="center">${stu.stuphone}</td>
		<td align="center">${stu.tutioncost}/${stu.tution}</td>
		<td align="center">${stu.statusName}</td>
		
	    
	  </tr>
	  </c:forEach>
  </c:if>
	 
</table>



<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td align="right">
    	<span>第${page.pagenum}/${page.pages}页</span>
        <span>
        	<a href="${pageContext.request.contextPath}/StudentAction_listorfind?pagen=1">[首页]</a>&nbsp;&nbsp;
        	<c:choose>
        <c:when test="${page.pagenum >1}">
            <a href="${pageContext.request.contextPath}/StudentAction_listorfind?pagen=${page.pagenum-1}">[上一页]</a>&nbsp;&nbsp;
            </c:when>
            </c:choose>
            
            <c:choose>
            <c:when test="${page.pagenum<page.pages}">
            <a href="${pageContext.request.contextPath}/StudentAction_listorfind?pagen=${page.pagenum+1}">[下一页]</a>&nbsp;&nbsp;
            </c:when>
            </c:choose>
            <a href="${pageContext.request.contextPath}/StudentAction_listorfind?pagen=${page.pages}">[尾页]</a>
        </span>
    </td>
  </tr>
</table>
</body>
</html>