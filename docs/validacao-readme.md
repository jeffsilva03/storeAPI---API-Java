# Validação da documentação

Verificação realizada em 30/10/2026, em um clone novo do repositório, no Windows PowerShell, com Java 21.0.10 e Apache Maven 3.9.9. O Maven foi extraído em uma pasta de ferramentas temporária e chamado por seu executável; os comandos do README pressupõem Maven no PATH.

## Build e execução

- `mvn clean package`: BUILD SUCCESS.
- `mvn spring-boot:run`: aplicação iniciada na porta 8080.
- Não há classes de teste no repositório; o build bem-sucedido não representa cobertura automatizada.
- Os comandos Linux/macOS não foram executados neste ambiente.

## Requisições HTTP verificadas

| Operação | Resultado observado |
| :-- | :-- |
| GET `/api/produtos` em banco novo | 200 e `[]` |
| POST com nome Teclado, descrição Teclado USB, preço 149.90, estoque 10 e categoria Perifericos | 201; `Location: /api/produtos/1`; JSON com ID gerado |
| GET `/api/produtos/1` | 200 |
| GET `/api/produtos/busca?nome=TECL` | 200 e produto Teclado na lista |
| PUT `/api/produtos/1` com preço 129.90 e estoque 8 | 200 e valores atualizados |
| POST com nome em branco, preço zero, estoque negativo e categoria vazia | 400 |
| DELETE `/api/produtos/1` | 204 |
| GET, PUT e DELETE para ID inexistente | 404 |
| GET `/h2-console/` | 200 |

## Apresentação

Os banners são SVGs próprios, com versões clara e escura e animações de digitação, status e brilho. As imagens da seção Demonstração são ilustrações de uma requisição e resposta conferidas localmente, identificadas como exemplos; não representam uma interface gráfica ou um deploy público.

O README anterior está preservado em [README-original.md](./README-original.md). A documentação nova reflete a implementação atual de PUT, DELETE e validação no POST.
