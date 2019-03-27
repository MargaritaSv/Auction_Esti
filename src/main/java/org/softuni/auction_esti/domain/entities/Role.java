package org.softuni.auction_esti.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    private Integer id;
    private String name;
    private List<UserPassword> userPasswords;

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty
    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public List<UserPassword> getUserPasswords() {
        return userPasswords;
    }

    public void setUserPasswords(List<UserPassword> userPasswords) {
        this.userPasswords = userPasswords;
    }
}
