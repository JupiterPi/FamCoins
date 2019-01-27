/*package jupiterpi.famcoins;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService ()
	{
		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/add/**" ).hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/**" ).hasRole("USER")
			.anyRequest().permitAll()
		.and()
			.formLogin()
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}
}*/