package projectCRUD;

import java.sql.*;
import java.util.Scanner;

public class TinyProject {
	                         //***********************INSERT OPERATION**********************
	public void create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","jai1211r");
			String insert=("insert into st_details values(7,'rajeswari','CSE',76543218,'2000-09-19')");
			PreparedStatement st1= con.prepareStatement(insert);
			boolean check =st1.execute();
			if (check==false) {
				System.out.println("inserted succesfully");
			}
			else {
				System.out.println("data not inserted ,please enter the correct data");
			}
			
			con.close();
			
			
			}  
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		}
	//******************update operation****************
	public void update() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","jai1211r");
			String update=("update st_details set s_name='Raji' where s_name = 'rajeswari'  ");
			PreparedStatement st2= con.prepareStatement(update);
			
		boolean check=	st2.execute();
		if (check==false) {
		System.out.println("updated successfully");
			
		}
			con.close();
			
			
			}  
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		}
		
	                                
	                         //****************READ operation***************
	
	
	public void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","jai1211r");
			Statement st3=con.createStatement();
			ResultSet rs=st3.executeQuery("select* from st_details");
			while (rs.next())
			{
				System.out.println(rs.getString(1)+" \t"+ rs.getString(2)+" \t"+rs.getString(3)+" \t"+rs.getString(4) );
			}
			con.close();
			System.out.println("datas from you entered database");
			}  
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
	          // ***********************DELETE OPERATION*******************
	public void delete() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","jai1211r");
			String delete=("delete from st_details where s_id=7  limit 1");
			PreparedStatement st4= con.prepareStatement(delete);
			
			
		boolean check=st4.execute();
		if (check==false) {
			System.out.println("deleted successfully");
		}
			con.close();
			
			
			}  
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		}
		
		
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ALL THE OPERTAIONS ARE STATIC ONLY \"THAT MEANS PRESET QUERRYS\"");
		   System.out.println("enter the number \n 1=insert\n 2=update\n 3=read\n 4=delete\n ");
		   
		   int num;
	       try (Scanner sc = new Scanner(System.in)) {
			num=sc.nextInt();
			}
	       TinyProject tiny=new TinyProject(); 
		  
	     switch (num){
	    	 
	      case 1 : {
		    tiny.create();
	       }
	       break;  
			case 2:{
		    tiny.update();
		    break;
			}
			case 3:{
			    tiny.read();
			    break;
			    
				}
			case 4:{
			    tiny.delete();
			    break;

			}
		default:
			System.out.println("wrong number enterd it must be 1 to 4");
		}
	
		
	}
}
