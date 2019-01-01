package famcoins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class Application
{
    @Autowired AccountService service;
    public static void main (String[] args)
    {
        SpringApplication.run (Application.class, args);
    }
}