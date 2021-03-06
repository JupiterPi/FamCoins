package jupiterpi.famcoins;

public class Transaction
{
    private String action;
    private String owner;
    private int amount;
    private String unit;

    public Transaction (String action, String owner, int amount, String unit)
    {
        this.action = action;
        this.owner = owner;
        this.amount = amount;
        this.unit = unit;
    }

    public Transaction (String[] line)
    {
        action = line[0];
        owner = line[1];
        amount = Integer.parseInt (line[2]);
        unit = line[3];
    }

    public String getAction ()
    {
        return this.action;
    }

    public String getOwner ()
    {
        return this.owner;
    }

    public int getAmount ()
    {
        return this.amount;
    }

    public String getUnit ()
    {
        return this.unit;
    }

    public String toString ()
    {
        return action + ";" + owner + ";" + amount + ";" + unit;
    }
}