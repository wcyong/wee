package org.wcy.weixin.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class WeixinQuartzJob extends QuartzJobBean {
	
	private RefreshAccessTokenTask refreshAccessTokenTask;
	
	public RefreshAccessTokenTask getRefreshAccessTokenTask() {
		return refreshAccessTokenTask;
	}

	
	public void setRefreshAccessTokenTask(RefreshAccessTokenTask refreshAccessTokenTask) {
		this.refreshAccessTokenTask = refreshAccessTokenTask;
	}


	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		refreshAccessTokenTask.refreshToken();
	}

}
