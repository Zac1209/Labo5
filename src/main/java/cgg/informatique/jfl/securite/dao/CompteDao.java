package cgg.informatique.jfl.securite.dao;

import cgg.informatique.jfl.securite.entite.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteDao extends JpaRepository<Compte, String> {
}