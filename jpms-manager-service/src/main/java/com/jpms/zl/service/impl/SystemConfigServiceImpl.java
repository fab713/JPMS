/******************************************
项目名称：jpms-manager-service
文件：SystemConfigServiceImpl.java
作者：fab
描述：系统级别服务接口实现
创建日期：2018年10月24日 下午4:24:16
*******************************************/
package com.jpms.zl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jpms.zl.mapper.TbDictinfoMapper;
import com.jpms.zl.pojo.TbDictinfo;
import com.jpms.zl.pojo.TbDictinfoExample;
import com.jpms.zl.service.SystemConfigService;

/**
 * 系统级别服务接口实现
 * <p>Title: SystemConfigServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService {
    @Autowired
	private TbDictinfoMapper tbDictinfoMapper;
	/* 
	 * 根据数据字典typecode获取字典明细信息
	 */
	@Override
	public List findDictinfoByType(String typecode) throws Exception {
		List<TbDictinfo>list=new ArrayList<TbDictinfo>();
		TbDictinfoExample example=new TbDictinfoExample();
		TbDictinfoExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typecode);		
		list=tbDictinfoMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			return list;
		}
		return null;
	}

	/* 
	 * 根据typeocde和dictcode获取单个字典明细
	 */
	@Override
	public TbDictinfo findDictinfoByDictcode(String typecode, String dictcode) throws Exception {
		List<TbDictinfo>list=new ArrayList<TbDictinfo>();
		TbDictinfoExample example=new TbDictinfoExample();
		TbDictinfoExample.Criteria criteria=example.createCriteria();
		criteria.andTypecodeEqualTo(typecode);
		criteria.andDictcodeEqualTo(dictcode);
		list=tbDictinfoMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

}
