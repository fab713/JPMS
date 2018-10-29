/******************************************
项目名称：jpms-manager-web
文件：TestController.java
作者：fab
描述：测试控制类
创建日期：2018年10月24日 下午5:20:33
*******************************************/
package com.jpms.zl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.service.SystemConfigService;
import com.jpms.zl.service.UserManagerService;

/**
 * 测试控制类
 * <p>Title: TestController.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Controller
public class TestController {
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private UserManagerService userManagerService;
	@RequestMapping("/test")
	public String test() throws Exception {
		systemConfigService.findDictinfoByType("001");
		ActiveUser activeUser=userManagerService.userlogin("admin", "111111");		
		return "/base/login";
	}

}
