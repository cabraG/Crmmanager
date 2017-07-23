package com.neusoft.dao;

import com.neusoft.domain.Account;

public interface AccountDao {
	
	public Account getAccountByCardname(Account account);
	public void updateAccount (Account account);

}
