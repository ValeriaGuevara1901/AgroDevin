package com.example.Projetinho.controller.rest;

import com.example.Projetinho.controller.dto.EmpresaDto;
import com.example.Projetinho.controller.dto.NovoProdutoDto;
import com.example.Projetinho.model.CadasEmpre;
import com.example.Projetinho.model.Produto;
import com.example.Projetinho.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller

public class EmpresaController
{
    private final EmpresaService service;

    public EmpresaControllerMvc(EmpresaService service){
        this.service = service;
    }
    @GetMapping("/empresa")
    public String helloMvc(){
        return "hello";
    }

    @GetMapping("/lista")
    public String listarEmpresas(Model model){
        List<CadasEmpre.Empresa> empresas = service.ListaEmpresas();
        model.addAttribute("Empresas", empresas);
        return "Empresa/lista";
    }

    @GetMapping("/formulario")
    public String formularioProduto(EmpresaDto empresaDto){
        return "produto/formulario";
    }
    //405 <- e metodo nao permitido
    //404 <- nao existente
    //500 <- erro de servidor
    @PostMapping("/novo")
    public String adicionarProduto(@Valid EmpresaDto empresaDto, BindingResult result){

        if(result.hasErrors())
            return "Empresa/formulario";
        service.adicionaEmpresa(empresaDto.converter());
        return "redirect:/lista";
    }
}
