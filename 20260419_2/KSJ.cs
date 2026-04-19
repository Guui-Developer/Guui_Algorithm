using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;

public class Account
{
    public long Balance;
    
    public Account(long balance) {
        Balance = balance;
    }
}

public class Bank
{

    public Dictionary<int, Account> Accounts = new();

    public Bank(long[] balance) {
        for (int i = 0; i < balance.Length; i++) {
            Accounts.Add(i+1, new Account(balance[i]));
        }
    }
    
    public bool Transfer(int account1, int account2, long money) {
        var from = GetAccounts(account1);
        var to = GetAccounts(account2);
        
        if (from == null || to == null || from.Balance < money) {
            return false;
        }

        to.Balance += money;
        from.Balance -= money;
        return true;

    }
    
    public bool Deposit(int account, long money) {
        var acc = GetAccounts(account);
        if (acc == null) {
            return false;
        }
        acc.Balance += money;
        return true;
    }
    
    public bool Withdraw(int account, long money) {
        var acc = GetAccounts(account);
        if (acc == null || acc.Balance < money) {
            return false;
        }
        acc.Balance -= money;
        return true;
    }
    
    Account? GetAccounts(int num)
    {
        if (!Accounts.TryGetValue(num, out var accounts))
        {
            return null;
        }
        return accounts;
    }
}