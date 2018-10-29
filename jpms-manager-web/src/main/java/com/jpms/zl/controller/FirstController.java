/******************************************
项目名称：jpms-manager-web
文件：FirstController.java
作者：fab
描述：系统首页Controller
创建日期：2018年10月26日 下午7:41:14
*******************************************/
package com.jpms.zl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.commom.menu.Menu;
import com.jpms.zl.common.context.Config;
import com.jpms.zl.service.SystemConfigService;
import com.jpms.zl.service.UserManagerService;
import com.jpms.zl.vo.SysuserCustom;

/**
 *  系统首页Controller
 * <p>Title: FirstController.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Controller
public class FirstController {
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private UserManagerService userManagerService;//用户管理的服务接口
	
	@RequestMapping("/first")//访问http://localhost:8080/yycgproject/first.action
	public String first(Model model)throws Exception{
		
		List<SysuserCustom> list = userManagerService.findSysuserList(null);
		model.addAttribute("sysuser", list.get(0));
		 
		return "/base/first";//返回jsp页面
		
	}
	@RequestMapping("/welcome")
	public String welcome()throws Exception{
		
		return "/base/welcome";
	}
	
	/**
	 * 获取菜单菜单，并转成json
	 */
	@RequestMapping("/usermenu")
	public @ResponseBody Menu usermenu(HttpServletRequest request)throws Exception{
		HttpSession session = request.getSession();
		ActiveUser activeUser =(ActiveUser) session.getAttribute(Config.ACTIVEUSER_KEY);
		return activeUser.getMenu();
	}
}
