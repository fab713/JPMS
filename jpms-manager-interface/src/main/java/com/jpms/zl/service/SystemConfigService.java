/******************************************
项目名称：jpms-manager-interface
文件：SystemConfigService.java
作者：fab
描述：系统级别service
创建日期：2018年10月24日 下午4:09:14
*******************************************/
package com.jpms.zl.service;

import java.util.List;

import com.jpms.zl.pojo.TbDictinfo;

/**
 * 系统级别service
 * <p>Title: SystemConfigService.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public interface SystemConfigService {
	
	
	/**
	 * 根据typecode获取数据字典的信息
	 */
	public List findDictinfoByType(String typecode) throws Exception;
	
	/**
	 * 根据数据字典中的typecode，和dictcode获取一条信息
	 */
	public TbDictinfo  findDictinfoByDictcode(String typecode,String dictcode) throws Exception;

}
