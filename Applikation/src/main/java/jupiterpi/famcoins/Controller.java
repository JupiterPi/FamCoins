package jupiterpi.famcoins;

// import jupiterpi.textserver.filetool.FileTool;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping(path = "/api")
@RestController
public class Controller
{
    @Autowired AccountService accountService;

    /* @GetMapping("")
    public String getText () throws FileNotFoundException, IOException
    {
        ArrayList<String> returnList = new ArrayList<String>();
        String returnString;

        FileTool file = new FileTool ("/home/jupiterpi/TextServer/file.txt");
        returnList = file.getFile();

        returnString = returnList.get(0);
        for (int i = 1; i < returnList.size(); i++)
        {
            returnString += "<br>" + returnList.get(i);
        }

        return returnString;
    } */

    @GetMapping("/amount/{owner}/{unit}")
    public String getAmount (@PathVariable String owner, @PathVariable String unit)
    {
        return Integer.toString(accountService.getAmount(owner, unit));
    }

    @PostMapping("/account")
    public void createAccount (@RequestBody Account account) throws Exception
    {
        String owner = account.getOwner();
        String unit = account.getUnit();
        accountService.createAccount(owner, unit);
    }

    @PostMapping("/add/{owner}/{unit}/{amount}")
    public void add (@PathVariable String owner, @PathVariable String unit, @PathVariable int amount)
    {
        accountService.add(owner, unit, amount);
    }

    @PostMapping("/remove/{owner}/{unit}/{amount}")
    public void remove (@PathVariable String owner, @PathVariable String unit, @PathVariable int amount)
    {
        accountService.remove(owner, unit, amount);
    }

    @PostMapping("/transfer/{from}/{to}/{unit}/{amount}")
    public void transfer (@PathVariable String from, @PathVariable String to, @PathVariable String unit, @PathVariable int amount)
    {
        accountService.transfer(from, to, unit, amount);
    }

    @GetMapping("/error")
    public String error ()
    {
        return "Ssssorry, es ist ein Fehler aufgetreten...";
    }
}