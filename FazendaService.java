package com.example.Projetinho.service;

import com.example.Projetinho.model.Produto;
import com.example.Projetinho.repository.ProdutoRepository;

import java.util.List;

public class FazendaService
{
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository)
    {
        this.repository = repository;
    }

    public List<Produto> ListaProdutos()
    {
        return (List<Produto>) repository.findAll();
    }

    public Produto adicionaProduto(Produto produto)
    {
        return repository.save(produto);
    }

    public Produto atualizaProduto(Long id, Produto produto)
    {
        Produto produtoatualizado = repository.findById(id).get();
        produtoatualizado.setId(id);
        produtoatualizado.setData(produto.getData());
        produtoatualizado.setNome(produto.getNome());
        produtoatualizado.setDescricao(produto.getDescricao());
        produtoatualizado.setValor(produto.getValor());
        return repository.save(produtoatualizado);
    }

    public void deletaProduto(Long id)
    {
        repository.deleteById(id);
    }
}
