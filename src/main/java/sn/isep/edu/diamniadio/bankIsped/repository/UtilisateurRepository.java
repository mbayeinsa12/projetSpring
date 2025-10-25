package sn.isep.edu.diamniadio.bankIsped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.edu.diamniadio.bankIsped.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsername(String username);
}
