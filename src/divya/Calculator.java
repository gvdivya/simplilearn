package divya;

import java.util.*;

public class Calculator 
{
	void Addition(int a, int b)
	{
		
		System.out.println("Sum is:"+(a+b));
	}
	
	void Subtraction(int a, int b)
	{
		
		System.out.println("Subtraction is:"+(a-b));
	}
	
	void Multiplication(int a, int b)
	{
		
		System.out.println("Multiplication is:"+(a*b));
	}
	void division(int a, int b)
	{
		
		System.out.println("division is:"+(a/b));
	}

	public static void main(String[] args)
	{
		Calculator c = new Calculator() ;
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Please enter a value:");
		int a= sc.nextInt();
		System.out.println("Please enter a value:");
		int b= sc.nextInt();
		
		
		c.Addition(a,b);
		c.Subtraction(a,b);
		c.Multiplication(a,b);
		c.division(a,b);
		

	}

}
