import java.util.Scanner;

public class try2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);	
		
			int n1,n2,result,ch=0;	
			while(ch<=6)
{
	System.out.println("\n\nEnter the number for the respective operation\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division\n5.Squareroot\n6.Exit\n\nEnter your choice: ");
 ch = input.nextInt();
	switch(ch) {
	case 1: System.out.print("Enter the first number: ");
			n1= input.nextInt();
			System.out.print("Enter the second number: ");
			n2 = input.nextInt();
			result = n1+n2;
			System.out.print("\n The addition of above two numbers is "+result );
			break;
	case 2: System.out.print("Enter the first number: ");
	n1= input.nextInt();
	System.out.print("Enter the second number: ");
	n2 = input.nextInt();
	result = n1-n2;
	System.out.print("\n The subtraction of above two numbers is "+result  );
	break;
	case 3: System.out.print("Enter the first number: ");
	n1= input.nextInt();
	System.out.print("Enter the second number: ");
	n2 = input.nextInt();
	result = n1*n2;
	System.out.print("\n The multiplication of above two numbers is "+result );
	break;
	case 4: System.out.print("Enter the first number: ");
	n1= input.nextInt();
	System.out.print("Enter the second number: ");
	n2 = input.nextInt();
	result = n1/n2;
	System.out.print("\n The division of above two numbers is "+result );
	break;
	case 5: System.out.print("Enter the number for square root: ");
	n1= input.nextInt();
	
	System.out.print("\n The square root of above two numbers is " + Math.sqrt(n1));
	break;
	case 6: System.out.print("Exited ");
		break;
		default: 	System.out.print("\n Enter the correct choice : ");
break;
	}
}
	}

	
}
