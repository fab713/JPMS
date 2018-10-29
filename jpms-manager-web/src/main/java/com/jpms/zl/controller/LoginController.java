/******************************************
项目名称：jpms-manager-web
文件：LoginController.java
作者：fab
描述：系统登录Controller
创建日期：2018年10月26日 下午7:48:05
*******************************************/
package com.jpms.zl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.common.context.Config;
import com.jpms.zl.common.pojo.ResultUtil;
import com.jpms.zl.common.pojo.SubmitResultInfo;
import com.jpms.zl.common.pojo.View;
import com.jpms.zl.service.UserManagerService;

/**
 * 系统登录Controller
 * <p>Title: LoginController.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserManagerService userManagerService;//用户管理的服务接口
	
	/**
	 * 登录页面显示
	 */
	@RequestMapping("/login")
	public String login()throws Exception{
		System.out.println("6666666666");
		return "/base/login";
	}
	/**
	 * 用户提交认证信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginsubmit")
	public @ResponseBody SubmitResultInfo loginsubmit(
			HttpServletRequest request,
			String userid,
			String pwd,
			String randomcode//验证码
			)throws Exception{
		
		//校验验证码
		//从session获取正确的验证码，和输入的对比
		HttpSession session = request.getSession();//获取session
		String randomcode_session = (String)session.getAttribute("validateCode");//从session获取正确的验证码
		//校验验证是否正确的
		if(!randomcode_session.equals(randomcode)){
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 113, null));
		}		
		//校验用户名和密码
		//用户身份信息，最终存入session
		ActiveUser activeUser = userManagerService.userlogin(userid, pwd);		
		//将认证通过用户身份信息存入session，给用户办法通行证				
		session.setAttribute(Config.ACTIVEUSER_KEY, activeUser);		
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 107, new Object[]{activeUser.getUsername()}));
	}	
	/**
	 * 用户退出
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();//获取session
		session.invalidate();//清除session
		//跳转到登录页面
		return View.redirect("first.action");
	}

}
