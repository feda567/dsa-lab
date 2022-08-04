import java.util.*;

import java.io.*;

class stack{

	private int top;

	private int max;

	private char a[];

	public stack(int m){

		max=m;

		top=-1;

		a=new char[max];

		}

	public void push(char j){

		a[++top]=j;

		}

	public char pop(){

		 return a[top--];

		 }

	public boolean isempty(){

		return (top==-1);

		}

	public boolean isfull(){

	 	if(top==max-1)

	 		return true;

	 	else

	 		return false;

	 		}

	 public char peek(){

	 	return a[top];

	 	}

	 }

class postfix{

		public static int prio(char ch){

		switch (ch){

			case '+':return 1;

			case '-':

				 return 1;

				 

			case '*':return 2;

			case '/':

			 	 return 2;

			 	  

			case '^':

				 return 3;

				 

			default:return -1;

			}

			}

	//----------postfix conversion-----------------------------------

	public static void main(String st[])throws IOException

	{

	

		String str;

		String pstr="";

		System.out.println("enter the infix string:");

		Scanner sc=new Scanner(System.in);

		str=sc.nextLine();

		int n=str.length();

		stack stck=new stack(n);

		char opThis;

		char opTop;

		

		for(int i=0;i<n;++i)

		{	

			

			

			opThis=str.charAt(i);

			if(Character.isLetterOrDigit(opThis))

				pstr+=opThis;

			if(opThis=='(' )

				stck.push(opThis);

			if(opThis==')'){

				

				while(!stck.isempty()){

					opTop=stck.pop();

					if(opTop=='(')

						break;

						

					else

						pstr=pstr+opTop;

						}

				}

			

		       	

			else if(opThis=='+'||opThis=='-'||opThis=='*'||opThis=='/'||opThis=='^'){

				

				if(stck.isempty())

					stck.push(opThis);

				else{

					

						opTop=stck.peek();

						if(opTop=='(')                 

							stck.push(opThis);

						

						else if(opTop=='+'||opTop=='-'||opTop=='*'||opTop=='/'||opTop=='^')

						{

							if(prio(opTop)<prio(opThis))

								stck.push(opThis);

							if(prio(opTop)>prio(opThis))

								{pstr+=stck.pop();

								if(!stck.isempty()){

								if(prio(stck.peek())==prio(opThis))

								{

									pstr+=stck.pop();

									stck.push(opThis);

								}

								else

								stck.push(opThis);

								}

								else

								stck.push(opThis);

							}

							else if(prio(opTop)==prio(opThis))

							{

								pstr+=stck.pop();

								stck.push(opThis);

							}

						

							}

							}

							

							}

							}

							while(!stck.isempty()){

								pstr+=stck.pop();

								}

								System.out.println("postfix string:"+pstr);

				

	}

	}
