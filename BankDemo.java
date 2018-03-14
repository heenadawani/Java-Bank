import java.util.*;
class AccountHolder
{
	int acc_id;
	double bal;
	
	AccountHolder(int a,int b)
	{
		acc_id=a;
		bal=b;
		System.out.println("account is created with account number "+ acc_id+" and balance "+bal);
	}
	
}



class Credit
{
	int credit_amount;
	
	Credit(int c)
	{
		credit_amount=c;
		System.out.println("credited amount "+credit_amount);
	}
	
}






class BankDemo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter account num");
		int a=sc.nextInt();
		System.out.println("Enter initial bal");
		int b=sc.nextInt();
		AccountHolder a1=new AccountHolder(a,b);
		System.out.println("Account is added");
		
		System.out.println("Enter credit amount");
		int c=sc.nextInt();
		Credit c1=new Credit(c);
		System.out.println("amount credit ");
	}
}