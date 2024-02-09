package com.fxoffice.stepDefinitions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Dummy {
	
	
	public static void main(String[] args) {
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	     //   System.out.println(timestamp); 
	        
	        // 2021.03.24.16.34.26
	      SimpleDateFormat sdf1 = new SimpleDateFormat("dd_MM_yyyy_HH.mm.ss");
	      System.out.println(sdf1.format(timestamp));  
	       
	}

}
