import java.util.*;

import java.io.*;

class MyStack

{

	private int max;

	private int TOS=-1;

	private char arr[]=new char[50];

	public MyStack(int size)

	{	

		max=size;

		

	}



	public void push(char item)

	{

		if(TOS<max)

		{

			TOS=TOS+1;

			arr[TOS]=item;

		}

	}

	public char pop()

	{

		char item=arr[TOS];

		TOS=TOS-1;

		return item;

	}

	public int isEmpty()

	{

		if(TOS==-1)

			return 1;

		else 

			return 0;

	}

	public int isFull()

	{

		if(TOS==max)

			return 1;

		else 

			return 0;

	}

	public char peek()

	{

		return arr[TOS];

	}

		

}

public class prefix



{

	public static int pty(char ch)

	{

		switch(ch)

		{	

			case '^':return 3;

			case '*':return 2;

			case '/':return 2;

			case '+':return 1;

			case '-':return 1;

		}

		return 0;



	}

	public static String reverseStr(String s){				////REVERSE

        String rvrs="";

        char ch;

        for(int i=0,j=(s.length()-1);i<s.length();i++,j--){

            ch=s.charAt(j);

            rvrs+=s.charAt(j);

            }

                

        System.out.println(rvrs);

        return rvrs;



    }

	public static void main(String args[])throws IOException

	{

		System.out.print("Enter an infix expression : ");

		Scanner in= new Scanner(System.in);

		String ifix= in.nextLine();

		String pfix="";

		int len=ifix.length();

		MyStack st=new MyStack(len);

		char c;

		char item;

		ifix=reverseStr(ifix);

		for(int i=0;i<len;++i)

		{	

			c=ifix.charAt(i);

			if(Character.isLetterOrDigit(c))			//character or digit write to prefix

			pfix=pfix+c;

			if(c==')')					//if closing parenthesis push to stack

				st.push(c);

			else if(c=='(')

			{

				while(st.isEmpty()==0)

				{

					item=st.pop();

					if(item==')')

						break;

					else

						pfix=pfix+item;

				}

			}

			else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^')

			{

				if(st.isEmpty()==1)

				{

					st.push(c);

				}

				else

				{		item=st.peek();

					        if(item==')')

					        {

					        st.push(c);

					        }

						

						 else if(item=='+'||item=='-'||item=='*'||item=='/'||item=='^')

						{

							if(pty(item)<pty(c))

							{

								st.push(c);



							}							

							

							else if(pty(item)==pty(c))

							{

								st.push(c);

							}

						    else if(pty(item)>pty(c))

							{       pfix+=st.pop();

							        if(st.isEmpty()==0){

							        

								while(pty(st.peek())>pty(c))

								{

								pfix+=st.pop();

								if(st.isEmpty()==1)

								{

								break;}

								}

								st.push(c);

							}

							else

							st.push(c);

							}

							

							}

						}	

					

					

				}

			}

		

		

	while(st.isEmpty()==0)

		{

			pfix=pfix+st.pop();

		}

		System.out.println("Prefix Expression is:"+ reverseStr(pfix));

		

					

	}

}
