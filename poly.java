import java.util.*;

import java.io.*;

class Link{

    public int coeff;

    public int exp;

    public Link next;

    public Link(int c,int e){

        coeff=c;

        exp=e;

    }

    public void display(){

        if(next==null)

            System.out.print(coeff+"x^"+exp);

        else 

        System.out.print(coeff+"x^"+exp+"+");

    }

}

class Linkedlist{

    public Link first;

    public Link last;

    public Linkedlist(){

        first=null;

        last=null;

    }

    public boolean isempty(){

        return (first==null&&last==null);

    }

    public void insertlast(int c,int e){

        Link nl=new Link(c,e);

        if(isempty()){

            first=nl;

            last=nl;

        }

        else{

            last.next=nl;

            //nl.prev=last;

            last=nl;

        }

    }

    public void displaylist(){

        Link current=first;

        while(current!=null){

            current.display();

            current=current.next;

        }

    }

}

public class poly {

    public static Linkedlist addpoly(Linkedlist l1,Linkedlist l2){

        Linkedlist result=new Linkedlist();

        Link p=l1.first;

        Link q=l2.first;

        Link r=new Link(0,0);

        while(p!=null||q!=null){

            if (q==null){

                r.exp=p.exp;

                r.coeff=p.coeff;

                p=p.next;

            }

            else if(p==null){

                r.exp=q.exp;

                r.coeff=q.coeff;

                q=q.next;

            }

            else if(p.exp==q.exp){

                r.coeff=p.coeff+q.coeff;

                r.exp=p.exp;

                p=p.next;

                q=q.next;

            }

            else if(p.exp>q.exp){

                r.exp=p.exp;

                r.coeff=p.coeff;

                p=p.next;

            }

            else if(q.exp>p.exp){

                r.exp=q.exp;

                r.coeff=q.coeff;

                q=q.next;

            }

           

            //System.out.println(r.coeff+"x^"+r.exp+"+");

            result.insertlast(r.coeff,r.exp);

        }

        return result;

    }

    

    public static void main(String st[]){

        int n1,n2;

        Linkedlist a=new Linkedlist();

        Linkedlist b=new Linkedlist();

        Scanner ob=new Scanner(System.in);

        System.out.println("enter the no of nodes for the equation 1:");

        n1=ob.nextInt();

        System.out.println("enter the first equation:");

        for(int i=0;i<n1;i++){

            int x=ob.nextInt();

            int y=ob.nextInt();

            a.insertlast(x,y);

        }

        System.out.print("A= ");

        a.displaylist();

        System.out.print("\n");

        System.out.println("enter the no of nodes for the equation 2:");

        n2=ob.nextInt();

        System.out.println("enter the second equation:");

        for(int i=0;i<n2;i++){

            int x=ob.nextInt();

            int y=ob.nextInt();

            b.insertlast(x,y);

        }

        System.out.print("B= ");

        b.displaylist();

        System.out.print("\n");

        Linkedlist r=addpoly(a, b);

        System.out.println("RESULT:");

        r.displaylist();

    }

}
