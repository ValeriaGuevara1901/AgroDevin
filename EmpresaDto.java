package com.example.Projetinho.controller.dto;

import com.example.Projetinho.model.CadasEmpre;
import com.example.Projetinho.model.Produto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class EmpresaDto
{
    @NotBlank
    private String nomefantasia;
    @NotBlank
    private String nomesocial;
    @NotBlank
    private String descricao;
    @Pattern
            (regexp="[0-9]{1,13}(\\.[0-9]{2})?", message = "Campo deve ser um número válido")
    private String CNPJ;

    public Produto converter()
    {
        CadasEmpre empresa = new CadasEmpre();
        CadasEmpre.setDescricao(descricao);
        CadasEmpre.setNomefantasia(nomefantasia);
        CadasEmpre.setNomesocial(nomefantasia);
        CadasEmpre.setData(LocalDate.now());
        return produto;
    }
}
