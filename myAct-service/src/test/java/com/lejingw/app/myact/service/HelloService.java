package com.lejingw.app.myact.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.lejingw.app.myact.model.oa.Leave;
import com.lejingw.app.myact.service.activiti.oa.leave.LeaveManager;


@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("test")
public class HelloService extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private LeaveManager leaveManager ;
	@Test
	public void testSave() {
		System.out.println("---------start");
		Leave leave = new Leave();
		leave.setApplyTime(new Date());
		leave.setStartTime(new jodd.datetime.JDateTime("2012-05-22").convertToSqlDate());
		leave.setEndTime(new jodd.datetime.JDateTime("2012-05-23").convertToSqlDate());
//		Date startTime = new Date(112, 5, 22);
//		Date endTime = new Date(112, 5, 34);
//		leave.setStartTime(startTime);
//		leave.setEndTime(endTime);
		leave.setLeaveType("公休");
		leave.setUserId("kafeitu");
		leave.setReason("no reason");
		leaveManager.saveLeave(leave);
		
		assertNotNull(leave.getId());
		
		Leave newLeave = leaveManager.getLeave(leave.getId());
		assertNotNull(newLeave);
		System.out.println("---------end");
	}
	
}
