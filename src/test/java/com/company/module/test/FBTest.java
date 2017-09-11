package com.company.module.test;

import org.testng.annotations.Test;

import com.company.module.TestBase_FB;

public class FBTest extends TestBase_FB{
	
	@Test
	public void testFB(){
		login.loginFn("yourUsername", "yourPasswordHere");
		home.openProfile();
		profile.friendList();
	}

}
