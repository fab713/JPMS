/******************************************
项目名称：jpms-common
文件：ExceptionResultInfo.java
作者：fab
描述：自定义系统异常类
创建日期：2017年6月15日 下午7:47:49
*******************************************/
package com.jpms.zl.process;

import com.jpms.zl.common.pojo.ResultInfo;

/**
 * @author fab
 *
 */
public class ExceptionResultInfo extends Exception {
	// 系统统一使用的结果类，包括了 提示信息类型和信息内容
			private ResultInfo resultInfo;

			public ExceptionResultInfo(ResultInfo resultInfo) {
				super(resultInfo.getMessage());
				this.resultInfo = resultInfo;
			}

			public ResultInfo getResultInfo() {
				return resultInfo;
			}

			public void setResultInfo(ResultInfo resultInfo) {
				this.resultInfo = resultInfo;
			}
}
