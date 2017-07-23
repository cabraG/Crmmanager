<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:if test="#pageall!=null">
<s:set var="page" value="#pageall"></s:set>
<s:set var="pageuri" value="'StaffAction_listStaff'"/>
</s:if>
<s:if test="#pagefind!=null">
<s:set var="page" value="#pagefind"></s:set>
<s:set var="pageuri" value="'StaffAction_staffFind'"/>
</s:if>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Calendar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$("#deptSelectId").change(function(){
			var deptSelectId = $(this).val();
			
			$.ajax({
				type:'POST',
				url:'${pageContext.request.contextPath}/StaffAction_postSelect',
				data:{
					depId:deptSelectId
				},
				success:function(data) {
					$("#postSelectId").empty();
					$("#postSelectId").append("<option value=''>----请--选--择----</option>");
					for(var i = 0;i<data.length;i++) {
						$("#postSelectId").append("<option value='" + data[i].postId + "'>" + data[i].postName + "</option>");
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
    <td width="39%" align="left">[员工管理]</td>
   
    <td width="57%"align="right">
    	<%--高级查询 --%>
		<a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--员工注入 --%>
	  	<a href="${pageContext.request.contextPath}/StaffAction_add">
	  		<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
	  	</a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>

<!-- 查询条件：马上查询 -->

<s:form action="StaffAction_staffFind">

	<table width="88%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="80px">部门：</td>
	    <td width="200px">
	    <s:select id="deptSelectId" name="depId" 
	    list="%{departmentList}" 
	    listKey="depId" 
	    listValue="depName" 
	    value="%{#staff.depId}"
	    
	    headerKey="" headerValue="----请--选--择----" >
	    </s:select>
	  
	 <%--    	<select id="deptSelectId" name="depId">
			    <option value="">----请--选--择----</option>
			    <c:if test="${departmentList!=null}">
			    	<c:forEach items="${departmentList}" var="department">
			    		<option value="${department.depId}"
			    		<c:if test="${staff.depId==department.depId}">
			    				selected = 'selected'
			    			</c:if>
			    			>${department.depName}</option>
			    	</c:forEach>
			    </c:if>
			</select> --%>

	    </td>
	    <td width="80px" >职务：</td>
	    <td width="200px" >
	  
	    <s:if test="#postlist!=null">
	      <s:select id="postSelectId" name="postId" 
	    list="%{#postlist}" 
	    listKey="postId" 
	    listValue="postName" 
	    
	    value="%{#staff.postId}"
	    headerKey="" headerValue="----请--选--择----" 
	     >
	    </s:select>
	      
	      </s:if>
	      <s:else>
	      <s:select id="postSelectId" name="postId" 
	      list="{'----请--选--择----'}"
	     />
	      
	      </s:else>
	       
	    	
	  <%-- <select id="postSelectId" name="postId">
			    <option value="">----请--选--择----</option>
			    	<c:if test="${postList!=null}">
			    		<c:forEach items="${postList}" var="post">
			    			<option value="${post.postId}" 
			    			<c:if test="${staff.postId==post.postId}">
			    					selected = 'selected'
			    				</c:if>
			    				>${post.postName}</option>
			    		</c:forEach>
			    	</c:if>
			</select> --%>

	    </td>
	    <td width="80px">姓名：</td>
	    <td width="200px" >
	   <s:textfield name="staffName" size="12" value="%{#staff.staffName}"></s:textfield></td>
	    <td ></td>
	  </tr>
	</table>
</s:form>

<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
  <tr>
    <td ><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
  </tr>
</table>

<table width="100%" border="1" >
  <tr class="henglan" style="font-weight:bold;">
    <td width="10%" align="center">员工姓名</td>
    <td width="6%" align="center">性别</td>
    <td width="12%" align="center">入职时间</td>
    <td width="15%" align="center">所属部门</td>
    <td width="10%" align="center">职务</td>
    <td width="10%" align="center">编辑</td>
  </tr>
  
    
    <s:iterator value="#page.stafflist"  status="s1">
  		<tr class="<s:property value='#s1.odd?"tabtd1":"tabtd2"'/>">
  			<td align="center"><s:property  value="staffName"/></td>
  			<td align="center"><s:property value="gender"/></td>
  			<td align="center"><s:date name="onDutyDate" format="yyyy-MM-dd"/></td>
  			<td align="center"><s:property value="depName"/></td>
  			<td align="center"><s:property value="postName"/></td>
  			<td align="center"><s:a action="StaffAction_editStaff?staffId=%{staffId}"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></s:a></td>
  		</tr>
  </s:iterator>
    	
    </table>
 <%--    
	  <tr class="tabtd1"> 
	    <td align="center">管理员</td>
	    <td align="center"></td>
	    <td align="center"></td>
	    <td align="center"></td>
	    <td align="center"></td>
	  	<td width="7%" align="center">
	  		
	  		<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	
	  	</td>
	  	
	  </tr>
    
	  <tr class="tabtd2"> 
	    <td align="center">肉丝</td>
	    <td align="center">女</td>
	    <td align="center">2013-04-16</td>
	    <td align="center">咨询部</td>
	    <td align="center">主管</td>
	  	<td width="7%" align="center">
	  		
	  		<a href="${pageContext.request.contextPath}/pages/staff/editStaff.jsp"><img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></a>	
	  	</td>
	  </tr>
</table>
--%>


<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
 

     <td align="right">
    	<span>第${page.pagenum}/${page.pages}页</span>
        <span>
       
        <s:a action="/%{pageuri}?pagen=1">[首页]</s:a>&nbsp;&nbsp;
        	<s:if test="#page.pagenum>1">
        	
        	<s:a action="%{pageuri}?pagen=%{#page.pagenum-1}">[上一页]</s:a>&nbsp;&nbsp;
        	</s:if>
        	<s:if test="#page.pagenum<#page.pages">
        	<s:a action="%{pageuri}?pagen=%{#page.pagenum+1}">[下一页]</s:a>&nbsp;&nbsp;
        	</s:if>
        	<s:a action="%{pageuri}?pagen=%{#page.pages}">[尾页]</s:a>&nbsp;&nbsp;
   
        </span>
    </td>
    
  </tr>
</table>

</body>
</html>
