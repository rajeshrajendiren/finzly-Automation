package com.fxoffice.testng;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

public class Dummy {
	
	
	static int page_num=1;
	//static int initial_num=1;
	//static int num_of_set=5;
	@Test
	public  void m1() {

		
		//for(int i=initial_num;i<=num_of_set;i++) {
		
		int total_num_page=10;
		int i=1;
			while(i<total_num_page) {
			
				System.out.println("=i==>"+i);
				
				String[] userDetails= {
						"flevia1,Password@5",
						"flevia2,Password@5",
						/*"flevia3,Password@5",
						"flevia4,Password@5",
						"flevia5,Password@5"*/
						};
				
				for(String val:userDetails) {
					
					String[] userArr=val.split(",");
					
					
					
					System.out.print("=page==>"+i);
					System.out.print("=userArr==>"+userArr[0]);
					System.out.println("=pass==>"+userArr[1]);
					
					page_num=page_num+1;
					i=page_num;
				}
				
				
		}
		
	}

}
