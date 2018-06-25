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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField; 
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color; 
import javafx.scene.paint.PhongMaterial;
 
import javafx.scene.shape.Box; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;  
import javafx.scene.transform.Rotate; 
import javafx.stage.Stage; 
import javafx.util.Duration; 
import javafx.collections.ObservableList;
import javafx.scene.Node;
public class bookui {
String title;
String author;
int price;
String publication;
book boo;
    public void opensellerui(Stage primary,String username)
    {
    	//ui to add books
    	Text title2=new Text("Add Books");
    	title2.setId("title");
    	title2.setFont(new Font(45));
    	Label label1=new Label("Title:");
    	TextField title1=new TextField();
    	
    	
    	
    	
    	Label label2=new Label("Author:");
    	TextField author1=new TextField();
    	Label label3=new Label("Price:");
    	TextField price1=new TextField();
    	Label label4=new Label("Publication:");
    	TextField publication1=new TextField();
    	Button add=new Button("ADD");
    	GridPane sell=new GridPane();
    	sell.setAlignment(Pos.TOP_CENTER);
		sell.setVgap(10);
    	sell.setId("back");
    	sell.add(title2, 0, 0);
    	sell.add(label1, 0, 1);
    	sell.add(title1, 0, 2);
    	sell.add(label2, 0, 3);
    	sell.add(author1, 0, 4);
    	sell.add(label3, 0, 5);
    	sell.add(price1, 0, 6);
    	sell.add(label4, 0, 7);
    	sell.add(publication1, 0, 8);
    	sell.add(add, 0, 9);
    	GridPane.setHalignment(add,HPos.CENTER);
    	Scene seller=new Scene(sell,900,600);
    	seller.getStylesheets().add("style.css");
    	Stage selui=new Stage();
    	selui.setScene(seller);
    	primary.hide();
    	selui.show();
    	add.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	          public void handle(MouseEvent event) {  
	          
	              
	              title=title1.getText();
	        	  author=author1.getText();
	        	  publication=publication1.getText();
	        	  if(title.equals("")||author.equals("")||publication.equals("")||price1.getText().equals(""))
	        	  {
	        		  Alert alert = new Alert(Alert.AlertType.INFORMATION);
	      	   		 alert.setTitle("Information Dialog");
	      	   		 alert.setHeaderText("Add Book");
	      	   		 alert.setContentText("Please enter all the details");
	      	    	 alert.show();  
	        	  }
	        	  else
	        	  {
	        		  price=Integer.parseInt(price1.getText());
	        		  boo=new book();
	        		  boo.add(title, author, price, publication,username);
	        		  title1.clear();
	        		  author1.clear();
	        		  publication1.clear();
	        		  price1.clear();
	        	  }
	         }
	         
	         }));
    	
    	
    	
    	
    	
    	
    }
    public void openui(Stage primary,String username)
    {
    	Text t=new Text("Welcome "+username);
		t.setFont(new Font(48));
		t.setId("title");
		Text t1=new Text("Search Book");
		t1.setFont(new Font(20));
    	Button b1=new Button("Search by title");
    	Button b2=new Button("Search by Author");
    	GridPane root1=new GridPane();
		root1.setId("back");
		root1.setVgap(10);
		root1.setAlignment(Pos.TOP_CENTER);
		root1.setHalignment(b1, HPos.CENTER);
		root1.setHalignment(t1, HPos.CENTER);
		root1.add(t,0, 0);
		root1.add(t1, 0, 1);
		root1.add(b1,0, 2);
		
		
		//root1.add(b2, 1, 2);//adding search by author button
		
		
		Scene s=new Scene(root1,900,600);
		s.getStylesheets().add("style.css");
		Stage st=new Stage();
		st.setScene(s);
		primary.hide();
		st.show();
		b1.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e)
			{
				openuititle(st,username);
			}
		}));
		b2.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e)
			{
				openuiauthor(st,username);
			}
		}));
		
    }
	public void openuititle(Stage primary,String username)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("seaarch book");
		alert.setContentText("Not found");
		Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setTitle("Information Dialog");
		alert1.setHeaderText("search Process");
		alert1.setContentText("FOUND!!!!!!");
		Text t=new Text("Welcome "+username);
		t.setFont(new Font(45));
		t.setId("title");
		Text t1=new Text("search book by title");
		t1.setFont(new Font(20));
		TextField field=new TextField();//search field
		Button b=new Button("search by title");//search button(title)
		
		
		Button logout=new Button("logout");//logout button
		logout.setVisible(false);
		GridPane root1=new GridPane();
		root1.setId("back");
		root1.setVgap(10);
		root1.setAlignment(Pos.TOP_CENTER);
		//root1.add(t,0, 0);
		root1.add(t1, 0, 1);
		root1.add(field, 0, 2);
		root1.add(b,0, 3);
	    root1.add(logout, 0, 12);
		Scene rino=new Scene(root1,900,600);
		Stage s=new Stage();
		rino.getStylesheets().add("style.css");
		s.setTitle("E-Book management system");
        s.setScene(rino);
        primary.close();
        s.show();
        b.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	          public void handle(MouseEvent event) { 
	          title=field.getText();	 
	          book boo=new book();
	          boo.searchByTitle(s,title,root1,username);
	         }
	         
	         }));
  
        logout.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	             //logout operations
	        	 s.hide();
	        	 primary.show();
	         }  })); 
     
	}
	public void openuiauthor(Stage primary,String username)
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("search book");
		alert.setContentText("Not found");
		Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
		alert1.setTitle("Information Dialog");
		alert1.setHeaderText("search Process");
		alert1.setContentText("FOUND!!!!!!");
		Text t=new Text("Welcome "+username);
		t.setFont(new Font(45));
		t.setId("title");
		Text t1=new Text("search book by Author");
		t1.setFont(new Font(20));
		TextField field=new TextField();//search field
		Button b=new Button("search by Author");//search button(author)
		
		
		Button logout=new Button("logout");//logout button
		logout.setVisible(false);
		GridPane root1=new GridPane();
		root1.setId("back");
		root1.setVgap(10);
		root1.setAlignment(Pos.TOP_CENTER);
		//root1.add(t,0, 0);
		root1.add(t1, 0, 1);
		root1.add(field, 0, 2);
		root1.add(b,0, 3);
	    //root1.add(logout, 0, 12);
		Scene rino=new Scene(root1,900,600);
		Stage s=new Stage();
		rino.getStylesheets().add("style.css");
		s.setTitle("E-Book management system");
        s.setScene(rino);
        primary.close();
        s.show();
        b.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	          public void handle(MouseEvent event) { 
	          author=field.getText();	 
	          book boo=new book();
	          boo.searchByAuthor(s,author,root1,username);
	         }
	         
	         }));
  
        logout.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	         public void handle(MouseEvent event) { 
	             //logout operations
	        	 s.hide();
	        	 primary.show();
	         }  })); 
     
	}

}
