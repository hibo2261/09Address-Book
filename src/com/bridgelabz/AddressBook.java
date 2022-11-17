package com.bridgelabz;

import java.util.Arrays;
import java.util.Scanner;
public class AddressBook {

    Scanner sc = new Scanner(System.in);
    
    //arrayOfContacts is a array of Contact Class
    
   Contact [] arrayOfContcts = new Contact [50];
   
   int numIndex = 0;


   
   
   
   void options () {
	   boolean varForExit = true;
	   do {
	   System.out.println("------------------PLEASE SELECT A OPTION-------------------------------------");
	   System.out.println("| 1.ADD CONTACT  2.EDIT CONTACT  3.DELETE CONTACT  4.SHOW CONTACTS  5.EXIT  |");
	   System.out.println("-----------------------------------------------------------------------------");
	   int optionForSwitchCase = sc.nextInt();
       switch (optionForSwitchCase)
       {       
           case 1:
		   addContacts();
		   break;
		   
	       case 2:
	    	editContact();
	    	   break;
	    	
	       case 3:
	    	  deleteContact();
	    	  break;
	    	
	       case 4:
	    	   displayContact();
	    	   options();
	    	   break;
	    	   
	       case 5:
	    	   System.out.println("\nBYE...");
	    	   varForExit = false;
	    	   break;
		 
	  }  
    } while (varForExit);
   }	   
    
   void addDataToArray(Contact contactObject)
   {
	   this.arrayOfContcts[numIndex] = contactObject;
	   numIndex++;
   }
   
   void addContacts () 
   {
	   
	   System.out.println("\nPLEASE ENTER YOUR FIRST NAME => ");
	   String firstname  = sc.next();
	   
	   System.out.println("\nPLEASE ENTER YOUR LAST NAME => ");
	   String lastName  = sc.next();
	   
	   System.out.println("\nPLEASE ENTER YOUR ADDRESS => ");
	   String address  = sc.next();
	   
	   System.out.println("\nPLEASE ENTER YOUR CITY NAME => ");
	   String city  = sc.next();
	   
	   System.out.println("\nPLEASE ENTER YOUR STATE NAME => ");
	   String state  = sc.next();
	   
	   System.out.println("\nPLEASE ENTER YOUR ZIPCODE => ");
	   int zipCode  = sc.nextInt();
	   
	   System.out.println("\nPLEASE ENTER YOUR PHONE NUMBER => ");
	   long phoneNumber  = sc.nextLong();
	   
	   System.out.println("\nPLEASE ENTER YOUR EMAIL => ");
	   String emailId  = sc.next();
	   
	   Contact Person = new Contact(firstname,lastName,address,city,state,zipCode,phoneNumber,emailId);
	     
	  addDataToArray(Person);
	   
	   
   }


   
   void editContact() {
		// editing the existing contact using their First Name
		int choice;
		System.out.println("\nENTER THE FIRST NAME OF CONTACT TO EDIT => ");
		String firstName = sc.next();  //variable to store first name of contact we want to edit
		boolean isAvailable = false;
		 for (Contact contact : arrayOfContcts) {
			 if (contact.getFirstName().equalsIgnoreCase(firstName)) { // matching firstName of contact (Ignoring upper/lower case)
				isAvailable = true;
				
				do {
					System.out.println("\nWHAT YOU WANT TO EDIT FOR THE CONTACT => ");
					System.out.println(
							"1.First Name\n2.Last Name\n3.Address\n4.City\n5.State\n6.Zip Code\n7.Phone Number\n8.Email id\n9.Exit\n10.Main Menu");
					choice = sc.nextInt();
					// choose options what you want to edit
					switch (choice) {
					case 1:
						System.out.println("\nENTER THE FIRST NAME => ");
						contact.setFirstName(sc.next());
						break;
					case 2:
						System.out.println("\nENTER THE LAST NAME => ");
						contact.setLastName(sc.next());
						break;
					case 3:
						System.out.println("\nENTER THE ADDRESS => ");
						contact.setAddress(sc.next());
						break;
					case 4:
						System.out.println("\nENTER THE NAME OF THE CITY => ");
						contact.setCity(sc.next());
						break;
					case 5:
						System.out.println("\nENTER THE NAME OF A STATE => ");
						contact.setState(sc.next());
						break;
					case 6:
						System.out.println("\nENTER THE ZIP CODE => ");
						contact.setZipCode(sc.nextInt());
						break;
					case 7:
						System.out.println("\nENTER THE PHONR NUMBER => ");
						contact.setPhoneNumber(sc.nextLong());
						break;
					case 8:
						System.out.println("\nENTER THE EMAIL ID => ");
						contact.setEmailId(sc.next());
						break;
					case 9:
						System.exit(0);
						break;
					case 10:
						options();
						break;
					default:
						break;
					}
					System.out.println("\nUPDATED SUCESSFULLY...");
					//System.out.println(Arrays.toString(arrayOfContcts));
					displayContact();
				} 
				while (choice != 9);
			}
		}
		if (isAvailable == false) {
			System.out.println("\nCONTACT IS NOT AVAILABLE! \nTRY AGAIN");
		}
	}
   
   
    void deleteContact() {
		
		System.out.print("\nENTER FIRST NAME OF CONTACT YOU WANT DELETE => ");
		String firstName = sc.next();		//	variable to store first name of contact we want to delete

		 for (Contact contact : arrayOfContcts) {
		if (contact.getFirstName().equalsIgnoreCase(firstName)) { // matching firstName of contact (Ignoring upper/lower case)
		
			contact.setFirstName(null);
			contact.setLastName(null);
			contact.setAddress(null);
			contact.setCity(null);
			contact.setState(null);
			contact.setZipCode(0);;
			contact.setPhoneNumber(0);
			contact.setEmailId(null);
			
			System.out.println("\nCONTACT DELETED SUCCESSFULLY...");
			//System.out.println(Arrays.toString(arrayOfContcts));
			displayContact();
			options();
			
		} else {
			
			 System.out.println("\nCONTACT NOT FOUND!!!");
		}
		
		  }
    }  
    
    void displayContact() {
    	
    	
        for (Contact contact : arrayOfContcts) {
	    if(contact == null) { }
	    else {
       System.out.println( "\n First Name : " + contact.getFirstName()
		 				  + "\n Last Name  : " + contact.getLastName()
		 				  + "\n Address    : " + contact.getAddress()
		 				  + "\n City Name  : " + contact.getCity()
		 				  + "\n State Name : " + contact.getState()
		 				  + "\n Zip Code   : " + contact.getZipCode()
		 				  + "\n Phone No.  : " + contact.getPhoneNumber()
		 				  + "\n Email Id   : " + contact.getEmailId() );
	         }
    	 }
      }
   
}
