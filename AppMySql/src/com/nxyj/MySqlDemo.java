package com.nxyj;

import java.sql.*;

public class MySqlDemo {
	
	//JDBC�����������ݿ�URL
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/dn2";
	
	static final String USER="root";
	static final String PASS="root";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//MySqlDemo();
		OracleDemo();
	}
	
	private static void OracleDemo()
	{
		Connection conn=null;
		Statement stmt=null;
		try {
			//ע��JDBC����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//������
			System.out.println("�������ݿ⡣����");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.126:1521:orcl","c##mrhao","hjq19890918");
			
			//ִ�в�ѯ
			System.out.println("ʵ����Statement���󡣡���");
			stmt=conn.createStatement();
			String sql="SELECT * FROM AA";
			ResultSet rs=stmt.executeQuery(sql);
			
			//չ����������ݿ�
			while(rs.next())
			{
				int id=rs.getInt("AGE");
				String name=rs.getString("NAME");
				
				
				// �������
                System.out.print("AGE: " + id);
                System.out.print(",NAME: " + name);
                System.out.print("\n");
			}
			
			//��ɺ�ر�����
			rs.close();
			
			
			
		}catch(Exception  e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(stmt!=null)
					stmt.close();
			}catch(Exception  e) {}
		
			try {
				if(conn!=null)
					conn.close();
			}catch(Exception  e) {}
		}
		
		System.out.println("Goodbye!");
		
	}
	
	private static void MySqlDemo()
	{
		Connection conn=null;
		Statement stmt=null;
		try {
			//ע��JDBC����
			Class.forName("com.mysql.jdbc.Driver");
			
			//������
			System.out.println("�������ݿ⡣����");
			conn=DriverManager.getConnection(DB_URL, USER, PASS);
			
			//ִ�в�ѯ
			System.out.println("ʵ����Statement���󡣡���");
			stmt=conn.createStatement();
			String sql="SELECT Id,name,mac_text FROM tb_terminal_info";
			ResultSet rs=stmt.executeQuery(sql);
			
			//չ����������ݿ�
			while(rs.next())
			{
				int id=rs.getInt("Id");
				String name=rs.getString("name");
				String macText=rs.getString("mac_text");
				
				// �������
                System.out.print("ID: " + id);
                System.out.print(",����: " + name);
                System.out.print(",MAC: " + macText);
                System.out.print("\n");
			}
			
			//��ɺ�ر�����
			rs.close();
			
			
			
		}catch(Exception  e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if(stmt!=null)
					stmt.close();
			}catch(Exception  e) {}
		
			try {
				if(conn!=null)
					conn.close();
			}catch(Exception  e) {}
		}
		
		System.out.println("Goodbye!");
		
	}

}
