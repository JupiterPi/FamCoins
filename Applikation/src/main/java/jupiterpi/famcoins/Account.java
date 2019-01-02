package jupiterpi.famcoins;

public class Account
{
    private String owner;
    private int amount;
    private String unit;

    public Account (String owner, String unit)
    {
        this.owner = owner;
        this.amount = 0;
        this.unit = unit;
    }

    public String getOwner ()
    {
        return this.owner;
    }

    public int getAmount ()
    {
        return this.amount;
    }
    
    public void setAmount (int amount)
    {
        this.amount = amount;
    }

    public String getUnit ()
    {
        return this.unit;
    }
}