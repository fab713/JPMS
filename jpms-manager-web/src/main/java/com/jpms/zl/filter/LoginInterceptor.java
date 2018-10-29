/******************************************
项目名称：jpms-manager-web
文件：LoginInterceptor.java
作者：fab
描述：用户身份认证拦截
创建日期：2018年10月26日 下午7:21:37
*******************************************/
package com.jpms.zl.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.common.context.Config;
import com.jpms.zl.common.utils.ResourcesUtil;

/**
 * 用户身份认证拦截实现
 * <p>Title: LoginInterceptor.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public class LoginInterceptor implements HandlerInterceptor {
	/**
	 * 进行action方法之前执行,在此方法实现身份认证拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		//获取session
		HttpSession session = request.getSession();
		//用户身份信息
		ActiveUser activeUser = (ActiveUser)session.getAttribute(Config.ACTIVEUSER_KEY);
		if(activeUser!=null){//表示用户已登录
			return true;//放行继续访问
		}
		//获取用户请求的url
		String url = request.getRequestURI();
		//例如：/yycgproject/first.action
		
		//判断url是否属于公开地址，如果是公开地址放行
		//获取公开地址
		List<String> openurl_list = ResourcesUtil.gekeyList(Config.ANONYMOUS_ACTIONS);
		
		//校验请求的url是否在公开地址内
		for(String open_url:openurl_list){
			if(url.indexOf(open_url)>=0){
				return true;
			}
		}
		//挑战到登录页面
		request.getRequestDispatcher("/WEB-INF/jsp/base/login.jsp").forward(request, response);
		
		return false;
	}

	/**
	 * 执行action方法返回视图之前执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO 自动生成的方法存根
		// 根据个性化需求对view进行重新编辑，从而返回浏览器
	}
	/**
	 * 执行action方法完成执行此方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO 自动生成的方法存根
		// 在这个方法记录操作日志 
	}

}
