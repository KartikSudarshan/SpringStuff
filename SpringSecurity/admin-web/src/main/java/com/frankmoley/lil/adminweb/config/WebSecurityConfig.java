package com.frankmoley.lil.adminweb.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
        .authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/customers/**").hasRole("USER")
        .antMatchers("/orders").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureUrl("/login?error")
        .permitAll()
        .and()
        .logout()
        .clearAuthentication(true)
        .invalidateHttpSession(true)
        .logoutSuccessUrl("/login?logout")
        .permitAll();
	}
	
	/* Code used for in memory authenication
	 * @Bean
	 * @Override 
	 * public UserDetailsService userDetailsService() { UserDetails
	 * userDetails= User.withDefaultPasswordEncoder() .username("user")
	 * .password("password") .roles("USER") .build(); return new
	 * InMemoryUserDetailsManager(userDetails); }
	 */
	
	@Bean
	public UserDetailsService user (DataSource datasource ) {
		return new JdbcUserDetailsManager(datasource);
	}
	
	/* Default Password encoder is bcrypt in spring 
	 * Commenting the below function so that spring will use bcrypt instead 
	 * 
	 * @Bean public static PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
	
	@Bean
	public GrantedAuthoritiesMapper authoritiesMapper() {
		SimpleAuthorityMapper authorityMapper=new SimpleAuthorityMapper();
		authorityMapper.setConvertToUpperCase(true);
		return authorityMapper;
	}
}
