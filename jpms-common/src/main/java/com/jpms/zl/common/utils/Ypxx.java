/******************************************
项目名称：jpms-common
文件：Ypxx.java
作者：fab
描述：TODO
创建日期：2017年6月9日 上午9:17:06
*******************************************/
package com.jpms.zl.common.utils;

/**
 * @author fab
 *
 */
public class Ypxx {

	private String bm;
	private String mc;
	private float price;
	
	public Ypxx(String bm,String mc,float price){
		this.bm = bm;
		this.mc = mc;
		this.price = price;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Ypxx [bm=" + bm + ", mc=" + mc + ", price=" + price + "]";
	}
	
	

}
