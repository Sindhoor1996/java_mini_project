import java.lang.*;
import java.util.*;
import java.io.*;
class theatre
{
	String name,id;
	double phone;
	static int count=1;
	theatre(Scanner k1)throws FileNotFoundException
	{
		name=k1.next();
		name=name.substring(1);
		id=k1.next();
		phone=k1.nextDouble();
		count++;		
	}
	theatre(int n)throws FileNotFoundException
	{
		Scanner k2=new Scanner(System.in);
		System.out.print("Enter Name: ");		
		name=k2.nextLine();
		System.out.print("Enter ID: ");
		id=k2.next();
		System.out.print("Enter Phone no.: ");
		phone=k2.nextDouble();
		count++;
	}
}
class morning extends theatre
{
	String mname;
	int nmax,nrem;
	morning link;
	public String toString()
	{
	return "morning";
	}
	morning(Scanner k1)throws FileNotFoundException
	{
		super(k1);
		mname=k1.next();
		nmax=k1.nextInt();
		nrem=0;
		link=null;
	}
	morning(int n)throws FileNotFoundException
	{
		super(1);
		Scanner km=new Scanner(System.in);
		System.out.println("Enter movie name\n");
		mname=km.next();
		System.out.println("Enter number of seats\n");
		n=km.nextInt();
		link=null;
	}
	void display(){
	System.out.println(name+""+id+""+phone+""+mname+"morning");
	}
}
class afternoon extends theatre
{
	Scanner ka=new Scanner(System.in);
	String mname;
	int n;
	int nmax;
	int nrem;
	afternoon link;
	public String toString()
	{
	return "afternoon";
	}
	afternoon(Scanner k2)throws FileNotFoundException
	{
		super(k2);
		mname=k2.next();
		nmax=k2.nextInt();
		nrem=0;
		link=null;
	}
	afternoon(int n)throws FileNotFoundException
	{
		super(1);
		Scanner ka=new Scanner(System.in);
		System.out.println("Enter movie name\n");
		mname=ka.next();
		System.out.println("Enter number of seats\n");
		n=ka.nextInt();
		link=null;
	}
	void display(){
	System.out.println(name+""+id+""+phone+""+mname+  "  afternoon");
	}
}
class evening extends theatre
{
	String mname;
	int n;
	int nmax,nrem;
	evening link;
	public String toString()
	{
	return "evening";
	}
	evening(Scanner k3)throws FileNotFoundException
	{
		super(k3);
		mname=k3.next();
		nmax=k3.nextInt();
		nrem=0;
		link=null;
	}
	evening(int n)throws FileNotFoundException
	{
		super(1);
		Scanner ke=new Scanner(System.in);
		System.out.println("Enter movie name\n");
		mname=ke.next();
		System.out.println("Enter number of seats\n");
		n=ke.nextInt();
		link=null;
	}
	void display(){
	System.out.println(name+""+id+""+phone+""+mname+  " evening");
	}


}
class test1
{
	public static void main(String args[])throws Exception,FileNotFoundException
	{
		Scanner k1=new Scanner(new File("ev.txt"));
		k1.useDelimiter(":");
		evening e1=new evening(k1);
		evening emain=e1;
		try{
		while(k1.hasNext())
		{
			e1.link=new evening(k1);
			e1.display();
			e1=e1.link;
		}
		}
		catch(NoSuchElementException e)
		{}
		e1=emain;
		
		Scanner k=new Scanner(new File("mo.txt"));
		k.useDelimiter(":");
		morning m1=new morning(k);
		morning mmain=m1;
		try{
		while(k.hasNext())
		{
			m1.link=new morning(k);
			m1.display();
			m1=m1.link;
		}
		}
		catch(NoSuchElementException e)
		{}
		m1=mmain;
		Scanner k3=new Scanner(new File("af.txt"));
		k3.useDelimiter(":");
		afternoon a1=new afternoon(k3);
		afternoon amain=a1;
		try{
		while(k3.hasNext())
		{
			a1.link=new afternoon(k3);
			a1.display();
			a1=a1.link;
		}
		}
		catch(NoSuchElementException e)
		{}
		a1=amain;
		while(true)
		{
			Scanner kc=new Scanner(System.in);
		  
			System.out.println("\n------------------BOOKING MENU--------------------\n");
			System.out.println("1.Display list of movies and Theatres\n2.Book a ticket\n3.Cancel a ticket\n4.Add theatre details for morning show\n5.Add theatre details for afternoon show time\n6.Add theatre details for afternoon show time\n7.Exit");
			switch(kc.nextInt())
			{
			  case 1:operations.display(m1,a1,e1);
			         break;
			  case 2:operations.searchb(m1,a1,e1);
					 break;
			  case 3:operations.searchc(m1,a1,e1);
			         break;
			  case 4:System.out.println("theatre name, id,price,movie name,no of seats");
			  			String cre1=(kc.next()+":"+kc.nextInt()+":"+kc.nextInt()+":"+kc.next()+":"+kc.nextInt());
			  operations.create("mo.txt",cre1);
			   break;
			   case 5:System.out.println("theatre name, id,price,movie name,no of seats");
			  			String cre2=(kc.next()+":"+kc.nextInt()+":"+kc.nextInt()+":"+kc.next()+":"+kc.nextInt());
			  operations.create("af.txt",cre2);
			   break;
			   case 6:System.out.println("theatre name, id,price,movie name,no of seats");
			  			String cre3=(kc.next()+":"+kc.nextInt()+":"+kc.nextInt()+":"+kc.next()+":"+kc.nextInt());
			  operations.create("ev.txt",cre3);
			   break;
			  default:System.exit(0);
			
			}
		}
	}
}
class operations{
			static void display(morning n1,afternoon n2,evening n3)
			{
				morning mlist=n1;
				afternoon alist=n2;
				evening elist=n3;
				System.out.println("Theatre name\t\tMovie name\t\tShow time\t\tSeat capicity\t\tPrice Per Seat(In Rupees)");
				System.out.println("---------------------------------------------------------------------------------------------------");
				while(mlist!=null)
				{
					System.out.printf("\n%-20s     %-20s    %-20s   %-20s   %-20s\n",mlist.name,mlist.mname,mlist,mlist.nmax,mlist.phone);
					mlist=mlist.link;
				}
				while(alist!=null)
				{
					System.out.printf("\n%-20s     %-20s    %-20s   %-20s   %-20s\n",alist.name,alist.mname,alist,alist.nmax,alist.phone);
					alist=alist.link;
				}
				while(elist!=null)
				{
					System.out.printf("\n%-20s     %-20s    %-20s   %-20s   %-20s\n",elist.name,elist.mname,elist,elist.nmax,elist.phone);
					elist=elist.link;
				}
			}
		static	void create(String te,String text)
	    {
		try{
			File file=new File(te);
			FileWriter fileWriter = new FileWriter(file,true);
		       BufferedWriter bufferFileWriter  = new BufferedWriter(fileWriter);
                fileWriter.append(text);
                bufferFileWriter.close();
                System.out.println("Theatre list added to the list\n");
	 	   }      catch (IOException e) { System.out.println(e);
		 }
		}
			static void searchb(morning m1,afternoon m2,evening m3)throws Exception
			{
				morning mlist=m1;
				afternoon alist=m2;
				evening elist=m3;
				Scanner k4=new Scanner(System.in);
				System.out.println("Enter a Theatre name or movie name\n");
				String nm=k4.next();
				while(mlist!=null)
				{
					if(nm.equalsIgnoreCase(mlist.mname) || nm.equalsIgnoreCase(mlist.name))
					{
						bookm(mlist);
						return;
					}
						mlist=mlist.link;
				}
					while(alist!=null)
				{
					if(nm.equalsIgnoreCase(alist.mname) || nm.equalsIgnoreCase(alist.name))
					{
						booka(alist);
						return;
					}alist=alist.link;
					
				}
					while(elist!=null)
				{
					if(nm.equalsIgnoreCase(elist.mname) || nm.equalsIgnoreCase(elist.name))
					{
						booke(elist);
						return;
					}elist=elist.link;
				}System.out.println("\nRequired movie or theatre doesn't exist..!!.Enter The correct name\n");
			}
			static void bookm(morning m)
			{		morning ptr=m;
					Scanner k5=new Scanner(System.in);
					System.out.println("Enter number of seats you want to book for morning show\nAvailable seats are only "+m.nmax+"\n");
					int st=k5.nextInt();
					if(st>ptr.nmax)
					{
						System.out.println("\n Enter Correct number of seats");
					return;
					}
					if(ptr.nmax-st>=0)
					{
						ptr.nmax=ptr.nmax-st;
						System.out.print("Booking Successfull\nyour booked seats are:");
						for(int i=0;i<st;i++)
						{
							ptr.nrem++;
							System.out.print(m.name+m.nrem+"  ");								
						}
					}System.out.println("\n Total ticket price="+st*ptr.phone +"Rs");
					 
			}

