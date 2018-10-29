/******************************************
项目名称：jpms-common
文件：SubmitResultInfo.java
作者：fab
描述：系统提交结果结果类型
创建日期：2017年6月15日 下午7:48:48
*******************************************/
package com.jpms.zl.common.pojo;

import java.io.Serializable;

/**
 * @author fab
 *
 */
public class SubmitResultInfo implements Serializable {
	//操作结果信息
			private ResultInfo resultInfo;
		public SubmitResultInfo(ResultInfo resultInfo){
			this.resultInfo = resultInfo;
		}
		public ResultInfo getResultInfo() {
			return resultInfo;
		}

		public void setResultInfo(ResultInfo resultInfo) {
			this.resultInfo = resultInfo;
		}
}
