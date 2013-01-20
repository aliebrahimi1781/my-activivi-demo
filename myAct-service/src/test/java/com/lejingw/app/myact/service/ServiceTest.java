package com.lejingw.app.myact.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lejingw.app.myact.model.oa.Leave;
import com.lejingw.app.myact.service.activiti.oa.leave.LeaveManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@ActiveProfiles("test")
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
//@Transactional
public class ServiceTest {
	@Autowired
	private LeaveManager leaveManager;
	@Test
	public void testSave() {
		System.out.println("---------------start:");
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
		System.out.println("---------------end:");
	}
	
}
