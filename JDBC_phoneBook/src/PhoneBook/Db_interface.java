package PhoneBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Db_interface extends Application {
	
	 Label lblName , lblNumber ,lblTitle;
	 TextField txtName,txtNumber;
	 Button btnFirst,btnPrev,btnNext,btnLast,btnAdd,btndelete,btnsearch,btnmod,btnall;
	  TextArea tA = new TextArea();
	 private Connection con;
		private Statement st;

	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			launch(args);
	           
	           
		}
	 
	
 
	@Override
	public void start(Stage ps) throws Exception {
		// TODO Auto-generated method stub
		


		lblTitle = new Label("PhoneBook");
		lblTitle.setFont(Font.font("Verdana",20));
		lblTitle.setTextFill(Color.web("Blue"));
		
		lblName = new Label("Name: ");
		lblName.setFont(Font.font("Arial",12));

		lblName.setTextFill(Color.web("Green"));
		
		
		lblNumber = new Label("Number: ");
		lblNumber.setFont(Font.font("Arial",12));

		lblNumber.setTextFill(Color.web("Green"));
		
		txtName = new TextField();
		
		
		txtNumber = new TextField();
		btnmod = new Button("Modify");
		btnFirst = new Button(" << ");
		btnPrev = new Button(" < ");
		btnNext = new Button(" > ");
		btnLast = new Button(" >> ");
		btnAdd = new Button("Add Record");
		btndelete = new Button("Delete Record");
		btnsearch = new Button("Search");
		btnall= new Button("All Contacts");
		
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		FlowPane navPane = new FlowPane();
		navPane.setAlignment(Pos.CENTER);
		FlowPane actPane = new FlowPane();
		actPane.setAlignment(Pos.CENTER);
		
		

		navPane.getChildren().addAll(btnFirst,btnNext,btnPrev,btnLast);
		actPane.getChildren().addAll(btnAdd, btndelete,btnsearch,btnall,btnmod);
		vBox.getChildren().addAll(lblTitle,lblName, txtName, lblNumber, txtNumber,  actPane,tA);
		
		Scene s = new Scene(vBox);
		ps.setScene(s);
		ps.setTitle("Daksh Patel");
		ps.show();
	 
		btnAdd.setOnAction( e -> {
			
			Phone p = getProductData();
			Db_Main db = new Db_Main();  
			 
  		      db.insertProduct(p); // lvl 2 plbm
  		      
  		    if(db.insertProduct(p) == true) {
  		    	txtName.setText("");
  		    	txtNumber.setText("");
  		    	Alert b = new Alert(AlertType.INFORMATION);
  		    	b.setContentText("Added");
  		    	b.showAndWait();
  		    }
  		 
			
			if(db.insertProduct(p) == false){
				Alert a =new Alert(AlertType.ERROR);
				a.setContentText("can not add");
				a.showAndWait();
			}
  		 
		});
		
		btndelete.setOnAction(e->{

			
			Db_Main db = new Db_Main();  
			 
  		      db.deleteProduct(txtName.getText());

  		      if(db.deleteProduct(txtName.getText()) == false) {
  		    	txtName.setText("");
  		    	txtNumber.setText("");
  		    	Alert a =new Alert(AlertType.INFORMATION);
				a.setContentText("Contact Deleted");
				a.showAndWait();
  		      }
  		      
  		      
  		      
  		      if(db.deleteProduct(txtName.getText()) == true) {
  		    	Alert a =new Alert(AlertType.ERROR);
				a.setContentText("Contact Not found");
				a.showAndWait();
  		      }
		});
		
		btnmod.setOnAction(e->{

			Db_Main db = new Db_Main();  
			 
  		      db.deleteProduct(txtName.getText());

  		      if(db.deleteProduct(txtName.getText()) == false) {

  				Phone p = getProductData();
  				 
  				 
  	  		      db.insertProduct(p); // lvl 2 plbm
  	  		      
  	  		    if(db.insertProduct(p) == true) {
  	  		    	txtName.setText("");
  	  		    	txtNumber.setText("");
  	  		    	Alert b = new Alert(AlertType.INFORMATION);
  	  		    	b.setContentText("Added");
  	  		    	b.showAndWait();
  	  		    }
  	  		 
  				
  				if(db.insertProduct(p) == false){
  					Alert a =new Alert(AlertType.ERROR);
  					a.setContentText("can not add");
  					a.showAndWait();
  				}
  		      }
  		      
		});
		btnsearch.setOnAction(e->{
		
			Db_Main dm = new Db_Main();
			String name = txtName.getText();
			ArrayList<Phone> list = dm.searchProduct(name);
  		  displayListofProducts(list);
			
		
		});
		
		btnall.setOnAction(e->{

			Db_Main dm = new Db_Main();
			ArrayList<Phone> all = dm.getAllData();
  		  displayListofProducts(all);
		});
		
		
	}
	
public int getNumber() {
	int num = Integer.parseInt((txtNumber.getText()));
	return num;
}
public String getname() {         /// Null pointer exeception base plbm
	String nam = txtName.getText();
	return nam;
}

public  void displayProduct(Phone p) {
	  String info ="\nId :"+p.getId() +"\nName: "+p.getName()+"\nNumber: "+p.getNumber();
	  tA.appendText(info);
	  
}
public  void displayListofProducts(ArrayList<Phone> all) {
	tA.setText("");
	   
	   for(Phone p : all) {
		   displayProduct(p);
	   }
}
	public  Phone getProductData() {
		   Phone p = null;
		   String name = txtName.getText();
			
			int Number = Integer.parseInt(txtNumber.getText());
			p=new Phone(Number,name);
		   return p;
	   }

	

}




