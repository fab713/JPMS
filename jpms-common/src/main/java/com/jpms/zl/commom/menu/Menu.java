/******************************************
项目名称：jpms-manager-pojo
文件：Menu.java
作者：fab
描述：菜单模型类
创建日期：2018年10月25日 上午10:20:45
*******************************************/
package com.jpms.zl.commom.menu;

import java.util.List;



/**
 * 菜单模型类
 * <p>Title: Menu.java</p>
 * <p>Description: </p>
 * <p>Company: www.zl.cn</p> 
 * @version 1.0
 */

public class Menu {

	// 二级菜单
	private List<Menu> menus;

	// 菜单id、模块id
	private String menuid;
	// 图标
	private String icon;
	// 菜单名称/模块名称
	private String menuname;
	// 菜单链接
	private String url;

	// 菜单下的各各操作链接为了权限链接
	private List<Operation> operations;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return "Menu [menus=" + menus + ", menuid=" + menuid + ", icon=" + icon + ", menuname=" + menuname + ", url="
				+ url + "]";
	}

}
