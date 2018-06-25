package ebook;
import javafx.animation.RotateTransition; 
import javafx.application.Application; 
import javafx.event.EventHandler; 

import javafx.scene.Group; 
import javafx.scene.PerspectiveCamera; 
import javafx.scene.Scene; 
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
import javafx.scene.control.Button;
import javafx.animation.PathTransition; 
import javafx.application.Application; 
import static javafx.application.Application.launch; 
import javafx.event.EventHandler; 
import java.lang.Enum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.geometry.Pos;
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.paint.Color; 

import javafx.scene.shape.Circle; 
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path; 
import javafx.stage.Stage; 
import javafx.util.Duration;
//java.lang.Object
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.Region;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;

import java.sql.*;
import javafx.collections.*;
import javafx.scene.control.Control;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.ComboBox;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.lang.Enum;
import javafx.geometry.HPos;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
public class loginui extends Application {
static String username;
static String password;
login log;
    public static void newuser(Stage current)
    {
    	Text title=new Text("SIGN UP");
    	title.setId("title");
    	Label label1=new Label("username:");
    	TextField field1=new TextField();
    	Label label2=new Label("password");
    	PasswordField field2=new PasswordField();
    	Label label3=new Label("Reenter Password");
    	PasswordField field3=new PasswordField();
    	Button signup=new Button("SIGN UP");
    	GridPane root=new GridPane();
    	root.setId("back");
    	root.setVgap(10);
    	root.setAlignment(Pos.TOP_CENTER);
    	root.add(title, 0, 0);
    	root.add(label1, 0, 1);
    	root.add(field1, 0, 2);
    	root.add(label2, 0, 3);
    	root.add(field2, 0, 4);
    	root.add(label3, 0, 5);
    	root.add(field3, 0, 6);
    	root.add(signup, 0, 7);
    	Scene sig=new Scene(root,900,600);
    	sig.getStylesheets().add("style.css");
    	Stage s=new Stage();
    	s.setScene(sig);
    	current.hide();
    	s.show();
    	
    	
    	
    	signup.setOnMouseClicked((new EventHandler<MouseEvent>() {
    		public void handle(MouseEvent event)
    		{
    			username=field1.getText();
    			password=field2.getText();
    			String repass=field3.getText();
    			
    				if((password.equals("") && repass.equals("")) || username.equals(""))
    				{
    					Alert al=new Alert(AlertType.INFORMATION);
        				al.setContentText("Please fill all the fields");
        				al.show();
    				}
    				else if(!password.equals(repass))
    				{
    				Alert al=new Alert(AlertType.INFORMATION);
    				al.setContentText("Password Didn't Match");
    				al.show();
    				}
    				else
    				{
    					login log=new login();
    	    			log.adduser(s,current,username,password);
    	    		   
    				}
    			
    		}
    	}));
    	
    	
    }
	public void start(Stage primaryStage)throws Exception
	{
		
	//login form ui part
		Hyperlink link =new Hyperlink();
		link.setText("New Buyer?");
		Text head=new Text("E_BOOK MANAGEMENT SYSTEM");
		head.setId("head");
        Text text=new Text("Login");
		text.setId("title");
		TextField field=new TextField();//user name field
		field.setPromptText("Enter user name");
		field.setFocusTraversable(false);
		PasswordField field1=new PasswordField();//password field
		field1.setPromptText("Enter password");
		field1.setFocusTraversable(false);
		Button login=new Button();
		login.setText("Login");  
		GridPane root=new GridPane();
		   root.setAlignment(Pos.TOP_CENTER);
		   root.setVgap(10);
		   root.add(head, 0, 0);
		   root.add(text, 0, 1);
		   GridPane.setHalignment(text,HPos.CENTER);
		   root.add(field, 0, 3);
		   root.add(field1, 0, 4);
		   root.add(login, 0, 5);
		   root.add(link, 0, 6);
		   root.setHalignment(link, HPos.CENTER);
		   GridPane.setHalignment(login,HPos.CENTER);
		   root.setId("back");
           Scene scene=new Scene(root,900,600);
           scene.getStylesheets().add("style.css");
           primaryStage.setTitle("E-Book management System");
           primaryStage.setScene(scene);
           primaryStage.setResizable(false);
           primaryStage.show();
          
           link.setOnMouseClicked((new EventHandler<MouseEvent>() { 
  	         public void handle(MouseEvent event) { 
  	        	 newuser(primaryStage);
  	         }
         }));
           
           
           
           login.setOnMouseClicked((new EventHandler<MouseEvent>() { 
    	         public void handle(MouseEvent event) { 
    	        	 log=new login();
    	        	 username=field.getText();
    	     		password=field1.getText();
    	     		
    	        	 log.verify(username, password,primaryStage);
    	         }
           }));
	}
	public static void main(String[] arg)
	{
		launch();
	}
}
