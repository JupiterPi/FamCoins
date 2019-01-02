package jupiterpi.famcoins;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    private Map<String,Account> accounts = new HashMap<String,Account>();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    private String makeID (String owner, String unit)
    {
        return owner + "/" + unit;
    }

    public void createAccount (String owner, String unit) throws Exception
    {
        String id = makeID(owner, unit);
        Account existing = accounts.get(id);
        if (existing != null) throw new Exception("Account exists already");
        Account account = new Account(owner, unit);
        accounts.put(id, account);
    }

    private void transact(String owner, String unit, int amount, String action)
    {
        String id = makeID(owner, unit);
        Account account = accounts.get(id);
        Transaction transaction = new Transaction(action, owner, amount, unit);
        if (action.equals("add")) account.setAmount(account.getAmount() + amount);
        else account.setAmount(account.getAmount() - amount);
        transactions.add(transaction);
    }

    public void transfer (String from, String to, String unit, int amount)
    {
        transact(from, unit, amount, "remove");
        transact(to, unit, amount, "add");
    }

    public void add (String owner, String unit, int amount)
    {
        transact (owner, unit, amount, "add");
    }

    public void remove (String owner, String unit, int amount)
    {
        transact (owner, unit, amount, "remove");
    }

    public int getAmount (String owner, String unit)
    {
        Account account = accounts.get(makeID(owner, unit));
        if (account == null) return 0;
        return account.getAmount();
    }
}