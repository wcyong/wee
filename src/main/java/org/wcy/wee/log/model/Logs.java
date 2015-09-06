package org.wcy.wee.log.model;

import java.util.Date;

/**
 * 日志对象
 * 
 * @author wcyong
 * 
 * @date 2015-09-06
 */
public class Logs {
    /**
     * 唯一标识
     */
    private String id;

    /**
     * 操作人，id:操作工号
     */
    private String operator;

    /**
     * 操作名称，方法
     */
    private String operName;

    /**
     * 操作参数
     */
    private String operParams;

    /**
     * 操作结果，成功，失败
     */
    private String operResult;

    /**
     * 结果消息
     */
    private String resultMsg;

    /**
     * 操作时间
     */
    private Date operTime = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperName() {
		return operName;
	}

	public void setOperName(String operName) {
		this.operName = operName;
	}

	public String getOperParams() {
		return operParams;
	}

	public void setOperParams(String operParams) {
		this.operParams = operParams;
	}

	public String getOperResult() {
		return operResult;
	}

	public void setOperResult(String operResult) {
		this.operResult = operResult;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
    
}