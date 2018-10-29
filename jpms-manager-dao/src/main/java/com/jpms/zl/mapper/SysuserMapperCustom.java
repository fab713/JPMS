/******************************************
项目名称：jpms-manager-dao
文件：SysuserMapperCustom.java
作者：fab
描述：TODO
创建日期：2018年10月25日 上午10:56:10
*******************************************/
package com.jpms.zl.mapper;

import java.util.List;

import com.jpms.zl.commom.menu.Menu;
import com.jpms.zl.commom.menu.Operation;
import com.jpms.zl.vo.SysuserCustom;
import com.jpms.zl.vo.SysuserQueryVo;

/**
 * <p>Title: SysuserMapperCustom.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public interface SysuserMapperCustom {
	
	/**
	 * findSysuserList名称和mapper.xml的id保持一致
	 * @param sysuser
	 * @return
	 * @throws Exception
	 */
	public List<SysuserCustom>  findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception;
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo)throws Exception;
	/**
	 * 根据用户角色获取菜单
	 */
//	public List<Menu> findMenuByroleid(String roleid) throws Exception;
	
	/**
	 * 根据用户角色获取操作权限
	 */
//	public List<Operation> findOperatByRoleid(String roleid) throws Exception;

}
