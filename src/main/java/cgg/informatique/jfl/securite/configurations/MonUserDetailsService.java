package cgg.informatique.jfl.securite.configurations;

import cgg.informatique.jfl.securite.dao.CompteDao;
import cgg.informatique.jfl.securite.entite.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonUserDetailsService  implements UserDetailsService {
    @Autowired
    private CompteDao compteDao;
    @Override
    public UserDetails loadUserByUsername(String nom) {
        Optional<Compte> compte = compteDao.findById(nom);
        Compte c;
        if (compte.isPresent())
            c = compte.get();
        else
        {
            //Mot de passe anonyme est JaimeLesPatates!!!
            c = new Compte("anonyme", "anonyme",
                    "$2a$10$v3EXvAFWCsyUNWmKaw6uI.TanoXeQ9h0zq4mxurfdSow.dvCvOovO", "");
        }
        return new MonUserPrincipal(c);
    }

}
