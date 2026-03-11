function bankAccount(balance){

    return {
      deposit(amount){
        balance += amount;
        return balance;
      },
  
      withdraw(amount){
        balance -= amount;
        return balance;
      }
    }
  }
  
  const account = bankAccount(100);
  
  console.log(account.deposit(50));
  console.log(account.withdraw(30));
  