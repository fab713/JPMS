/******************************************
项目名称：jpms-manager-service
文件：UserManagerImpl.java
作者：fab
描述：用户管理服务接口实现
创建日期：2018年10月25日 下午3:57:24
*******************************************/
package com.jpms.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpms.zl.commom.menu.ActiveUser;
import com.jpms.zl.commom.menu.Menu;
import com.jpms.zl.commom.menu.Operation;
import com.jpms.zl.common.context.Config;
import com.jpms.zl.common.pojo.ResultUtil;
import com.jpms.zl.common.utils.MD5;
import com.jpms.zl.common.utils.UUIDBuild;
import com.jpms.zl.mapper.SysuserMapperCustom;
import com.jpms.zl.mapper.TbSysuserMapper;
import com.jpms.zl.mapper.TbUsergysMapper;
import com.jpms.zl.mapper.TbUserjdMapper;
import com.jpms.zl.mapper.TbUseryyMapper;
import com.jpms.zl.pojo.TbSysuser;
import com.jpms.zl.pojo.TbSysuserExample;
import com.jpms.zl.pojo.TbUsergys;
import com.jpms.zl.pojo.TbUsergysExample;
import com.jpms.zl.pojo.TbUserjd;
import com.jpms.zl.pojo.TbUserjdExample;
import com.jpms.zl.pojo.TbUseryy;
import com.jpms.zl.pojo.TbUseryyExample;
import com.jpms.zl.service.SystemConfigService;
import com.jpms.zl.service.UserManagerService;
import com.jpms.zl.vo.SysuserCustom;
import com.jpms.zl.vo.SysuserQueryVo;

