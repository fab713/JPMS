/******************************************
项目名称：jpms-manager-pojo
文件：SysuserQueryVo.java
作者：fab
描述： 此对象是用于用户管理传递参数使用
创建日期：2018年10月25日 上午10:44:15
*******************************************/
package com.jpms.zl.vo;

import com.jpms.zl.common.page.PageQuery;
import com.jpms.zl.pojo.TbSysuser;

/**
 *  此对象是用于用户管理传递参数使用
 * <p>Title: SysuserQueryVo.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public class SysuserQueryVo {
	private PageQuery pageQuery ;//用于分页查询
	private TbSysuser sysuser;//用于添加信息提交
	private SysuserCustom sysuserCustom;//用于信息显示，查询条件提交
	public PageQuery getPageQuery() {
		return pageQuery;
	}
	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	public TbSysuser getSysuser() {
		return sysuser;
	}
	public void setSysuser(TbSysuser sysuser) {
		this.sysuser = sysuser;
	}
	public SysuserCustom getSysuserCustom() {
		return sysuserCustom;
	}
	public void setSysuserCustom(SysuserCustom sysuserCustom) {
		this.sysuserCustom = sysuserCustom;
	}
}
