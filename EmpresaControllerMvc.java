package com.example.Projetinho.controller.mvc;

import com.example.Projetinho.controller.dto.EmpresaDto;
import com.example.Projetinho.controller.dto.NovoProdutoDto;
import com.example.Projetinho.model.CadasEmpre;
import com.example.Projetinho.model.Produto;
import com.example.Projetinho.service.ProdutoService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

public class EmpresaControllerMvc
{
    private final EmpresaService service;

    public EmpresaControllerMvc(EmpresaService service){
        this.service = service;
    }
    @GetMapping("/Empresa")
    public String helloMvc(){
        return "hello";
    }

    @GetMapping("/lista")
    public String listarEmpresas(Model model){
            List<CadasEmpre.Empresa> empresa = service.ListaEmpresa();
        model.addAttribute("Empresas", empresa);
        return "Empresas/lista";
    }

    @GetMapping("/formulario")
    public String formularioEmpresa(EmpresaDto empresaDto){
        return "Empresa/formulario";
    }
    //405 <- e metodo nao permitido
    //404 <- nao existente
    //500 <- erro de servidor
    @PostMapping("/novo")
    public String adicionarEmpresa(@Valid EmpresaDto empresaDto, BindingResult result){

        if(result.hasErrors())
            return "produto/formulario";
        service.adicionaEmpresa(empresaDto.converter());
        return "redirect:/lista";
    }
}
