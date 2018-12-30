package jupiterpi.famcoins;

// import jupiterpi.textserver.filetool.FileTool;

import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

@RequestMapping(path = "")
@RestController
public class Controller
{
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
}