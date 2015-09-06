package org.wcy.wee.log.mapper;

import org.wcy.wee.log.model.Logs;

public interface LogsMapper {

	/**
	 * 保存日志
	 * @param logs
	 */
    public void  add(Logs logs);
    
}