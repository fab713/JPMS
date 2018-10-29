/******************************************
项目名称：jpms-manager-pojo
文件：SysuserCustom.java
作者：fab
描述：用户封装类
创建日期：2018年10月25日 上午10:39:09
*******************************************/
package com.jpms.zl.vo;

import com.jpms.zl.pojo.TbSysuser;

/**
 * 用户封装类,用于信息显示，查询条件提交
 * <p>Title: SysuserCustom.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public class SysuserCustom extends TbSysuser {
    private String groupname;//用户类型的名称
    private String sysmc;//单位名称

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getSysmc() {
		return sysmc;
	}

	public void setSysmc(String sysmc) {
		this.sysmc = sysmc;
	}
}
