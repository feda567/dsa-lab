import java.util.*;

import java.io.*;

class stack{

	private int top;

	private int max;

	private String a[];

	public stack(int m){

		max=m;

		top=-1;

		a=new String[max];

		}

	public void push(String j){

		a[++top]=j;

		}

	public String pop(){

		return a[top--];

		}

	public boolean isempty(){

		if(top==-1)

			return true;

		else

			return false;

			}

	public boolean isfull(){

		if(top==max-1)

			return true;

		else

			return false;

			}

	public String peek(){

		return a[top];

		}

		}

class pretopost{

	public static boolean operator(char c){

		switch(c){

			case '+':

			case '-':

			case '*':

			case '/':

			case '^':

				 return true;

				 }

				 return false;

				 }

	

	public static void main(String st[]){

		String str;

		String p="";

		System.out.println("enter the prefix expression:");

		Scanner ob=new Scanner(System.in);

		str=ob.nextLine();

		int n=str.length();

		stack stck=new stack(n);

		for(int i=n-1;i>=0;i--){

			char ch=str.charAt(i);

			//String p=Character.toString(ch);

			if(Character.isLetterOrDigit(ch)){

				stck.push(ch+ "");

				}

			else if(operator(ch)){

				String x=stck.peek();

					stck.pop();

				String y=stck.peek();

					stck.pop();

				p=x+y+ch;

				stck.push(p);

				}

				

			}

			System.out.println("postfixfix expression:"+stck.peek());

			}

			}
