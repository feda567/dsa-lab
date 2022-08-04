import java.util.*;

import java.io.*;

class Link{

    public int data;

    public Link next;

    public Link prev;

    public Link(int d){

        data=d;

    }

}

class DLL{

    public Link front;

    public Link rear;

    public DLL(){

        front=rear=null;

    }

    

    

}

 class dequel {

    public static void insertfirst(int j,DLL a){

        Link nl=new Link(j);

        if(a.front==null){

                a.front=nl;

                a.rear=nl;

        }

        else{

            nl.next=a.front;

            a.front.prev=nl;

            a.front=nl;

        }

        

    }

    public static void insertlast(int j,DLL a){

        Link nl=new Link(j);

        if(a.rear==null){

            a.front=nl;

            a.rear=nl;

    }

    else{

        

        nl.prev=a.rear;

        a.rear.next=nl;

        a.rear=nl;

    }

    

    }

    public static void deletefirst(DLL a){

        if(a.front==null){

                System.out.println("queue is empty");

        }

        else if(a.front==a.rear){

            a.front=a.rear=null;

            System.out.println("queue is empty");

        }

        else{

            a.front=a.front.next;

            a.front.prev=null;

            display(a);

        }

        

    }

    public static void deletelast(DLL a){

        if(a.rear==null){

                System.out.println("queue is empty");

        }

        else if(a.front==a.rear){

            a.front=a.rear=null;

            System.out.println("queue is empty");

        }

        else{

            a.rear=a.rear.prev;

            a.rear.next=null;

            display(a);

        }

       

    }

    public  static void display(DLL a){

        Link current=a.front;

        while(current!=null){

            if(current.next==null)

                System.out.println(current.data);

            else

                System.out.print(current.data+"-->");

            current=current.next;

        }

    }

        public static void main(String st[]){

            Scanner ob=new Scanner(System.in);

            DLL dq=new DLL();

            int n;

            do{

            System.out.println("\n1.insertfirst\n2.insertlast\n3.deletefirst\n4.deletelast\n5.exit");

            System.out.print("enter opt:");

            n=ob.nextInt();

            switch(n){

                case 1:int x;

                       System.out.print("enter the value to be inserted:");

                       x=ob.nextInt();

                       insertfirst(x,dq);

                       display(dq);

                       break;

                case 2:int d;

                       System.out.print("enter the value to be inserted:");

                       d=ob.nextInt();

                       insertlast(d,dq);

                       display(dq);

                       break;

                case 3:System.out.println("deque after deletion");

                	deletefirst(dq);

                       

                       break;          

                case 4 :System.out.println("deque after deletion");

                	deletelast(dq);                                           

                       break;

                case 5:break;              

                default:System.out.println("invalid");

            }

        }while(n!=5);

    }

    

}

