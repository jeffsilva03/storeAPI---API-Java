package br.edu.storeapi.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
public record ProdutoRequest(
 @NotBlank String nome,
 String descricao,
 @NotNull @DecimalMin("0.01") BigDecimal preco,
 @NotNull @Min(0) Integer estoque,
 @NotBlank String categoria
) {}

//arquivo para determinar quais as regraas do validation os dados enviados a API devem seguir