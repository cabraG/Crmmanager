package com.neusoft.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.neusoft.dao.AccountDao;
import com.neusoft.domain.Account;
import com.neusoft.util.C3P0Utils;

public class AccountDapImpl implements AccountDao {

	@Override
	public Account getAccountByCardname(Account account) {
		String sql="select * from Account where cartNumber=?";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
	
		try {
			return runner.query(sql, new BeanHandler<Account>(Account.class),account.getCartNumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateAccount(Account account) {
		String sql="update Account set money=? where cartNumber=? ";
		QueryRunner runner = new QueryRunner(C3P0Utils.getDataSource());
		try {
			runner.update(sql,account.getMoney(),account.getCartNumber());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
