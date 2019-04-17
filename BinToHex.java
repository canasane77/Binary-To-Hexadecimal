import java.util.ArrayList;
import java.util.Scanner;

public class BinToHex 
{
  public static void main(String args[])
  {
	  String num ;
	  System.out.println("Enter Binary Number");
	  Scanner s = new Scanner(System.in);
	  num = s.next();
	  ArrayList al = new ArrayList();
	  
	  double sum = 0;
	  int length = num.length();
	  System.out.println("lenth="+length);
	  int split = length/4;  //To know how many splits of 4 will be required
	  int remainder = length % 4;  //to know how many digits remain after splitting into 4 like (110 1111 1010)110<---remaining split.
	  if(split == 0)  //if length of binary number is less than 4(i.e. 0 to 7 or 000 to 111)
	  {
		  int cnt=0;
		  for(int i = num.length()-1;i>=0;i--)
		  {
			  double x = Math.pow(2,cnt) * Character.getNumericValue(num.charAt(i)); 
			  sum = sum+x;
			  cnt++;
		  }
		  al.add(Math.round(sum));
		
		  System.out.println(sum);
	  }
	  
	  // if length of binary number is greater than 3 i.e >=4
	  else
	  {   
		  int cnt = 0;
		  for(int i=num.length()-1;i>=(num.length() - (4*split));i--) // start from last index and go till the last index of split i.e (110 1111 1010)till the 2nd index
		  {
			  double x = Math.pow(2,cnt) * Character.getNumericValue(num.charAt(i)); 
			  sum = sum+x;
			  cnt++;
			  if(cnt==4)
			  {
				  if(sum == 10)
					{
						al.add("A");
						cnt = 0;
						sum=0;
					}
					else if(sum == 11)
					{
						al.add("B");
						cnt=0;
						sum=0;
						
					}
					else if(sum == 12)
					{
						al.add("C");
						cnt = 0;
						sum=0;
					}
					else if(sum == 13)
					{
						al.add("D");
						cnt = 0;
						sum=0;
					}	
					else if(sum == 14)
					{
						al.add("E");	
						cnt = 0;
						sum=0;
					}	
					else if(sum == 15)
					{
						al.add("F");
						cnt = 0;
						sum=0;
					}
					else
					{
						al.add(Math.round(sum));
						cnt = 0;
						sum = 0;
					}
					
			  }
		  }
	       //System.out.println(al);
		  // for the last remaining split i.e.split< 4
		  if(remainder==0)
		  {
			  for(int j=al.size()-1;j>=0;j--)
			  {
				  System.out.print(al.get(j));
			  } 
		  }
		  else
		  {
		  int index = remainder-1;
		  int cnt1=0;
		  
		  for(int i = index;i>=0;i--)
		  {
			  double x = Math.pow(2,cnt1) * Character.getNumericValue(num.charAt(i)); 
			  sum = sum+x;
			  cnt1++;
	      }
		  al.add(Math.round(sum));
		  for(int j=al.size()-1;j>=0;j--)
		  {
			  System.out.print(al.get(j));
		  }
		  }
		  
	  }
	  
	  
	  
	  
	  
		
 }
}
