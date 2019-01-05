package jupiterpi.famcoins;

public class Account
{
    private String owner;
    private int amount;
    private String unit;

    public Account () {}

    public Account (String owner, String unit)
    {
        this.owner = owner;
        this.amount = 0;
        this.unit = unit;
    }

    public Account (String owner, int amount, String unit)
    {
        this.owner = owner;
        this.amount = amount;
        this.unit = unit;
    }

    public Account (String[] line)
    {
        owner = line[0];
        amount = Integer.parseInt(line[1]);
        unit = line[2];
    }

    public void setOwner (String owner)
    {
        this.owner = owner;
    }

    public String getOwner ()
    {
        return this.owner;
    }
    
    public void setAmount (int amount)
    {
        this.amount = amount;
    }

    public int getAmount ()
    {
        return this.amount;
    }

    public void serUnit (String unit)
    {
        this.unit = unit;
    }

    public String getUnit ()
    {
        return this.unit;
    }

    public String toString ()
    {
        return owner + ";" + amount + ";" + unit;
    }
}