/**
 * 用户管理服务接口实现
 * <p>Title: UserManagerImpl.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {
	
	@Autowired
	private TbUserjdMapper userjdMapper;
	
	@Autowired
	private  TbUsergysMapper usergysMapper;
	
	@Autowired
	private TbUseryyMapper useryyMapper;
	
	@Autowired
	private TbSysuserMapper sysuserMapper;
	
	@Autowired
	private SysuserMapperCustom sysuserMapperCustom;//自定义
	
	@Autowired
	private SystemConfigService systemConfigService;//系统服务接口

   //用户登录认证
	@Override
	public ActiveUser userlogin(String userid, String pwd) throws Exception {
		
		//根据账号取用户信息
		TbSysuser sysuser = this.getSysuserByUserid(userid);
		//如果取不到用户则表示用户不存在
		if(sysuser == null){
			//提示用户：登录用户不存在
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 101, null));
		}
		String pwd_md5 = new MD5().getMD5ofStr(pwd);//将用户输入的密码加密准备和数据的md5密码比对
		//如果取到则下一步校验密码的正确性
		if(!pwd_md5.equals(sysuser.getPwd())){
			//密码不对
			ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 114, null));
		}
		ActiveUser activeUser = new ActiveUser();
		//完善用户身份信息
		activeUser.setUserid(sysuser.getUserid());
		activeUser.setUsername(sysuser.getUsername());
		activeUser.setSysid(sysuser.getSysid());//单位id
		String sysmc=this.getSysmcBySysid(sysuser.getGroupid(), sysuser.getSysid());
		activeUser.setSysmc(sysmc);
		activeUser.setGroupid(sysuser.getGroupid());//用户类型
		String groupname = systemConfigService.findDictinfoByDictcode("s01", sysuser.getGroupid()).getInfo();//用户类型名称
		activeUser.setGroupname(groupname);
		//取出用户的菜单
		//根据用户类型id从数据字典表取出角色id		
		String roleid = systemConfigService.findDictinfoByDictcode("s01", sysuser.getGroupid()).getRemark();		
		//根据角色id获取菜单
/*		List<Menu> menu_list = sysuserMapperCustom.findMenuByroleid(roleid);
		Menu menu = new Menu();
		menu.setMenus(menu_list);
		activeUser.setMenu(menu);//将用户菜单存入用户身份对象中		
		//根据用户角色获取操作权限
		List<Operation> operations = sysuserMapperCustom.findOperatByRoleid(roleid);
		activeUser.setOperationList(operations);//将用户操作权限存入用户身份对象中
*/		return activeUser;
	}
	@Override
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo) throws Exception {
		
		return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
	}


	@Override
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
		
		return sysuserMapperCustom.findSysuserCount(sysuserQueryVo);
	}
	//根据userid获取 用户信息
	@Override
	public TbSysuser getSysuserByUserid(String userid) throws Exception {
		
		//调用dao获取用户
		TbSysuserExample sysuserExample  =new TbSysuserExample();
		TbSysuserExample.Criteria criteria = sysuserExample.createCriteria();
		criteria.andUseridEqualTo(userid);		
		List<TbSysuser> list = sysuserMapper.selectByExample(sysuserExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

//根据用户id获取用户信息
	@Override
	public TbSysuser getSysuserByid(String id) throws Exception {
		
		return sysuserMapper.selectByPrimaryKey(id);
	}

//根据用户id获取用户信息
	@Override
	public void insertSysuser(TbSysuser sysuser) throws Exception {
		//校验sysuser数据完整性
				//....
				//校验用户是否重复
				TbSysuser sysuser_v= this.getSysuserByUserid(sysuser.getUserid());
		        if(sysuser_v!=null){
		        	//提示用户您输入的用户账号已存在，不允许添加！
		        	//ResultInfo resultInfo  =new ResultInfo();
		        	//resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);//设置提示信息类型为失败
		        	//resultInfo.setMessage(ResourcesUtil.getValue(Config.MESSAGE, "208"));
		        	// throw new ExceptionResultInfo(resultInfo);
		        	 //上边三行代码改为工具类调用
		        	 ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 208, null));
		        }		        
		        //校验单位名称是否存在
		        String groupid = sysuser.getGroupid();// 用户类型
		        String sysmc = sysuser.getSysid();//页面传入单位名称
		        String sysid = null;
		        if(groupid.equals("1") || groupid.equals("2")){//获取监督单位
		        	TbUserjd userjd = this.getUserjdBymc(sysmc);
		        	if(userjd == null){
		            	 ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 209, null));		        		
		        	}
		        	 //获取单位id
		        	sysid = userjd.getId();//获取单位id
		        }else if(groupid.equals("3")){//获取医院
		        	TbUseryy useryy = this.getUseryyBymc(sysmc);
		        	if(useryy == null){
		        		//throw new Exception("根据名称获取医院信息不存在!");
		        		ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 210, null));
		        	}
		        	 //获取单位id
		        	sysid = useryy.getId();//获取单位id
		        }else if(groupid.equals("4")){//获取供货商
		        	TbUsergys usergys = this.getUsergysBymc(sysmc);
		        	if(usergys == null){
		        		//throw new Exception("根据名称获取供货商信息不存在!");
		        		ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 211, null));
		        	}
		        	 //获取单位id
		        	sysid = usergys.getId();//获取单位id
		        }

				//调用dao添加用户
				sysuser.setId(UUIDBuild.getUUID());
				sysuser.setSysid(sysid);//设置单位id
				sysuser.setPwd(new MD5().getMD5ofStr(sysuser.getPwd()));//使用md5加密				
				sysuserMapper.insert(sysuser);
	}
