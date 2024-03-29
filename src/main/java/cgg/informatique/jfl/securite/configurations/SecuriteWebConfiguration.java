package cgg.informatique.jfl.securite.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuriteWebConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private MonUserDetailsService monUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //permettre toutes les requêtes
        http.authorizeRequests()
                .antMatchers("/admin/**", "/admin/", "/Mystere", "/Mystere/**").hasAuthority("ADMIN")
                .antMatchers("/membre/**", "/membre/").authenticated()
                .and()
                //Activer le formulaire pour login
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/publique")
                //pour la console H2
                .and()
                .csrf()
                .ignoringAntMatchers("/consoleBD/**").and()
                .headers()
                .frameOptions()
                .sameOrigin();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(monUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    };

}
