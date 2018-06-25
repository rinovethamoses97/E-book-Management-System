package ebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.animation.RotateTransition; 
import javafx.application.Application; 
import javafx.event.EventHandler; 

import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField; 
import javafx.scene.input.KeyEvent; 
import javafx.scene.paint.Color; 
import javafx.scene.paint.PhongMaterial;
 
import javafx.scene.shape.Box; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;  
import javafx.scene.transform.Rotate; 
import javafx.stage.Stage; 
import javafx.util.Duration; 

public class payment {

	
	public void handlePayment(String username,String title,String accno,String pin,int price)
	{
		 
		try
		{
      	 
	       Class.forName("com.mysql.jdbc.Driver");
	     
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
	       
	       
	       
	       PreparedStatement st2=con.prepareStatement("select *from bank where accno=? and pin=?");
	       st2.setString(1, accno);
	       st2.setString(2, pin);
	       ResultSet result=st2.executeQuery();
	       System.out.print("called");
	       if(result.next())
	       {
	    	  if(result.getInt(3)<price)
	    	  {
	    		  Alert al=new Alert(AlertType.INFORMATION);
	    		  al.setContentText("Not enough balace");
	    		  al.show();
	    	  }
	    	  else
	    	  {
	    		  //updating balance
	    		  PreparedStatement st1=con.prepareStatement("update bank set balance=? where accno=?");
	   	          
	   	          st1.setInt(1,result.getInt(3)-price);
	   	       st1.setString(2, accno);
	   	          st1.executeUpdate();
	    		 //inserting into payment db 
	   	       
	   	       	  
	   	       	  
	   	       	PreparedStatement st=con.prepareStatement("insert into payment values(?,?,?,?,?)");
		       System.out.print("called");
		       st.setString(1,accno);
		       st.setString(2,pin);
		       st.setString(3,username);
		       st.setString(4,title);
		       st.setInt(5, price);
		       
		       
		       int result1=st.executeUpdate();
		    	 if(result1==1)
		       {
		    		 Alert al=new Alert(AlertType.INFORMATION);
		    		 al.setContentText("Order for the Book:"+title+"is success");
		    		 al.show();
		       }
		    	 else
		    	 {
		    		 Alert al=new Alert(AlertType.INFORMATION);
		    		 al.setContentText("Failed");
		    		 al.show();
		    	 }

	   	       	   
	   	       	   
	   	       	   
	   	       	   
	   	       	   
	   	       	   
	   	       	   
	    	  }
	    	  
	         
	       
	       }
	       else
	       {
	    	   Alert al=new Alert(AlertType.INFORMATION);
	    		 al.setContentText("Not a valid account");
	    		 al.show();
	       }
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       		}
		catch(Exception e)
		{
			
			
		}

		
	}
	
	
}
