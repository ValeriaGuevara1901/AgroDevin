package com.example.Projetinho.controller.dto;

import com.example.Projetinho.model.CadasEmpre;
import com.example.Projetinho.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class FazendaDto
{
    @NotBlank
    private String nomefazenda;
    @NotBlank
    private String endereco;
    @NotBlank
    private String grao;
    @NotBlank
    private Double pesograo;
    @Pattern
            (regexp="[0-9]{1,13}(\\.[0-9]{2})?", message = "Campo deve ser um número válido")
    private String nomefazenda;

    public Fazenda converter()
    {
        Fazenda fazenda = new Fazenda();
        Fazenda.setNomefazenda(nomefazenda);
        Fazenda.setEndereco(endereco);
        Fazenda.setGrao(grao);
        Fazenda.setPesograo(pesograo);
        return fazenda;
    }
}