//用户更新
	@Override
	public void updateSysuser(TbSysuser sysuser) throws Exception {
		
		//校验用户是否重复
				String id = sysuser.getId();//修改用户自己的id
				TbSysuser sysuser_v= this.getSysuserByUserid(sysuser.getUserid());
				if(sysuser_v!=null && !sysuser_v.getId().equals(id)){//表示填写的账号是占用了别人的账号
					ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 208, null));
				}
				//获取单位名称
				
				//校验单位名称是否存在
		        String groupid = sysuser.getGroupid();// 用户类型
		        String sysmc = sysuser.getSysid();//页面传入单位名称
		        String sysid = null;
		        if(groupid.equals("1") || groupid.equals("2")){//获取监督单位
		        	TbUserjd userjd = this.getUserjdBymc(sysmc);
		        	if(userjd == null){

		            	 ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 209, null));
		        		
		        	}
		        	 //获取单位id
		        	sysid = userjd.getId();//获取单位id
		        }else if(groupid.equals("3")){//获取医院
		        	TbUseryy useryy = this.getUseryyBymc(sysmc);
		        	if(useryy == null){
		        		//throw new Exception("根据名称获取医院信息不存在!");
		        		ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 210, null));
		        	}
		        	 //获取单位id
		        	sysid = useryy.getId();//获取单位id
		        }else if(groupid.equals("4")){//获取供货商
		        	TbUsergys usergys = this.getUsergysBymc(sysmc);
		        	if(usergys == null){
		        		//throw new Exception("根据名称获取供货商信息不存在!");
		        		ResultUtil.throwExcepion(ResultUtil.createFail(Config.MESSAGE, 211, null));
		        	}
		        	 //获取单位id
		        	sysid = usergys.getId();//获取单位id
		        }
		        
		        //进行更新
		        //根据主键获取要更新的对象
		        TbSysuser sysuser_update = this.getSysuserByid(id);
		        //向更新对象中填要更新的值
		        sysuser_update.setSysid(sysid);//单位id
		        sysuser_update.setUserid(sysuser.getUserid());
		        sysuser_update.setUsername(sysuser.getUsername());
		        sysuser_update.setUserstate(sysuser.getUserstate());
		        sysuser_update.setGroupid(sysuser.getGroupid());
		        if(sysuser.getPwd()!=null && !sysuser.getPwd().equals("")){
		        	
		        	sysuser_update.setPwd(new MD5().getMD5ofStr(sysuser.getPwd()));
		        }
		        sysuserMapper.updateByPrimaryKey(sysuser_update);//执行更新
				
	}
//用户删除
	@Override
	public void deleteSysuser(String id) throws Exception {
		sysuserMapper.deleteByPrimaryKey(id);
	}

	//根据角色id获取菜单
	@Override
	public List<Menu> findMenuByroleid(String roleid) throws Exception {
//		return sysuserMapperCustom.findMenuByroleid(roleid);
		return null;
	}

	//根据用户角色获取操作权限
	@Override
	public List<Operation> findOperatByRoleid(String roleid) throws Exception {
		
//		return sysuserMapperCustom.findOperatByRoleid(roleid);
		return null;
	}

	//根据用户类型和单位id获取单位名称
	@Override
	public String getSysmcBySysid(String groupid, String sysid) throws Exception {
		 if(groupid.equals("1") || groupid.equals("2")){//获取监督单位
	        	TbUserjd userjd = this.getUserjdById(sysid);
	        	if(userjd!=null){
	        		return userjd.getMc();
	        	}
	        }else if(groupid.equals("3")){//获取医院
	        	TbUseryy useryy = this.getUseryyById(sysid);
	        	if(useryy != null){
	        		return useryy.getMc();
	        	}
	        }else if(groupid.equals("4")){//获取供货商
	        	TbUsergys usergys = this.getUsergysById(sysid);
	        	if(usergys != null){
	        		return usergys.getMc();
	        	}	        
	        }
		 return null;
	}


	@Override
	public TbUserjd getUserjdBymc(String mc) throws Exception {
	
		TbUserjdExample userjdExample = new TbUserjdExample();
		TbUserjdExample.Criteria criteria = userjdExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<TbUserjd> list = userjdMapper.selectByExample(userjdExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}
     //根据id获取供货商单位
	@Override
	public TbUserjd getUserjdById(String id) throws Exception {
		
		 return userjdMapper.selectByPrimaryKey(id);
	}

	//根据名称获取供货商单位
	@Override
	public TbUsergys getUsergysBymc(String mc) throws Exception {
		
		TbUsergysExample usergysExample = new TbUsergysExample();
		TbUsergysExample.Criteria criteria = usergysExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<TbUsergys> list = usergysMapper.selectByExample(usergysExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

	   
	@Override
	public TbUsergys getUsergysById(String id) throws Exception {
	
		return usergysMapper.selectByPrimaryKey(id);
	}

	//根据名称获取单位
	@Override
	public TbUseryy getUseryyBymc(String mc) throws Exception {
		
		TbUseryyExample useryyExample = new TbUseryyExample();
		TbUseryyExample.Criteria criteria = useryyExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<TbUseryy> list = useryyMapper.selectByExample(useryyExample);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

	//根据id获取单位
	@Override
	public TbUseryy getUseryyById(String id) throws Exception {
		
		return useryyMapper.selectByPrimaryKey(id);
	}

}
