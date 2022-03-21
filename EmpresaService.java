package com.example.Projetinho.service;

import com.example.Projetinho.model.CadasEmpre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaService
{

    private final EmpresaRepository repository;

    public EmpresaService(EmpresaRepository repository)
    {
        this.repository = repository;
    }

    public List<Empresa> ListaEmpresas()
    {
        return (List<CadasEmpre.Empresa>) repository.findAll();
    }

    public Empresa adicionaEmpresa(Empresa empresa)
    {
        return repository.save(empresa);
    }

    public Empresa atualizaEmpresa(Long id, Empresa empresa)
    {//corregir escrita estão faltando só dois clases mais ok?
        Empresa empresatualizado = repository.findById(id).get();
        Empresaatualizado.setId(id);
        produtoatualizado.setData(produto.getData());
        produtoatualizado.setNomefantasia(produto.getNomefantasia());
        produtoatualizado.setNomesocial(produto.getNomesocial());
        produtoatualizado.setDescricao(produto.getDescricao());
        produtoatualizado.setCNPJ(produto.getCNPJ());
        return repository.save(empresatualizado);
    }

    public void deletaEmpresa(Long id)
    {
        repository.deleteById(id);
    }
}
