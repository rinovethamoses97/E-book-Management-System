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
public class login {
bookui book;
    public void adduser(Stage current,Stage previous,String username,String password)
    {
       
    	try
		{
      	 
	       Class.forName("com.mysql.jdbc.Driver");
	     
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
	       	     
	       PreparedStatement st=con.prepareStatement("select *from login where username=?");
	       st.setString(1, username);
	       ResultSet result=st.executeQuery();
	       if(result.next())
	       {
	    	   Alert al=new Alert(AlertType.INFORMATION);
	    	   al.setContentText("User Name Exist");
	    	   al.show();
	       }
	       else
	       {
	       
	       
	       
	       
	       
	       
	       
	       PreparedStatement st1=con.prepareStatement("insert into login values(?,?,'buyer')");
	       st1.setString(1,username);
	       st1.setString(2,password);
	       
	      
	       int result1=st1.executeUpdate();
	       if(result1==1)
	    	{
                       
	       	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   		alert.setTitle("Information Dialog");
	   		alert.setContentText("Successfully Added As a Buyer");
	    	 alert.showAndWait();
	    	 current.hide();
	    	 previous.show();
	    	 
	    	}
	       else
	       {

	       	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   		alert.setTitle("Information Dialog");
	   		alert.setContentText("Sign Up Failed");
	   		alert.show();
	       }
	       }
	    
		}
		catch(Exception e)
		{
			
			System.out.print("error");
		}
    }
	public void verify(String username,String password,Stage s)
	{
		try
		{
 		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
		       PreparedStatement st=con.prepareStatement("select *from login where username=? and password=?");
		       st.setString(1,username);
		       st.setString(2, password);
		       ResultSet result=st.executeQuery();
		    	 if(result.next()){
		    	
		    		if(result.getString(3).equals("buyer"))
		    		{
		    		 book=new bookui();
		    		 book.openui(s,username);
		    		}
		    		else if(result.getString(3).equals("seller"))
		    		{
		    		 book=new bookui();
		    		 book.opensellerui(s,username);
		    		}
		    		
		       }
		    	 else {
		    		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
		    			alert.setTitle("Information Dialog");
		    			alert.setHeaderText("Login process");
		    			alert.setContentText("failed");
		    			alert.show();
		    	 }
			
		}
		catch(Exception e)
		{
			System.out.print("error");
		}
	}
	
}
