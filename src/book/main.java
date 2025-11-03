package book;
import java.util.Scanner;

public class main {
 public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
		System.out.println("**Welcome to Manapparai Library**");		
		try {
		 DBCode db=new DBCode();
         System.out.println("1.New User\n 2.Login\n");
         
         int ch=sc.nextInt();
         sc.nextLine();
         if(ch==1){
        	 System.out.println("Customer Name:");
        	 String cu=sc.nextLine();
        	 System.out.println("User Name:");
        	 String un=sc.nextLine();
        	 System.out.println("Password:");
        	 String pass=sc.nextLine();
        	 int res=db.register(cu, un, pass);
        	 System.out.println(res>=1?"Registered":"Not Registered");
        	 System.out.println("------------------------");
         }
         else if(ch==2){
        	 System.out.println("User Name:");
        	 String un=sc.nextLine();
        	 System.out.println("Password:");
        	 String pass=sc.nextLine();
        	 boolean res=db.login(un, pass);
        	 if(res==true) {
        	    	while(true) {
        	    		System.out.println("---------------------");
        	    		System.out.println("Library Books\n 1.Add Book\n 2.View Book List\n 3.Update Book\n 4.Remove BookList");
        	            int c=sc.nextInt();
        	            sc.nextLine();
        	            if(c==1) {
        	            	 System.out.println("Enter the Book Title:");
        	                 String bt=sc.next();
        	                 sc.nextLine();
        	                 System.out.println("Customer name:");
        	                 String cs=sc.nextLine();
        	                 System.out.println("Author Name:");
        	                 String an=sc.next();
        	                 
        	                 System.out.println("Call Number:");
        	                 long cl=sc.nextLong();
        	                 System.out.println("PublishDate:");
        	                 String s=sc.next();
        	                 System.out.println("publisher:");
        	                 String sh=sc.next();
        	                 System.out.println("ISBN Number:");
        	                 String n1=sc.next();
//        	                 System.out.println("User Name:");
//        	                 String n2=sc.nextLine();
//        	                 System.out.println("Password:");
//        	                 String ps=sc.nextLine();
//        	                 System.out.println("Customer Id:");
//        	                 long ck=sc.nextLong();
        	                 int r=db.Add(bt,cs, an, cl, s, sh, n1);
        	                 System.out.println(r!=0?"Saved":"Failed");
        	            }
        	            else if(c==2) {
        	            	 System.out.println("1.List\n 2.Details\n");
        	            	 int ce=sc.nextInt();
        	            	 if(ce==1) {
        	            		 db.view();
        	            	 }
        	            	 else if(ce==2) {
        	            		 System.out.println("Enter Book Title:");
        	            		 String T=sc.next();
        	            		 db.view(T);
        	            	 }
        	            	 else {
        	            		 System.out.println("Invalid Choice");
        	            	 }
        	            }
        	            else if(c==3) {
        	             System.out.println("Enter Book Title:");
        	           	 String T=sc.next();
        	           	 System.out.println("author:");
        	           	 String A=sc.next();
        	           	 int r=db.update(T,A);
        	           	 System.out.println(r!=0 ? "Modified":"Failed");
        	            }
        	            else if(c==4) {
        	            	 System.out.println("Enter Book Title:");
        	            	 String T=sc.next();
        	            	 int r=db.delete(T);
        	                 System.out.println(r!=0 ?"Removed":"Failed");
        	            	
        	            }
        	            else {
        	           	 System.out.println("Invalid no Choice");
        	            }
        	            System.out.println();
        	            
        	            System.out.println();
                   }
        	   }
          }
		}
        	 
       
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Executed Successfully");
			sc.close();
		}
		
	}

}
