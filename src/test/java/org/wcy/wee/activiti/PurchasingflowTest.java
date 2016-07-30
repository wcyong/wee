package org.wcy.wee.activiti;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PurchasingflowTest {
	
	ProcessEngine processEngine = null;
	
	@Before
	public void setUp() {
		//创建ProcessEngine
		//processEngine = ProcessEngines.getDefaultProcessEngine();
		ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cgf.xml");
		processEngine = configuration.buildProcessEngine();
	}

	/**
	 * 部署流程定义
	 */
	@Test
	public void testDeploy() {
		//使用RespositoryService
		RepositoryService repositoryService = processEngine.getRepositoryService();
		
		String resourceName_bpmn = "diagram/purchasingflow01.bpmn";
		String resourceName_png = "diagram/purchasingflow01.png";
		
		InputStream is_bpmn = this.getClass().getClassLoader().getResourceAsStream(resourceName_bpmn);
		InputStream is_png = this.getClass().getClassLoader().getResourceAsStream(resourceName_png);
		
		//部署对象
		Deployment deployment = repositoryService.createDeployment()
						.addInputStream(resourceName_bpmn, is_bpmn)
						.addInputStream(resourceName_png, is_png)
						.deploy();
		
		System.out.println("depId:"+deployment.getId());
		System.out.println(deployment.getDeploymentTime());
	}
	
	/**
	 * 启动一个流程实例
	 */
	@Test
	public void startProcessInstance() {
		RuntimeService runtimeService = processEngine.getRuntimeService();
		
		String key = "purchasingflow";
		
		//根据流程定义的key启动流程，根据key找最高版本的流程定义
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key);
		
		System.out.println("流程实现id:"+processInstance.getId());
		
		System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
		
	}
	
	/**
	 * 查询当前 用户的待办任务
	 */
	@Test
	public void findPersonalTaskList() {
		TaskService taskService = processEngine.getTaskService();
		
		String key = "purchasingflow";
		
		// 任务 负责人
		String assignee = "zhangsan";
		
		//创建查询对象
		TaskQuery taskQuery = taskService.createTaskQuery();
		
		//设置查询条件
		taskQuery.taskAssignee(assignee);
		
		//指定 流程定义key，只查询某个流程的任务
		taskQuery.processDefinitionKey(key);
		
		//获取查询列表
		List<Task> list = taskQuery.list();
		
		for(Task task : list) {
			System.out.println("任务 id：" + task.getId());
			System.out.println("任务负责人：" + task.getAssignee());
			System.out.println("任务名称：" + task.getName());
		}
	}
	
	/**
	 * 办理任务
	 */
	@Test
	public void completeTask() {
		TaskService taskService = processEngine.getTaskService();
		
		String taskId = "2504";
		
		taskService.complete(taskId);
		
		System.out.println("完成任务："+taskId);
	}
}
