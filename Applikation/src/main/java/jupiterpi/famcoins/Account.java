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
}