			static void booka(afternoon a)
			{		
					Scanner k6=new Scanner(System.in);
					System.out.println("Enter number of seats you want to book for afternoon show\nAvailable seats are only "+a.nmax+"\n");
					int st=k6.nextInt();
					if(st>a.nmax)
					{
						System.out.println("\n Enter Correct number of seats");
					return;
					}
					if(a.nmax-st>=0)
					{
						a.nmax=a.nmax-st;
						System.out.print("your booked seats are:");
						for(int j=0;j<st;j++)
						{
							a.nrem++;
							System.out.print(a.name+a.nrem+"  ");
															
						}
					}System.out.println("\n Total ticket price="+st*a.phone +"Rs");
					
			}
			static void booke(evening e)
			{		
					Scanner k7=new Scanner(System.in);
					System.out.println("Enter number of seats you want to book for evening show\nAvailable seats are only "+e.nmax+"\n");
					int st=k7.nextInt();
					if(st>e.nmax)
					{
						System.out.println("\n Enter Correct number of seats");
					return;
					}
					if(e.nmax-st>=0)
					{
						e.nmax=e.nmax-st;
						System.out.print("your booked seats are:");
						for(int k=0;k<st;k++)
						{
							e.nrem++;
							System.out.print(e.name+e.nrem+"  ");
															
						}System.out.println("\n Total ticket price="+st*e.phone +"Rs"); 
					}
				
			}
	
