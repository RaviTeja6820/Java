import java.io.*;
import java.util.*;
interface name1
{
int i=0;
void m1();
}
interface name2
{
int j=0;
void m2();
}
class name implements name1,name2
{
public int g,h;
Scanner sc=new Scanner(System.in);
public void m1()
{
g=sc.nextInt();
g=g+i;
}
public void m2()
{
h=sc.nextInt();
h=h+j;
}
public void method()
{
int c=g+h;
System.out.println("c="+c);
}
}
class interf
{
public static void main(String args[])
{
name o=new name();
o.m1();
o.m2();
o.method();
}
}