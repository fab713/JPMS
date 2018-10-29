/******************************************
项目名称：jpms-common
文件：ResultUtil.java
作者：fab
描述：系统结果工具类
创建日期：2017年6月15日 下午7:44:49
*******************************************/
package com.jpms.zl.common.pojo;

import java.util.List;

import com.jpms.zl.common.utils.ResourcesUtil;



/**
 * @author fab
 *
 */
public class ResultUtil {
	 /**
     * 创建错误结果
     * @param MESSAGE
     * @return
     */
    public static ResultInfo createFail(String fileName,int messageCode,Object[] objs){
    	String message=null;
    	if(objs == null){
    		message = ResourcesUtil.getValue(fileName, messageCode+"");
    	}else{
    		message = ResourcesUtil.getValue(fileName, messageCode+"",objs);
    	}
    	return new ResultInfo(ResultInfo.TYPE_RESULT_FAIL,messageCode,message);
    }
    /**
     * 创建敬告提示结果
     */
    public static ResultInfo createWarning(String fileName,int messageCode,Object[] objs){
    	String message=null;
    	if(objs == null){
    		message = ResourcesUtil.getValue(fileName, messageCode+"");
    	}else{
    		message = ResourcesUtil.getValue(fileName, messageCode+"",objs);
    	}
    	return new ResultInfo(ResultInfo.TYPE_RESULT_WARN,messageCode,message);
    }
    
    /**
     * 创建成功提示结果
     */
    public static ResultInfo createSuccess(String fileName,int messageCode,Object[] objs){
    	
    	String message=null;
    	if(objs == null){
    		message = ResourcesUtil.getValue(fileName, messageCode+"");
    	}else{
    		message = ResourcesUtil.getValue(fileName, messageCode+"",objs);
    	}
    	return new ResultInfo(ResultInfo.TYPE_RESULT_SUCCESS,messageCode,message);
    }
    
    
    
    /**
     * 创建普通信息提示结果
     */
    public static ResultInfo createInfo(String fileName,int messageCode,Object[] objs){
    	
    	String message=null;
    	if(objs == null){
    		message = ResourcesUtil.getValue(fileName, messageCode+"");
    	}else{
    		message = ResourcesUtil.getValue(fileName, messageCode+"",objs);
    	}
    	return new ResultInfo(ResultInfo.TYPE_RESULT_INFO,messageCode,message);
    }

    
	/**
	 * 抛出异常
	 * @param resultInfo
	 * @throws ExceptionResultInfo
	 */
    public static void throwExcepion(ResultInfo resultInfo) throws ExceptionResultInfo{
		throw new ExceptionResultInfo(resultInfo);
	}
	public static void throwExcepion(ResultInfo resultInfo,List<ResultInfo> details) throws ExceptionResultInfo{
		if(resultInfo != null){
			resultInfo.setDetails(details);
		}
		throw new ExceptionResultInfo(resultInfo);
	}
	/**
	 * 创建提交结果信息
	 * @param resultInfo
	 * @return
	 */
	public static SubmitResultInfo createSubmitResult(ResultInfo resultInfo){
		return new SubmitResultInfo(resultInfo);
	}
	/**
	 * 创建提交结果信息，包括明细信息
	 * @param resultInfo
	 * @param details
	 * @return
	 */
	public static SubmitResultInfo createSubmitResult(ResultInfo resultInfo,List<ResultInfo> details){
		if(resultInfo != null){
			resultInfo.setDetails(details);
		}
		return new SubmitResultInfo(resultInfo);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
