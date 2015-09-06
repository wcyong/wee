package org.wcy.wee.log.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wcy.wee.log.mapper.LogsMapper;
import org.wcy.wee.log.model.Logs;
import org.wcy.wee.log.service.LogsService;

@Service
public class LogsServiceImpl implements LogsService {
	
	@Autowired
	private LogsMapper logsMapper;

	@Override
	public void add(Logs logs) {
		logsMapper.add(logs);
	}

}
