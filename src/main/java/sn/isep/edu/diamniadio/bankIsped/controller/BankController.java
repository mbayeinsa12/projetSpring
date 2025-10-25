package sn.isep.edu.diamniadio.bankIsped.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sn.isep.edu.diamniadio.bankIsped.entity.Client;
import sn.isep.edu.diamniadio.bankIsped.entity.Compte;
import sn.isep.edu.diamniadio.bankIsped.service.BankService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/clients")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(bankService.getAllClients());
    }

    @GetMapping("/solde/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Double> getSolde(@PathVariable Long id) {
        return ResponseEntity.ok(bankService.getCompte(id).getSolde());
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Compte> createCompte(@RequestBody Compte compte) {
        return new ResponseEntity<>(bankService.createCompte(compte), HttpStatus.CREATED);
    }

    @PostMapping("/transfer")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> transfer(@RequestParam Long from, @RequestParam Long to, @RequestParam double amount) {
        return ResponseEntity.ok(bankService.transfer(from, to, amount));
    }
}
