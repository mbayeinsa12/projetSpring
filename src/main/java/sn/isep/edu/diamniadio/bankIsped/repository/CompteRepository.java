package sn.isep.edu.diamniadio.bankIsped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.edu.diamniadio.bankIsped.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
