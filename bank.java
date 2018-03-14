import java.util.*;
import java.util.Scanner;
class AccountHolder
{
	int acc_id;	
	String name;
	String address;
	AccountHolder(int a1,String s,String add)
	{
		acc_id=a1;
		name=s;
		address=add;
		System.out.println("account "+name+" added with id "+acc_id);
	}
	int getId()
	{
		return acc_id;
	}
	String getName()
	{
		return name;
	}
	String getAdd()
	{
		return address;
	}
	
}



class Bank
{
	int acc;
	double ini_bal;
	Bank(int b_id,double bal)
	{
		acc=b_id;
		ini_bal=bal;
		System.out.println("Bank account created with id "+acc+" and initial balance "+ini_bal);
	}
	int getAcc()
	{
		return acc;
	}
	double getBal()
	{
		return ini_bal;
	}
	double credit(double c)
	{
		double a=getBal();
		c=(a+c);
		ini_bal=c;
		return c;
	}
	double debit(double d)
	{
		double a=getBal();
		if(a>d)
		{	d=(a-d);
			ini_bal=d;
			return d;
		}
		else
		{
			System.out.println("Insufficient balance");
			return 0;
		}
	}
	void open_fd(double p,int n)
	{
		System.out.println(p+" is kept as fixed deposit for "+n+" years");
	}
	void close_fd(double p1,int n1,int t1)
	{
		double temp,A,I;
        double r = 0.05;
        temp=(1+r/n1);
        A=p1*Math.pow(temp,(n1*t1));
        I=A-p1;
		if(t1>=(n1/2))
			System.out.println("Your account balance is: "+(p1+Math.round(I)));
		else
			System.out.println("Your account balance is: "+p1);
	}
	void interest(int m)
	{
		double p2=getBal();
		double r2=0.05;
		double A2 = p2*(1 + (r2*m));
		System.out.println("Interest is:"+A2);
	}
}


class BankHolder
{
	int acc_id;
	int acc;
	BankHolder(int a,int b)
	{
		acc_id=a;
		acc=b;
		System.out.println("Account "+acc_id+" has bank account "+acc);
	}
}



class BankDemo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		AccountHolder a[]=new AccountHolder[5];
		for(int j=0;j<5;j++)
		{
			System.out.println("Enter account number");
			int a1=sc.nextInt();
			System.out.println("Enter name");
			String str=sc.next();
			System.out.println("Enter address");
			String add=sc.next();
			a[j]=new AccountHolder(a1,str,add);
		}
		System.out.println("***************");
		
		Bank b[]=new Bank[5];
		for(int j=0;j<5;j++)
		{
			System.out.println("Enter bank id");
			int b1=sc.nextInt();
			System.out.println("Enter initial bal");
			double b2=sc.nextDouble();
			b[j]=new Bank(b1,b2);
		}
		System.out.println("***************");
		
		System.out.println("***************");
		int choice=0;
		for(int j=0;j<5;j++)
		{ if(choice!=8)
			{System.out.println("Enter account id");
			int x=sc.nextInt();
		
		
			if(x==a[j].getId())
			{
				System.out.println("Enter bank id");
				int y=sc.nextInt();
				if(y==b[j].getAcc())
				{
					
					do
					{
						System.out.println("************");
						System.out.println("1.Credit");
						System.out.println("2.Debit");
						System.out.println("3.Open FD");
						System.out.println("4.Close FD");
						System.out.println("5.Calculate Interest");
						System.out.println("6.Close account");
						System.out.println("7.Modify details");
						System.out.println("8.Exit");
						System.out.println("Enter your choice");
						choice=sc.nextInt();
						switch(choice)
						{
							case 1:
							{
								System.out.println("Enter credit amount");
								double cr=sc.nextDouble();
								double cd=b[j].credit(cr);
								System.out.println("Balance="+cd);
							}break;
							case 2:
							{
								System.out.println("Enter debit amount");
								double db=sc.nextDouble();
								
								double dt=b[j].debit(db);
								System.out.println("Balance="+dt);
							}break;
							case 3:
							{
								System.out.println("Enter principal amount");
								double p=sc.nextDouble();
								System.out.println("Enter number of years");
								int n=sc.nextInt();
								
								b[j].open_fd(p,n);
							}break;
							case 4:
							{
								System.out.println("Enter principal amount");
								double p1=sc.nextDouble();
								System.out.println("Enter number of years");
								int n1=sc.nextInt();
								System.out.println("Enter how many years before you have opened fd");
								int t1=sc.nextInt();
								b[j].close_fd(p1,n1,t1);
							}break;
							case 5:
							{
								System.out.println("Calculate interest for how many months");
								int m=sc.nextInt();
								b[j].interest(m);
							}break;
							case 6:
							{
								System.out.println("Your account has been closed");
								System.out.println("THANK YOU");
							}break;
							case 7:
							{
								System.out.println("Enter new account number");
								int MA=sc.nextInt();
								System.out.println("Enter new name");
								String MNAME=sc.next();
								System.out.println("Enter new address");
								String MADD=sc.next();
								a[j]=new AccountHolder(MA,MNAME,MADD
								System.out.println("ACCOUNT MODIFIED");
							}
						}
					}while(choice!=8);
					
				}
				else
				{
					
					System.out.println("Bank id does not exist");
					
				}
			}
			else
			{
				
				System.out.println("Account id doesnot exist");
			}
			}
		}
	}
}