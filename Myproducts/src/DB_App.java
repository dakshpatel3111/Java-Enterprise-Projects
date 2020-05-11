import java.util.ArrayList;
import java.util.Scanner;

public class DB_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int choice=0;
          DB_Access db = new DB_Access();
          Scanner s = new Scanner(System.in);
          
          while(choice != 9) {
        	  choice = displayMenu();
        	  switch(choice) {
        	  case 1:
        		  //get all products and display them
        		  ArrayList<Myproducts1> all = db.getAllData();
        		  displayListofProducts(all);
        		  break;
        	  case 2:
        		  //Search and display
        		  System.out.println("Enter value for search: ");
        		  String val = s.nextLine();
        		  ArrayList<Myproducts1> found = db.searchProduct(val);
        		  displayListofProducts(found);
        		  break;
        	  case 3:
        		  //add
        		  Myproducts1 p = getProductData();
        		  db.insertProduct(p);
        		 
        		  break;
        	  case 4:
        		  //modify
        		  break;
        	  case 5:
        		  //delete
        		 
        		 System.out.println("Enter Id of the Product : ");
        		  int id = s.nextInt();
        		 if( db.deleteProduct(id)) {
        			 System.out.println("product has been succesfully deleted");
        			 
        		 }
        		 else {
        			 System.out.println("product is not removed , try entering right id");
        			 
        		 }
        		  break;
        	  case 9 :
        		  System.exit(0);
        		  break;
        	  }
          }
	}
    public static int displayMenu() {
    	System.out.print("Menu:\n"+
                         "1.Get all data\n"+
    			          "2.Search for Product\n"+
                           "3.Add a product\n"+
    			           "4.Modify a product\n"+
                           "5.Delete a Procut\n"+
    			           "9.Exit\n");
    	Scanner s = new Scanner(System.in);
    	int choice;
    	do {
    	System.out.println("Enter your choice");
    	 choice = s.nextInt();
    	}while(!(choice >=1 && choice <=5 || choice == 9));
    	return choice;	
    }
   public static Myproducts1 getProductData() {
	   Myproducts1 p = null;
	   Scanner s = new Scanner(System.in);
	   System.out.println("Enter a product name: ");
	   String name = s.nextLine();
	   System.out.println("Enter Product description: ");
	   String desc = s.nextLine();
	   System.out.println("Enter product quantity: ");
	   int qty = s.nextInt();
	   System.out.println("Enter a product price: ");
	   double price = s.nextDouble();	   
	   p=new Myproducts1(-1,name,desc,qty,price);
	   return p;
   }
   public static void displayProduct(Myproducts1 p) {
	   System.out.printf("%7d%11s%20s%7d%11.2f\n", p.getId(),p.getName(),p.getDescription(),p.getQuantity(),p.getPrice());
   }
   public static void displayListofProducts(ArrayList<Myproducts1> list) {
	   System.out.printf("%7s%11s%20s%7s%11s\n", "ID","Name","Description","Quantity","Price");
   
	   for(Myproducts1 p : list) {
		   displayProduct(p);
	   }
   }


}




 