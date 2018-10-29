/******************************************
项目名称：jpms-common
文件：ContentComparator.java
作者：fab
描述：list排序实现Comparator接口,也就是定义排序规则,你几乎可以定义任何规则
创建日期：2017年6月9日 上午12:01:51
*******************************************/
package com.jpms.zl.common.utils;

import java.util.Comparator;

/**
 * @author fab
 *
 */
public class ContentComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		int p1 = Integer.parseInt((String)o1);
		int p2 = Integer.parseInt((String)o2);
		if (p1 < p2)
			return 0;
		else
			return 1;
	}

}
