package sn.isep.edu.diamniadio.bankIsped.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isep.edu.diamniadio.bankIsped.entity.Client;

    public interface ClientRepository extends JpaRepository<Client, Long> {

    }

