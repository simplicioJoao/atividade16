package com.example.produtos.service;

import com.example.produtos.model.Produto;
import com.example.produtos.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {
    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarProduto_deveRetornarProdutoCriado() {
        Produto produto = new Produto();
        produto.setNome("Produto Teste");
        when(produtoRepository.save(produto)).thenReturn(produto);

        Produto produtoCriado = produtoService.criarProduto(produto);
        assertEquals("Produto Teste", produtoCriado.getNome());
    }

    @Test
    void buscarPorId_deveRetornarProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Optional<Produto> resultado = produtoService.buscarPorId(1L);
        assertTrue(resultado.isPresent());
        assertEquals("Produto Teste", resultado.get().getNome());
    }

    @Test
    void deletarProduto_deveChamarMetodoDeleteDoRepositorio() {
        produtoService.deletarProduto(1L);
        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
