package com.example.Projetinho.controller.mvc;

import com.example.Projetinho.controller.dto.FazendaDto;
import com.example.Projetinho.controller.dto.NovoProdutoDto;
import com.example.Projetinho.model.Produto;
import com.example.Projetinho.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class FazendaControllerMvc
{
    private FazendaService service;

    public FazendaController(FazendaService service)
    {
        this.service = service;
    }

    @GetMapping
    public String faznda ()
    {
        return "Fazenda";
    }

    @GetMapping("/todos")
    public List<Fazenda> ListarFazendas()
    {
        return service.ListaFazenda();
    }

    @PostMapping
    public Produto adicionarFazenda(@RequestBody FazendaDto fazendaDto)
    {
        return service.adicionaFazenda(fazendaDto.converter());
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto (@PathVariable Long id, @RequestBody FazendaDto fazendaDto)
    {
        return service.atualizaFazenda(id, fazendaDto.converter());
    }

    @DeleteMapping("/{id}")
    public void deletarFazenda (@PathVariable Long id)
    {
        service.deletaFazenda(id);
    }
}
