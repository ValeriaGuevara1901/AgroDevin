package com.example.Projetinho.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

public class CadasEmpre
{

    @Entity
    @Setter
    @Getter
    @Table(name="Cadastro Empresa")
    public class Empresa
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        @Column(name="Nome fantasia")
        private String nomefantasia;
        @Column(name="razao social")
        private String nomesocial;
        @Column(name="CNPJ")
        private String CNPJ;
        @Column(name="descricao")
        private String descricao;
        @Column(name="data de criação")
        private LocalDate data;
    }
}
