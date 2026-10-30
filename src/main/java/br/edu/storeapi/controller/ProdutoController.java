package br.edu.storeapi.controller;
import br.edu.storeapi.model.Produto;
import br.edu.storeapi.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

import br.edu.storeapi.dto.ProdutoRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
 private final ProdutoRepository repository;
 public ProdutoController(ProdutoRepository repository) { this.repository=repository; }

 // listar todos os produtos
 @GetMapping
 public List<Produto> listar() { return repository.findAll(); }


 // listar produto por id
 @GetMapping("/{id}")
 public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
  return repository.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }

 //cadastrar novo produto
 @PostMapping
 public ResponseEntity<Produto> cadastrar(
         // responsável por fazer todas as verificações  declaradas no dto
         @Valid @RequestBody ProdutoRequest request) {

  Produto produto = new Produto();

  produto.setNome(request.nome());
  produto.setDescricao(request.descricao());
  produto.setPreco(request.preco());
  produto.setEstoque(request.estoque());
  produto.setCategoria(request.categoria());

  Produto salvo = repository.save(produto);

  return ResponseEntity
          .created(URI.create("/api/produtos/" + salvo.getId()))
          .body(salvo);
 }


// buscar produto por nome
 @GetMapping("/busca")
 // armazena o que o user buscar no parâmetro nome, para comparar com as opções do repository
 public List<Produto> buscarPorNome(@RequestParam String nome) {
  return repository.findByNomeContainingIgnoreCase(nome);
 }

 // método PUT
 @PutMapping("/{id}")
 public ResponseEntity<Produto> atualizar(
         @PathVariable Long id,
         @RequestBody Produto dados) {

  // armazena todos os dados que foram atualizados e atribui eles ao produto quando o método for execcutado
  return repository.findById(id)
          .map(produto -> {
           produto.setNome(dados.getNome());
           produto.setDescricao(dados.getDescricao());
           produto.setPreco(dados.getPreco());
           produto.setEstoque(dados.getEstoque());
           produto.setCategoria(dados.getCategoria());

           Produto atualizado = repository.save(produto);

           return ResponseEntity.ok(atualizado);
          })
          .orElseGet(() -> ResponseEntity.notFound().build());
 }


 // método DELETE
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> excluir(@PathVariable Long id) {

  //se nn existir retorna erro
  if (!repository.existsById(id)) {
   return ResponseEntity.notFound().build();
  }

  repository.deleteById(id);

  return ResponseEntity.noContent().build();
 }

}
