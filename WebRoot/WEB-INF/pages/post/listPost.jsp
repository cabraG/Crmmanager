<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="/struts-tags"  prefix="s"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet" />

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
    <td width="39%" align="left">[职务管理]</td>
   
    <td width="57%"align="right">
    <a href="javascript:void(0)" onclick="document.forms[0].submit()"><img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif" /></a>
    	<%--添加职务 --%>
       <a href="${pageContext.request.contextPath}/PostAction_add">
       	<img src="${pageContext.request.contextPath}/images/button/tianjia.gif" />
       </a>
      
    </td>
    <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
  </tr>
</table>
<s:form action="PostAction_listorfind">
	<table width="50%" border="0" style="margin: 20px;" >
	  <tr>
	    <td width="8px">部门：</td>
	    <td width="8px">
	   
	    	<s:select id="deptSelectId" name="depId" 
	    list="%{#departmentList}" 
	    listKey="depId" 
	    listValue="depName"
	    value="#session.depId"
	    headerKey="" headerValue="----请--选--择----" >
	    </s:select>
			</td>
	     <td width="8px">职务：</td>
	    <td width="8px" ><s:textfield name="postName" value="%{#session.postName}"/> </td>
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
    <td width="6%" align="center">部门名称</td>
    <td width="6%" align="center">职务名称</td>
    <td width="7%" align="center">编辑</td>
  </tr>
   <s:iterator value="#page.postlist"  status="p1">
   <tr class="<s:property value='#p1.odd?"tabtd1":"tabtd2"'/>">
  			
  			<td align="center"><s:property value="depName"/></td>
  			<td align="center"><s:property value="postName"/></td>
  			<td align="center"><s:a action="PostAction_edit?postId=%{postId}">
  			<img src="${pageContext.request.contextPath}/images/button/modify.gif" class="img" /></s:a></td>
  		</tr>
   
   
   
   </s:iterator>
  
</table>



<table border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
 
   
     <td align="right">
    	<span>第${page.pagenum}/${page.pages}页</span>
        <span>
        	<s:a action="PostAction_listorfind?pagen=1">[首页]</s:a>&nbsp;&nbsp;
        	<s:if test="#page.pagenum>1">
        	
        	<s:a action="PostAction_listorfind?pagen=%{#page.pagenum-1}">[上一页]</s:a>&nbsp;&nbsp;
        	</s:if>
        	<s:if test="#page.pagenum<#page.pages">
        	<s:a action="PostAction_listorfind?pagen=%{#page.pagenum+1}">[下一页]</s:a>&nbsp;&nbsp;
        	</s:if>
        	<s:a action="PostAction_listorfind?pagen=%{#page.pages}">[尾页]</s:a>&nbsp;&nbsp;
        </span>
    </td>
    
  </tr>
</table>
</body>
</html>
