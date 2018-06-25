package ebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.animation.RotateTransition; 
import javafx.application.Application; 
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
public class book {
    
		int k=0;
	public void add(String title,String author,int price,String publication,String username)
	{
		
		try
		{
      	 
	       Class.forName("com.mysql.jdbc.Driver");
	     
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
	       	     
	       PreparedStatement st=con.prepareStatement("insert into book values(?,?,?,?,?)");
	       st.setString(1,title);
	       st.setString(2,author);
	       st.setInt(3, price);
	       st.setString(4,publication);
	       st.setString(5, username);
	       
	      
	       int result=st.executeUpdate();
	       if(result==1)
	    	{
                       
	       	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   		alert.setTitle("Information Dialog");
	   		alert.setHeaderText("Book");
	   		alert.setContentText("Successfully added");
	    	 alert.show();
	    	}
	       else
	       {

	       	Alert alert = new Alert(Alert.AlertType.INFORMATION);
	   		alert.setTitle("Information Dialog");
	   		alert.setHeaderText("Book");
	   		alert.setContentText("Insertion failed");
	   		alert.show();
	       }
	    
		}
		catch(Exception e)
		{
			
			System.out.print("error");
		}
	}
    public void searchByTitle(Stage s,String ti,GridPane p,String username)
    {
    
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("seaarch book");
		alert.setContentText("Not found");
		
		Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setTitle("Information Dialog");
		alert1.setHeaderText("search Process");
		alert1.setContentText("FOUND!!!!!!");
		
		Text detail=new Text("Deatail of the Book");
		detail.setVisible(false);
		Label label=new Label("Author:");
		label.setVisible(false);
		TextField author=new TextField();
		author.setVisible(false);
		author.setEditable(false);
		Label label1=new Label("Price:");
		label1.setVisible(false);
		
		TextField price=new TextField();
		price.setVisible(false);
		price.setEditable(false);
		
		Label label2=new Label("Publication:");
		label2.setVisible(false);
		
		TextField publication=new TextField();
		publication.setVisible(false);
		publication.setEditable(false);
		
		
		
		Button b=new Button("BUY");
		b.setVisible(false);
		
		b.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event)
			{
				//open payment ui;
				paymentui pay=new paymentui();
				pay.openui(s, username,ti,Integer.parseInt(price.getText()));
			}
		});
		
		
		p.add(detail,0,4);
		p.add(label,0,5);
		p.add(author,0,6);
		p.add(label1,0,7);
		p.add(price,0,8);
		
		p.add(label2, 0, 9);
		p.add(publication, 0, 10);
		p.add(b, 0, 11);
		
		
    	try
			{
	      	 
		       Class.forName("com.mysql.jdbc.Driver");
		     
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
		     
		       PreparedStatement st=con.prepareStatement("select *from book where title=?");
		       st.setString(1,ti);
		       ResultSet result=st.executeQuery();
		    	 if(result.next())
		       {
		    		 	alert1.show();
	  		    		detail.setVisible(true);
	  		    		label.setVisible(true);
	  		    		price.setVisible(true);
	  		    	    label1.setVisible(true);
	  		    		author.setText(result.getString(2));
	  		    		price.setText(result.getString(3));
	  		    		author.setVisible(true);
	  		    		b.setVisible(true);
	  		    		label2.setVisible(true);
	  		    		publication.setText(result.getString(4));
	  		    		publication.setVisible(true);
	  		    		
		    		 
		    		 
		       }
		    	 else
		    	 {
		    		 alert.show();
		    	 }
			}
			catch(Exception e)
			{
				
				
			}
    	
    	
    }
    public void searchByAuthor(Stage s,String author,GridPane p,String username)
    {
       
    	CheckBox[] c=new CheckBox[10] ;
   		TextField[] field=new TextField[10] ;
        
   		int i=4;
   		
        String[] title=new String[10];
    	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("seaarch book");
		alert.setContentText("Not found");
		
		Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setTitle("Information Dialog");
		alert1.setHeaderText("search Process");
		alert1.setContentText("FOUND!!!!!!");
	
		Button b=new Button("buy");
		
		b.setOnMouseClicked(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event)
			{
				for(int j=0;j<k;j++)
	    		 {
	    			 if(c[j].isSelected())
	    			 {
	    				 title[j]=field[j].getText();
	    				 System.out.print(title[j]);
	    			 }
	    		 }
				//open payment ui;
				//paymentui pay=new paymentui();
				//pay.openui(s, username,ti,Integer.parseInt(price.getText()));
			}
		});
		
		
    	try
			{
	      	 
		       Class.forName("com.mysql.jdbc.Driver");
		     
		       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook","root","");
		     
		       PreparedStatement st=con.prepareStatement("select *from book where author=?");
		       st.setString(1,author);
		       ResultSet result=st.executeQuery();
		       if(result.next())
		       {  
		    	   		result.previous();
		    	   		
		    	   		while(result.next())
		    		 	{
		    	   			
		    	   			
		    	   			
		    		 	   c[k]=new CheckBox();
		    		 	   field[k]=new TextField();
		    		 	   field[k].setText(result.getString(1));
		    		 	   TextField f1=new TextField();
		    		 	   f1.setText(result.getString(3));
		    		 	   
		    		 	  TextField f2=new TextField();
		    		 	   f2.setText(result.getString(4));
		    		 	   
		    		 	   
		    		 	   p.add(field[k], 0, i);
		    		 	  p.add(f1, 1, i);
		    		 	 p.add(f2, 2, i);
		    		 	    
		    		 	   
		    		 	   p.add(c[k], 3, i);
		    		 	   i++;
		    		 	   k++;
		    		 	  
		    		 	   
		    		 	}
		    		 p.add(b, 1, i);
		    		 p.setHalignment(b, HPos.CENTER);
		    		 
		    		 
		       }
		    	 else
		    	 {
		    		 alert.show();
		    	 }
			}
			catch(Exception e)
			{
				
				
			}
    	
    	
    }

}
