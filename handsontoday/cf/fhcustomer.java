package handsontoday.cf;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class fhcustomer {
	public static List<Customer> listofcustomers() throws NumberFormatException, IOException,NullPointerException
	{
		
		File f1=new File("F:\\customer.txt");
		FileReader fin=new FileReader(f1);
		try 
		{
		BufferedReader bf=new BufferedReader(fin);
		List<Customer> l1=new ArrayList();
		String data;
		while((data=bf.readLine())!=null) 
		{
			String str[]=data.split(",");
			Customer c=new Customer();
			c.setCustid(Integer.parseInt(str[0]));
			c.setCustname(str[1]);
			c.setEmail(str[2]);
			c.setMobile(str[3]);
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			String date=str[4];
		    Date d = sdf.parse(date);
			c.setDob(d);
			Address a=new Address();
			a.setCity(str[5]);
			a.setState(str[6]);
			a.setCountry(str[7]);
			c.setAddress(a);
			l1.add(c);
		}
			return l1;	
			
				
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
		return null;
				
		
	}
	public static void displayall() throws IOException
	{
		List<Customer> list=listofcustomers();
		for(Customer c1:list) {
			System.out.println(c1);
		}
		
	}
	public static int calculateage(Date dob) throws IOException 
	{
		int age=2020-(dob.getYear()+1900);
		return age;
	}
	public static void displaybyage(int age) throws IOException{
		List<Customer> list=listofcustomers();
		List<Customer> l2=new ArrayList();
		for(Customer cus:list)
		{
			int age1=calculateage(cus.getDob());
			if(age1<age)
			{
				l2.add(cus);
			}
			
		}
		
		for(Customer c:l2) {
			System.out.println(c);
		}
		
	}
	public static void displaybycity(String name) throws IOException {
		List<Customer> list=listofcustomers();
		
		
		for(Customer cus:list)
		{
			if(cus.getAddress().getCity().equalsIgnoreCase(name))
			{
				System.out.println(cus);
		}
			
		}
	}
	public static void main(String args[]) throws IOException {
		while(true) {
		System.out.println("Enter your choice");
		System.out.println("1:Display All Customers \n 2:Display by age \n 3:Display by city \n 4:Exit");
		Scanner sc=new Scanner(System.in);	
		int choice=Integer.parseInt(sc.next());
		switch(choice)
		{
		case 1:
		displayall();
			break;
		case 2:
			System.out.println("Enter age");
			int age=Integer.parseInt(sc.next());
			displaybyage(age);
			break;
		case 3:
			System.out.println("Enter city name");
			String name=sc.next();
			displaybycity(name);
			break;
		case 4:
			System.exit(0);
		}
		
	}
	}

}