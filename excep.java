import java.io.*;
import java.util.*;
class excep
{
public static void main(String arg[])
{
Scanner sc=new Scanner(System.in);
float[] arr=new float[4];
float[] den=new float[4];
float[] div=new float[4];
int i=0;
System.out.println("Enter Array and denominator");
while(true)
{
arr[i]=sc.nextInt();
den[i]=sc.nextInt();
i++;
if(i==4)
break;
}
i=0;
while(true)
{
try{
div[i]=(arr[i]/den[i]);
}
catch(ArithmeticException ex){
System.out.println(ex);
}
catch(ArrayIndexOutOfBoundsException ex){
System.out.println(ex);
}
finally
{
if(i<4)
System.out.println("arr["+i+"] "+arr[i]+" "+den[i]);
}
i++;
System.out.println(i);
if(i==6)
break;
}
for(int j=0;j<4;j++){
System.out.println(div[j]);
}
}
}