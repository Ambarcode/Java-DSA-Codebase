import java.util.EnumSet;
import java.util.Scanner;

import javax.xml.transform.SourceLocator;

public class Assignment_For_Loop{
    public static void main(String[] args) {
        
    }
}
class ques1{
    // Write a program to calculate the sum of following series where n is input by user. 

//e.g 1 + 1/2 + 1/3 + 1/4 + 1/5 +…………1/n 
/**
 * @param args
 */
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter value of n: ");
    int n=sc.nextInt();
    double sum=0.0;

    for (double i = 1; i <=n; i++) {
     sum+=(1/i); 
    }
    System.out.println();
    System.out.printf("Sum is %f", sum);


    sc.close();

}
}

class ques2{
    public static void main(String[] args) {
        //Find out Prime number
         int n=17;
         if(n==1) {
         System.out.println("Not Prime");
         return ;
         }
         if(n==2 || n==3){
         System.out.println("Prime ");
          return;
         }
         if(n%2==0|| n%3==0){
            System.out.println("Not Prime");
            return;
         }
         for (int i = 5; i < Math.sqrt(n); i+=6) {
            if(i%2==0 ||(i+2)%2==0){
              System.out.println("Not Prime");
              return;
            }
         }
         System.out.println("Prime");
    }
}

class ques3{
    public static void main(String[] args) {
        int num=123456;
        int rev=0;
        while(num>0){
           rev=rev*10+(num%10);
           num/=10;
        }
        System.out.println("Reverse->"+rev);
    }
}

class ques4
{
    public static void main(String[] args)
    {   
        int num1=5;
        int num2=10;
        int n1=num1,n2=num2;
        while(n1%n2!=0){
            int rem=n1%n2;
            n1=n2;
            n2=rem;
        }
        System.out.printf("GCD of %d and %d is %d",num1,num2,n2);
        System.out.println();
        System.out.printf("LCM of %d and %d is %d",num1,num2,(num1*num2)/n2);
    } 
}

class ques5{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        System.out.println();
        int sum=0;
        int num=n;
        while(n>0){
        sum=sum+(n%10);
        n/=10;
        }
        if(num%sum==0){
            System.out.println("Yes");
        }
        else System.out.println("NO");

    }
}

class ques6{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the pair:  ");
        int n=sc.nextInt();
        int ans=sc.nextInt();
        System.out.println();
        int product=1;
        int num=n;
        while(n>0){
            product=product*(n%10);
            n/=10;
        }
        if(product*num==ans)
        System.out.println("Yes");
        else System.out.println("NO");
        // if(num*product==ans) System.out.println("Yes");
        // else System.out.println("NO");
        sc.close();

    }
}