package com.neusoft.util;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {

	private static ComboPooledDataSource source = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return source;
	}

	public static Connection getConnection() {
		try {
			return source.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private C3P0Utils() {

	}
}
