package com.neusoft.service.impl;

import com.neusoft.dao.AccountDao;
import com.neusoft.dao.impl.AccountDapImpl;
import com.neusoft.domain.Account;
import com.neusoft.service.AccountService;

public class AccountServiceImpl implements AccountService {
	AccountDao acd=new AccountDapImpl();

	@Override
	public void officeAccount(Account source, Account target, double monney) {
		Account s=	acd.getAccountByCardname(source);
		Account t=  acd.getAccountByCardname(target);
		s.setMoney(s.getMoney()-monney);
		t.setMoney(t.getMoney()+monney);
		acd.updateAccount(s);
		acd.updateAccount(t);
	}

}
