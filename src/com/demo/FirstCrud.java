package com.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FirstCrud {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/googlie?autoReconnect=true&useSSL=false","root","root");
			
			while(true) {
				System.out.println("Enter Your Choice \n1.INSERT \n2.UPDATE \n3.DELETE \n4.EXIT");
				int ch = Integer.parseInt(br.readLine());
				if(ch==1) {
					
					PreparedStatement ps = con.prepareStatement("insert into student (iid,name,salary) values(?,?,?)");
					System.out.println("Enter the id ");
					int num = Integer.parseInt(br.readLine());
					System.out.println("Enter the Name ");
					String name = br.readLine();
					System.out.println("Enter the Salary ");
					double salary = Double.parseDouble(br.readLine());
					
					ps.setInt(1, num);
					ps.setString(2, name);
					ps.setDouble(3, salary);
					
					
					int res =ps.executeUpdate();
					ps.close();
					if(res==1) {
						System.out.println("Data Inserted");
					}
					else {
						System.out.println("Not Inserted");
					}
					
				}
				else if(ch==2) {
					while(true) {
						System.out.println("Enter Your Choice \n1.UPDATE NAME \n2.UPDATE SALARY \n3.EXIT");
						int chh = Integer.parseInt(br.readLine());
						if(chh==1) {
							PreparedStatement ps = con.prepareStatement("update student set name = ? where iid = ?");
							System.out.println("Enter Name You Want To Update");
							String uname = br.readLine();
							System.out.println("ENter The ID Where You Want To Update ");
							int uid = Integer.parseInt(br.readLine());
							ps.setString(1, uname);
							ps.setInt(2, uid);
							
							int ures = ps.executeUpdate();
							
							if(ures==1) {
								System.out.println("Updated Successfully");
							}
							else {
								System.out.println("Not Updated Successfully");
							}
							
							ps.close();
							
							
						}
						else if(ch==2) {
							PreparedStatement ps = con.prepareStatement("update student set salary = ? where iid = ?");
							System.out.println("Enter Salary You Want To Update");
							double usalary = Double.parseDouble(br.readLine());
							System.out.println("Enter The ID Where You Want To Update ");
							int uid = Integer.parseInt(br.readLine());
							ps.setDouble(1, usalary);
							ps.setInt(2, uid);
							
							int ures = ps.executeUpdate();
							
							if(ures==1) {
								System.out.println("Updated Successfully");
							}
							else {
								System.out.println("Not Updated Successfully");
							}
							
							ps.close();
							
						
						}
						else if (ch==3) {
							break;
						}
						else {
							break;
						}
					}	
				}
				else if(ch==3) {
					System.out.println("Enter Choice \n1.Delete Particular Row \n2.Delete All Rows \n3.EXIT");
					int chhd = Integer.parseInt(br.readLine());
					if(chhd==1) {
						PreparedStatement ps = con.prepareStatement("delete from student where iid =?");
						System.out.println("Enter the id you want to delete");
						int did = Integer.parseInt(br.readLine());
						ps.setInt(1, did);
						int resd = ps.executeUpdate();
						if(resd==1) {
							System.out.println("Deleted ");
						}
						else {
							System.out.println("Not Deleted");
						}
						
					}
					else if(chhd==2) {
						PreparedStatement ps = con.prepareStatement("truncate table student");
						int resddd = ps.executeUpdate();
						if(resddd==1) {
							System.out.println("table deleted");
						}
						else {
							System.out.println("Not Deleted");
						}	
					}
					else if(chhd==3){
						break;
					}
					else {
						break;
					}	
				}
				else if(ch==4) {
					break;
				}
				else {
					break;
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
