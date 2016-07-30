package org.wcy.wee.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class CreateTableTest {

	
	@Test
	public void testCreateTB() {
		String resource = "activiti.cgf.xml";
		
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource(resource);
		
		ProcessEngine engine = configuration.buildProcessEngine();
		
		System.out.println(engine);
	}
	
}
