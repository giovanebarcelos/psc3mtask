package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "views/usuario")
public class Usuario {
    @Id
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(int id, String nome,
                   String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
}
