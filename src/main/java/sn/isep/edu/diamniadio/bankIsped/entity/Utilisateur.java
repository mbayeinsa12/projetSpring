package sn.isep.edu.diamniadio.bankIsped.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String Roles;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    // getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
