# StoreAPI - codigo inicial do laboratorio

Requisitos: Java 21, Maven e IDE com suporte ao Lombok.

Execute `mvn spring-boot:run` e acesse `http://localhost:8080/api/produtos`.
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:storedb`, usuario `sa`, senha vazia).

Ja implementados: entidade Produto, repository, GET lista, GET por ID, POST basico, busca por nome e DTO ProdutoRequest.

Tarefas dos alunos: implementar PUT e DELETE, migrar POST para @Valid ProdutoRequest, testar status HTTP e responder as questoes do roteiro.

Observacao: o POST inicial recebe Entity diretamente para demonstrar a evolucao ate DTO/validacao. Banco H2 em memoria reinicia a cada execucao.
