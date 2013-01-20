package com.lejingw.app.myact.web;

import java.io.IOException;

import org.junit.Test;

import com.lejingw.app.myact.util.PropertyFileUtil;

public class TestPropertyFileUtil {
	@Test
	public void test(){
		try {
			System.out.println("-------------web------start");
			PropertyFileUtil.init();
			System.out.println("-------------------end");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
