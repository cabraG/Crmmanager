package com.neusoft.intercepter;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		Object obj = ActionContext.getContext().getSession().get("staff1");
		
		if (obj == null) {
			
			Action action = (Action) invocation.getAction();
			
			if(action instanceof ActionSupport) {
				
				ActionSupport actionSupport = (ActionSupport) action;
				
				actionSupport.addFieldError("", "请登录");
				
				//回到登录页面
				return "login";
				
			}
			
		}
		
		//放行
		return invocation.invoke();
	}
}
