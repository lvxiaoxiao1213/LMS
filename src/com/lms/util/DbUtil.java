package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @Date 2016��9��20��
 *
 */
public class DbUtil {
	
	private static final String jdbcDriver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/lms?Unicode=true&amp;characterEncoding=utf8";
	private static final String uname="root";
	private static final String password="niit";
	
	static {
		try {
			//��������
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������
	 * @return
	 */
	public static  Connection getConn() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, uname, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * �ر�����
	 * @param connection
	 */
	public static void closeConn(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ȡ�������
	 * @param connection
	 * @return
	 */
	public static Statement getStmt(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	/**
	 * �ر�Statement
	 * @param statement
	 */
	public static void closeStmt(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ȡPreparedStatement
	 * @param connection
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPstmt(Connection connection, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	/**
	 * ��ȡPreparedStatement
	 * @param connection
	 * @param sql
	 * @param statement
	 * @return
	 */
	public static PreparedStatement getPstmt(Connection connection, String sql,int statement) {
		PreparedStatement pstmt = null;
		try {
			pstmt = connection.prepareStatement(sql,statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * �ر�PreparedStatement
	 * @param pstmt
	 */
	public static void closePstmt(PreparedStatement pstmt) {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �رս����
	 * @param rs
	 */
	public static void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ѯ��ʱ��ر�
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void closeConnStatRs(Connection connection, Statement statement, ResultSet resultSet) {
		closeRs(resultSet);
		closeStmt(statement);
		closeConn(connection);
	}

	/**
	 * ��ѯ��ʱ��ر�
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void closeConnPstatRs(Connection connection, PreparedStatement pstmt, ResultSet resultSet) {
		closeRs(resultSet);
		closePstmt(pstmt);
		closeConn(connection);
	}
}