			static void searchc(morning m1,afternoon m2,evening m3)
			{
				morning mlist=m1;
				afternoon alist=m2;
				evening elist=m3;
				Scanner k4=new Scanner(System.in);
				System.out.println("Enter a Theatre name or movie name\n");
				String nm=k4.next();
				while(mlist!=null)
				{
					if(nm.equalsIgnoreCase(mlist.mname) || nm.equalsIgnoreCase(mlist.name))
					{
						cancelm(mlist);
						return;
					}
						mlist=mlist.link;
				}
					while(alist!=null)
				{
					if(nm.equalsIgnoreCase(alist.mname) || nm.equalsIgnoreCase(alist.name))
					{
						cancela(alist);
						return;
					}alist=alist.link;
					
				}
					while(elist!=null)
				{
					if(nm.equalsIgnoreCase(elist.mname) || nm.equalsIgnoreCase(elist.name))
					{
						cancele(elist);
						return;
					}elist=elist.link;
				}System.out.println("\nRequired movie or theatre doesn't exist..!!.Enter The correct name\n");
				
			}
		static void cancelm(morning m)
			{		
					Scanner k8=new Scanner(System.in);
					System.out.println("Enter number of seats you want to cancel for morning show\nNumber of seats booked" +m.nrem);
					int st=k8.nextInt();
					if(m.nrem-st>=0)
					{
						m.nmax=m.nmax+st;
						System.out.print("your cancelled seats are:");
						for(int i=0;i<st;i++)
						{
							System.out.print(m.name+m.nrem+"  ");
							m.nrem--;								
						}
					}System.out.println("\n Your money has been returned to your account.");
			}
			

			static void cancela(afternoon a)
			{		
					Scanner k6=new Scanner(System.in);
					System.out.println("Enter number of seats you want to cancel for afternoon show\nNumber of seats booked "+a.nrem);
					int st=k6.nextInt();
					if(a.nrem-st>=0)
					{
						a.nmax=a.nmax+st;
						System.out.print("your cancelled seats are:");
						for(int j=0;j<st;j++)
						{
							System.out.print(a.name+a.nrem+"  ");
							a.nrem--;								
						}
					}
			}
			static void cancele(evening e)
			{		
					Scanner k7=new Scanner(System.in);
					System.out.println("Enter number of seats you want to cancel for evening show\nNumber of seats booked "+e.nrem);
					int st=k7.nextInt();
					if(e.nmax-st>=0)
					{
						e.nmax=e.nmax+st;
						System.out.print("your cancelled seats are:");
						for(int k=0;k<st;k++)
						{
							System.out.print(e.name+e.nrem+"  ");
							e.nrem--;								
						}
					}
			}
			
}	
			
