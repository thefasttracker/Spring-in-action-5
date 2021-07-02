package space.thefasttracker.tacoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
Spring Security offers several options for configuring a user store, including these:
- An in-memory user store
- A JDBC-based user store
- An LDAP-backed user store
- A custom user details service
*/
@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userRepositoryUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
//    return new StandardPasswordEncoder("53cr3t");
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers(HttpMethod.OPTIONS).permitAll() // needed for Angular/CORS
                    .antMatchers("/design", "/orders/**")
                        .permitAll()
                //.access("hasRole('ROLE_USER')")
                    .antMatchers(HttpMethod.PATCH, "/ingredients").permitAll()
                    .antMatchers("/**").access("permitAll")

                .and()
                    .formLogin()
                        .loginPage("/login")

                .and()
                    .httpBasic()
                        .realmName("Taco App")

                .and()
                    .logout()
                        .logoutSuccessUrl("/")

                .and()
                    .csrf()
                        .ignoringAntMatchers("/h2-console/**", "/ingredients/**", "/design", "/orders/**")

                // Allow pages to be loaded in frames from the same origin; needed for H2-Console
                .and()
                    .headers()
                        .frameOptions()
                            .sameOrigin()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder());
    }

    //in-memory user store
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth
//            .inMemoryAuthentication()
//                .withUser("buzz")
//                .password(encoder.encode("infinity"))
//                .authorities("ROLE_USER")
//                .and()
//                .withUser("woody")
//                .password("{noop}bullseye")
//                .authorities("ROLE_USER");
//    }

    //JDBC-based user store
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .jdbcAuthentication()
//            .dataSource(dataSource)
//                .usersByUsernameQuery(
//                    "select username, password, enabled from Users " +
//                            "where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, authority from UserAuthorities " +
//                                "where username=?")
//                .passwordEncoder(new StandardPasswordEncoder("53cr3t"));
//    }
}