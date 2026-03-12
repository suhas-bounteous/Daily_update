package DAY1;

import java.util.Scanner;

import static java.lang.System.exit;

public class ATM {

    int bal;
    ATM(){
        bal = 1000;
    }

    public int checkBal(){
        return bal;
    }

    public void deposit(int amt){
        bal +=amt;
        System.out.println("Amount added to account");
    }

    public void withdraw(int amt){
        if(amt>bal){
            System.out.println("Insufficient funds");
            return;
        }
        bal -= amt;
        System.out.println("Amount withdrawn");
    }

    static void main() {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();
        System.out.println("Enter your choice: \n: 1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit.");
        int n = sc.nextInt();
        int flag=0;
        while(flag==0) {
            switch (n) {

                case 1:
                    int bal = atm.checkBal();
                    System.out.println("Balance: " + bal);

                case 2:
                    System.out.println("Enter the deposit maount: ");
                    int amt = sc.nextInt();
                    atm.deposit(amt);
                case 3:
                    System.out.println("Enter the withdrawl amount: ");
                    int cash = sc.nextInt();
                    atm.withdraw(cash);
                case 4:
                    System.out.println("Exiting the program");
                    flag = 1;
                    exit(0);
            }
        }

    }
}
