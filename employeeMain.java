import java.io.*;
import java.util.*;
class nameException extends Exception
{
String str;
nameException(String name)
{
str=name;
}
}
class ageException extends Exception
{
int n;
ageException(int age)
{
n=age;
}
}
class employeeMain
{
public static void main(String args[])
{
String name=new String();
name=args[0];
int age=Integer.parseInt(args[1]);
try{
if(age>50)
throw new ageException(age);
}
catch(ageException er)
{
System.out.println(er.n+" is higher");
}
finally{
int count=0;
for(int i=0;i<name.length();i++)
{
if(Character.isDigit(name.charAt(i)))
count++;
}
try{
if(count==name.length())
throw new nameException(name);
}
catch(nameException nam){
System.out.println(nam.str+"is invalid");
}
}
}
}