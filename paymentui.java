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

public class paymentui {
String accno;
String pin;
	public void openui(Stage current,String username,String bookTitle,int price)
	{
		Text title=new Text("PAYMENT");
		title.setId("title");
		Label label1=new Label("Account No:");
		TextField field1=new TextField();
		Label label2=new Label("Pin:");
		TextField field2=new TextField();
		Button pay1=new Button("Pay");
		GridPane root=new GridPane();
		root.setAlignment(Pos.TOP_CENTER);
		root.setVgap(10);
		root.add(title, 0, 0);
		GridPane.setHalignment(title,HPos.CENTER);
		root.add(label1, 0, 1);
		root.add(field1, 0, 2);
		root.add(label2, 0, 3);
		root.add(field2, 0, 4);
		root.add(pay1, 0, 5);
		root.setHalignment(pay1, HPos.CENTER);
		root.setId("back");
		Scene s=new Scene(root,900,600);
		s.getStylesheets().add("style.css");
		Stage pay=new Stage();
		pay.setScene(s);
		current.hide();
		pay.show();
		pay1.setOnMouseClicked((new EventHandler<MouseEvent>() { 
	          public void handle(MouseEvent event) {  
	           
	        	accno=field1.getText();
	            pin=field2.getText();
	        	
	            if(accno.equals("")||pin.equals(""))
	            {
	            	Alert al=new Alert(AlertType.INFORMATION);
	            	al.setContentText("please fill all the fields");
	            	al.show();
	            }
	            else if(accno.length()<=11 ||accno.length()>12)
	            {
	            	Alert al1=new Alert(AlertType.INFORMATION);
	            	al1.setContentText("Not a valid accno");
	            	al1.show();
	            }
	            else if(pin.length()<=3 || pin.length()>4)
	            {
	            	Alert al2=new Alert(AlertType.INFORMATION);
	            	al2.setContentText("Not a valid pin");
	            	al2.show();
	            }
	            else
	            {
	            payment pay=new payment();
	        	pay.handlePayment(username,bookTitle, accno, pin,price);
	        	field1.clear();
	        	field2.clear();
	            }
	        	 
	          
	           
	           
	          }
		}));
	          	
	}
	
	
}
