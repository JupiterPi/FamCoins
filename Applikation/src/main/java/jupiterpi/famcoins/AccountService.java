package jupiterpi.famcoins;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class AccountService
{
    private Map<String,Account> accounts = new HashMap<String,Account>();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    private final String accountsFileName = "accounts.txt";
    private final String transactionsFileName = "transactions.txt";


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

    private void readAccounts () throws IOException
    {
        // Accounts werden vollständig aus File in [accounts] eingelesen. 
        try
        {
            FileTool accountsFile = new FileTool (accountsFileName);
            for (int i = 0; i < accountsFile.getFile().size(); i++)
            {
                String line = accountsFile.getLine(i);
                /* Account acc = ???;
                accounts.put(makeID(acc.getOwner(),acc.getUnit()),acc); */
                Account account = new Account (line.split(";"));
                accounts.put (makeID (account.getOwner(), account.getUnit()), account);
            }
            accountsFile.saveFile();
        }
        catch (FileNotFoundException x)
        {
            System.out.println ("[WARNING] Can't found accounts.txt. Created empty accounts list. ");
        }
    }

    private void writeAccounts ()
    {
        Account[] accountsArray = accounts.values().toArray();
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < accounts.size(); i++)
        {
            lines.add (accountsArray[i].toString());
        }
        FileTool accountsFile = new FileTool (accountsFileName);
        accountsFile.setFile (lines);
        accountsFile.saveFile();
    }

    private void writeTransactions ()
    {
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < transactions.size(); i++)
        {
            lines.add (transactions.get(i).toString());
        }
        FileTool transactionsFile = new FileTool (transactionsFileName);
        transactionsFile.setFile (lines);
        transactionsFile.saveFile();
    }
}