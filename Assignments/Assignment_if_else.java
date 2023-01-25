import java.util.Scanner;
public class Assignment_if_else {
    public static void main(String[] args) {
        
    }
}

class Ques1{
    public static void main(String[] args) {
        //write a program to check whether a year is leap year or not
        //so basically , leap year is a year which is divisible by 4 - as it comes once after 4 years
        //Although for a centurian year , if the year is divisible by 100 i.e 2100 , 2200 , 2300  then it is nota  leap year 
        //for centurian year: if the year is divisible by 400 then year is a leap year like 2000 , 2400 , 2800(gap of 100 years)
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year=sc.nextInt();
        System.out.println();
        if(year%400==0 || year%4==0 && year%100!=0){
            System.out.println("A leap year");
        }
        else System.out.println("A common year");

        sc.close();
    }
}


class Ques2{
    public static void main(String[] args) {
        //Grading System
        /*
         * >=90 A grade
         * <90 to 70 B Grade
         * <70 to 60 C grade
         * <60 to 50 D grade
         * <60 to 50 D Grade
         * F Grade
         */

         System.out.print("Enter a Number : ");
         Scanner sc=new Scanner(System.in);
         int marks=sc.nextInt();
         
         
         if(marks>=90){
            System.out.println("Grade A");
         }
         else if(marks<90 && marks>=70){
            System.out.println("Grade B");
         }
         else if(marks<70 && marks>=60){
            System.out.println("Grade C");
         }
         else if(marks<60 && marks>=50){
            System.out.println("Grade D");
         }
         else System.out.println("Fail");
         sc.close();
    }
}

class Ques3{
    public static void main(String[] args) {
        //ATM Machine 
        //we'll use Switch statment for making ATM
        //we'll perform 2 Basic Operation
        //Deposit , Withdraw
 
        int balance=1000;
        int withdraw , deposit;

        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.println("Choose a Operation: ");
            
            int operation =sc.nextInt();
            switch(operation){
                case 1: 
                System.out.println("Enter money to be deposited:");
                deposit = sc.nextInt();  
                      
 
        balance = balance + deposit;  
        System.out.println("Your Money has been successfully depsited");  
        System.out.println("");  
        break;  

               case 2:  
        System.out.print("Enter money to be withdrawn:");  
                      
        //get the withdrawl money from user  
        withdraw = sc.nextInt();  
                      
        //check whether the balance is greater than or equal to the withdrawal amount  
        if(balance >= withdraw)  
        {  
            //remove the withdrawl amount from the total balance  
            balance = balance - withdraw;  
            System.out.println("Please collect your money");  
        }  
        else  
        {  
            //show custom error message   
            System.out.println("Insufficient Balance");  
        }  
        System.out.println("");  
        break;  

        case 3:  
         
        System.out.println("Balance : "+balance);  
        System.out.println("");  
        break;  
   
        case 4: 
        System.exit(0);  
            }
        }
       
        
    }
}


class Ques4{
    public static void main(String[] args) {
        System.out.println("Welcome to TAJ Hotel : "); 
        System.out.println("Main Course"); 
        System.out.println(" 1 : Paneeer Butter Masala");
        System.out.println(" 2 : Dal Makhni");
        System.out.println(" 3 : Indian Curry ");
        System.out.println(" 4 : Butter Chicken");
        System.out.println("Breads");
        System.out.println(" 5 : Tandoori Roti");
        System.out.println(" 6 : Tawa Roti");
        System.out.println("Dessert"); 
        System.out.println(" 7 : Gulab Jamun");
        System.out.println(" 8 : Gajar Ka Halwa");
        System.out.println("Beverages");
        System.out.println(" 9 : Mineral Water");
        System.out.println(" 10 : Soft Drinks");

        System.out.println("How many items you want to order : ");

        Scanner sc = new Scanner(System.in);
          int n = sc.nextInt(); 
        int [] arr = new int[n];
        System.out.println("Tell Your Order : ");
         for(int i =0; i<n; i++){ 
            arr[i] = sc.nextInt(); 
        } 
        int BillAmount = 0; 
        for(int i =0; i<n; i++){
             switch(arr[i]){
                 case 1 : int amount1 = 300; BillAmount += amount1; break; 
                 case 2 : int amount2 = 250; BillAmount += amount2; break;
                 case 3 : int amount3 = 350; BillAmount += amount3; break;
                 case 4 : int amount4 = 500; BillAmount += amount4; break;
                 case 5 : int amount5 = 30;  BillAmount += amount5; break;
                 case 6 : int amount6 = 20;  BillAmount += amount6; break;
                 case 7 : int amount7 = 100; BillAmount += amount7; break;
                 case 8 : int amount8 = 100; BillAmount += amount8; break;
                 case 9 : int amount9 = 60;  BillAmount += amount9; break;
                 case 10 :int amount10 = 90; BillAmount += amount10;break;
                 default : System.out.println("No Order"); 
                } 
            } 
            System.out.println("Thank You For Visiting"); 
            System.out.println("Your Bill Amount is : "+BillAmount); 
        } 
    }
                 
    

