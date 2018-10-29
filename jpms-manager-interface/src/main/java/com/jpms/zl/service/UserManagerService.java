/******************************************
项目名称：jpms-manager-interface
文件：UserManager.java
作者：fab
描述：用户管理服务接口
创建日期：2018年10月25日 上午10:51:48
*******************************************/
package com.jpms.zl.service;

import java.util.List;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.commom.menu.Menu;
import com.jpms.zl.commom.menu.Operation;
import com.jpms.zl.pojo.TbSysuser;
import com.jpms.zl.pojo.TbUsergys;
import com.jpms.zl.pojo.TbUserjd;
import com.jpms.zl.pojo.TbUseryy;
import com.jpms.zl.vo.SysuserCustom;
import com.jpms.zl.vo.SysuserQueryVo;

/**
 * 用户管理服务接口
 * <p>Title: UserManager.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public interface UserManagerService {
	

	/**
	 * 用户登录认证
	 * 用户认方通过返回用户身份信息ActiveUser
	 */
	public ActiveUser userlogin(String userid,String pwd)throws Exception; 
	
	/**
	 * 系统用户查询
	 */
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
	
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception;
	/**
	 * 根据用户账号获取用户信息
	 */
	public TbSysuser getSysuserByUserid(String userid) throws Exception;
	
	/**
	 * 根据用户id获取用户信息
	 */
	public TbSysuser getSysuserByid(String id) throws Exception;

	/**
	 * 用户添加
	 */
	public void insertSysuser(TbSysuser sysuser)throws Exception;
	/**
	 * 用户更新
	 */
	public void updateSysuser(TbSysuser sysuser) throws Exception;
	
	/**
	 * 用户删除
	 */
	public void deleteSysuser(String id) throws Exception;
	
	/**
	 * 根据角色id获取菜单
	 */
	public List<Menu> findMenuByroleid(String roleid) throws Exception;
	/**
	 * 根据用户角色获取操作权限
	 */
	public List<Operation> findOperatByRoleid(String roleid) throws Exception;
	
	//根据用户类型和单位id获取单位名称
	public String getSysmcBySysid(String groupid,String sysid) throws Exception;
	/**
	 * 根据名称获取监督单位
	 */
	public TbUserjd getUserjdBymc(String mc) throws Exception;
	public TbUserjd getUserjdById(String id) throws Exception;
	
	/**
	 * 根据名称获取供货商单位
	 */
	public TbUsergys getUsergysBymc(String mc) throws Exception;
	public TbUsergys getUsergysById(String id) throws Exception;
	
	/**
	 * 根据名称获取医院单位
	 */
	public TbUseryy getUseryyBymc(String mc) throws Exception;
	public TbUseryy getUseryyById(String id) throws Exception;

	

}
