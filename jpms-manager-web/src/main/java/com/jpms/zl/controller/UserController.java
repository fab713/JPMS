/******************************************
项目名称：jpms-manager-web
文件：UserController.java
作者：fab
描述：用户管理Controller
创建日期：2018年10月26日 下午7:53:56
*******************************************/
package com.jpms.zl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpms.zl.common.context.Config;
import com.jpms.zl.common.page.PageQuery;
import com.jpms.zl.common.pojo.DataGridResultInfo;
import com.jpms.zl.common.pojo.ResultUtil;
import com.jpms.zl.common.pojo.SubmitResultInfo;
import com.jpms.zl.common.pojo.View;
import com.jpms.zl.pojo.TbSysuser;
import com.jpms.zl.pojo.TbUsergys;
import com.jpms.zl.pojo.TbUserjd;
import com.jpms.zl.pojo.TbUseryy;
import com.jpms.zl.service.SystemConfigService;
import com.jpms.zl.service.UserManagerService;
import com.jpms.zl.vo.SysuserCustom;
import com.jpms.zl.vo.SysuserQueryVo;

/**
 * 用户管理Controller
 * <p>Title: UserController.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Controller
public class UserController {
	@Autowired
	private UserManagerService userManagerService;//用户管理的服务接口
	
	@Autowired
	private SystemConfigService systemConfigService;
	
	//用户列表查询页面，功能就是返回一个查询页面
	@RequestMapping("/userquery")//子路径 //http://localhost:8080/yycgproject/user/userquery.action
	public String userquery(Model model) throws Exception{
		//获取页面需要的数据，使用model传回页面
		//获取用户类型
		List grouplist = systemConfigService.findDictinfoByType("s01");
		model.addAttribute("grouplist", grouplist);
		return View.toBase("/user/userquery");
	}
	
	/**
	 * 用户列表查询数据结果集,即json格式的数据，使用注解ResponseBody表示方法返回json格式的数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userquery_result")
	public @ResponseBody DataGridResultInfo  userquery_result(
			SysuserQueryVo sysuserQueryVo,
			int page,
			int rows
			)throws Exception{
		
		//获取查询列表的总数
		int count  = userManagerService.findSysuserCount(sysuserQueryVo);		
		PageQuery pageQuery = new PageQuery();
		pageQuery.setPageParams(count, rows, page);
		sysuserQueryVo.setPageQuery(pageQuery);		
		//获取当前页的用户列表的数据
		List<SysuserCustom> list = userManagerService.findSysuserList(sysuserQueryVo);	
		DataGridResultInfo dataGridResultInfo = new DataGridResultInfo();
		dataGridResultInfo.setTotal(count);
		dataGridResultInfo.setRows(list);		
		return dataGridResultInfo;
	}
	
	/**
	 * 用户添加页面
	 */
	@RequestMapping("/useradd")
	public String useradd()throws Exception{

		return "/base/user/useradd";
	}
	/**
	 * 用户添加提交
	 */
	@RequestMapping("/useraddsubmit")
	public @ResponseBody SubmitResultInfo useraddsubmit(
			SysuserQueryVo sysuserQueryVo
			)throws Exception{
		Map<String,String> test  =new HashMap<String, String>();		
		//调用service执行添加		
		/*try {
			userManager.insertSysuser(sysuserQueryVo.getSysuser());
		} catch (Exception e) {
			//抛出的是我们自己定义的异常
			if(e instanceof ExceptionResultInfo){
				//获取异常信息
				ResultInfo resultInfo = ((ExceptionResultInfo)e).getResultInfo();
				//return new SubmitResultInfo(resultInfo);
				return ResultUtil.createSubmitResult(resultInfo);
			}else{
				//如果不是自定义的异常,重新创建一个“未知错误”自定义异常
				//ResultInfo resultInfo  =new ResultInfo();
	        	//resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);//设置提示信息类型为失败
	        	//resultInfo.setMessage(ResourcesUtil.getValue(Config.MESSAGE, "900"));
	        	//return new SubmitResultInfo(resultInfo);
	        	//上边4行改为工具类调用
	        	return ResultUtil.createSubmitResult(ResultUtil.createFail(Config.MESSAGE, 900, null));
			}
			
		}*/
		//使用统一异常处理器接收异常
		userManagerService.insertSysuser(sysuserQueryVo.getSysuser());
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
	/**
	 * 用户修改页面
	 */
	@RequestMapping("/useredit")
	public String  useredit(Model  model,String id) throws Exception{
		   //调用service方法获取用户信息，并将用户传到页面
		//根据用户id获取系统用户信息  
		TbSysuser sysuser = userManagerService.getSysuserByid(id);
		//获取单位名称
		//根据用户类型获取不同的单位名称
		String groupid = sysuser.getGroupid();//用户类型
		String sysid = sysuser.getSysid();//单位id
		String sysmc  =null;
		if(groupid.equals("1") || groupid.equals("2")){
			//根据单位id取出单位名称
			TbUserjd userjd = userManagerService.getUserjdById(sysid);
			sysmc = userjd.getMc();//单位名称			
		}else if(groupid.equals("3")){//医院
			TbUseryy useryy = userManagerService.getUseryyById(sysid);
			sysmc = useryy.getMc();//单位名称
		}else if(groupid.equals("4")){
			TbUsergys usergys = userManagerService.getUsergysById(sysid);
			sysmc = usergys.getMc();//单位名称
		}		
		model.addAttribute("sysuser", sysuser);//系统用户信息
		model.addAttribute("sysmc", sysmc);//单位名称	
	    return "/base/user/useredit";
	}
	/**
	 * 用户修改提交
	 */
	@RequestMapping("/usereditsubmit")
	public @ResponseBody SubmitResultInfo usereditsubmit(SysuserQueryVo sysuserQueryVo) throws Exception{	
		if(sysuserQueryVo == null){
			sysuserQueryVo = new SysuserQueryVo();
		}
		//获取页面提交的更新对象
		TbSysuser sysuser = sysuserQueryVo.getSysuser();		
		//调用service更新用户信息
		userManagerService.updateSysuser(sysuser);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}
	/**
	 * 用户删除
	 */
	@RequestMapping("/userdel")
	public @ResponseBody SubmitResultInfo userdel(String sysuserdelid) throws Exception{		
		//调用service删除用户
		userManagerService.deleteSysuser(sysuserdelid);
		return ResultUtil.createSubmitResult(ResultUtil.createSuccess(Config.MESSAGE, 906, null));
	}

}
