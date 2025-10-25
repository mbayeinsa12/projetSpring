package sn.isep.edu.diamniadio.bankIsped.service;

import org.springframework.stereotype.Service;
import sn.isep.edu.diamniadio.bankIsped.entity.Client;
import sn.isep.edu.diamniadio.bankIsped.entity.Compte;
import sn.isep.edu.diamniadio.bankIsped.repository.ClientRepository;
import sn.isep.edu.diamniadio.bankIsped.repository.CompteRepository;

import java.util.List;

@Service
public class BankService {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;

    public BankService(ClientRepository clientRepository, CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Compte getCompte(Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte introuvable"));
    }

    public Compte createCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public String transfer(Long fromId, Long toId, double amount) {
        Compte from = getCompte(fromId);
        Compte to = getCompte(toId);

        if(from.getSolde() < amount){
            throw new RuntimeException("Solde insuffisant");
        }

        from.setSolde(from.getSolde() - amount);
        to.setSolde(to.getSolde() + amount);

        compteRepository.save(from);
        compteRepository.save(to);

        return "Transfert effectué avec succès";
    }
}