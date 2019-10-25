package cgg.informatique.jfl.securite.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriteWebConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //permettre toutes les requêtes
        http.authorizeRequests().anyRequest().permitAll()
                //configuration spécifique pour la console H2
                .and()
                .csrf()
                .ignoringAntMatchers("/consoleBD/**")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();
    }
}
