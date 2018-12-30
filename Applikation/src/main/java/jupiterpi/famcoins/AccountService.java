package jupiterpi.famcoins;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

public class AccountService
{
    private Map<String,Account> accounts = new HashMap<String,Account>();
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public void createAccount (String owner, String unit)
    {
        Account account = new Account(owner, unit);
    }

    public void transfer (String from, String to, String unit, int amount) {}

    public void add (String owner, String unit, int amount) {}

    public void remove (String owner, String unit, int amount) {}
}