/******************************************
项目名称：jpms-manager-web
文件：PermissionInterceptor.java
作者：fab
描述：权限拦截器
创建日期：2018年10月26日 下午7:33:51
*******************************************/
package com.jpms.zl.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.commom.menu.Operation;
import com.jpms.zl.common.context.Config;
import com.jpms.zl.common.utils.ResourcesUtil;

/**
 * 权限拦截器实现
 * <p>Title: PermissionInterceptor.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public class PermissionInterceptor implements HandlerInterceptor {

//权限拦截方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//校验用户请求的地址是否是公开地址
				//获取用户请求的url
				String url = request.getRequestURI();
				//例如：/yycgproject/first.action				
				//判断url是否属于公开地址，如果是公开地址放行
				//获取公开地址
				List<String> openurl_list = ResourcesUtil.gekeyList(Config.ANONYMOUS_ACTIONS);
				//校验请求的url是否在公开地址内
				for(String open_url:openurl_list){
					if(url.indexOf(open_url)>=0){
						return true;//如果是公开地址则放行
					}
				}				
				//校验是否是公共权限
				//获取公共权限 地址
				List<String> commonurl_list = ResourcesUtil.gekeyList(Config.COMMON_ACTIONS);
				//校验请求的url是否在公共权限地址内
				for(String common_url:commonurl_list){
					if(url.indexOf(common_url)>=0){
						return true;//如果是公共权限 地址则放行
					}
				}				
				//是否是用户的操作权限
				//从session中拿到用户的操作权限
				//获取session
				HttpSession session = request.getSession();
				//用户身份信息
				ActiveUser activeUser = (ActiveUser)session.getAttribute(Config.ACTIVEUSER_KEY);
				List<Operation> operations = activeUser.getOperationList();				
				//校验请求的url是否在用户操作权限地址内
				for(Operation operation_index:operations){
					String operation = operation_index.getActionUrl();
					if(url.indexOf(operation)>=0){
						return true;//如果是用户的操作权限 地址则放行
					}
				}				
				//提示用户无此操作权限
				//跳转到无此操作权限操作页面
			    request.getRequestDispatcher("/WEB-INF/jsp/base/refuse.jsp").forward(request, response);						
				return false;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根

	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根

	}

}
