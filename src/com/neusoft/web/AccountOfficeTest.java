package com.neusoft.web;

import com.neusoft.domain.Account;
import com.neusoft.service.AccountService;
import com.neusoft.service.impl.AccountServiceImpl;

public class AccountOfficeTest {
	
	
	public static void main(String[] args) {
		Account s = new Account();
		Account t =  new Account();
		s.setCartNumber(10001);
		t.setCartNumber(10002);
		AccountService as=new AccountServiceImpl();
		as.officeAccount(s, t, 1000);
	}

}
