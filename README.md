
# Sistema de Gerenciamento de Produtos

Esta é uma aplicação Spring Boot para gerenciar uma lista de produtos, com funcionalidades CRUD (Create, Read, Update, Delete) e testes unitários para garantir a confiabilidade das operações. Cada produto tem os seguintes atributos: `ID`, `Nome`, `Descrição`, `Preço` e `Quantidade em Estoque`.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.3.35
- H2 Database (em memória)
- Spring Data JPA
- JUnit e Mockito (para testes unitários)
- Postman (para testes de API)

## Funcionalidades

- **Produto**: Criar, listar, atualizar e deletar produtos.
- **Testes Unitários**: Cobertura completa dos endpoints CRUD com cenários de sucesso e erro.

## Configuração e Execução da Aplicação

### Pré-requisitos

- Java 17 ou superior
- Maven

### Passo a Passo para Rodar a Aplicação

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/simplicioJoao/atividade16.git
   ```

2. **Compile e instale as dependências**:

   ```bash
   mvn clean install
   ```

3. **Inicie a aplicação**:

   ```bash
   mvn spring-boot:run
   ```

   A aplicação será executada no endereço: `http://localhost:8080`.

### Acessando o Console H2

1. No navegador, acesse: `http://localhost:8080/h2-console`.
2. Configure a conexão com os seguintes valores:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: `password`
3. Clique em **Connect** para visualizar e manipular os dados diretamente no banco.

## Utilização dos Endpoints

### 1. Criar um Novo Produto

- **URL**: `POST /produtos`
- **Body (JSON)**:
  ```json
  {
    "nome": "Produto Exemplo",
    "descricao": "Um ótimo produto",
    "preco": 29.99,
    "quantidadeEstoque": 15
  }
  ```

### 2. Listar Todos os Produtos

- **URL**: `GET /produtos`
- **Descrição**: Retorna a lista completa de produtos.

### 3. Buscar um Produto Específico

- **URL**: `GET /produtos/{id}`
- **Exemplo**: `GET /produtos/1`
- **Descrição**: Retorna os detalhes do produto com o ID especificado.

### 4. Atualizar um Produto

- **URL**: `PUT /produtos/{id}`
- **Exemplo**: `PUT /produtos/1`
- **Body (JSON)**:
  ```json
  {
    "nome": "Produto Atualizado",
    "descricao": "Descrição atualizada",
    "preco": 39.99,
    "quantidadeEstoque": 20
  }
  ```

### 5. Remover um Produto

- **URL**: `DELETE /produtos/{id}`
- **Exemplo**: `DELETE /produtos/1`
- **Descrição**: Remove o produto com o ID especificado.

## Testando a API no Postman

1. **Crie uma nova requisição** no Postman para cada endpoint.
2. Defina o método HTTP (POST, GET, PUT, DELETE) e a URL correspondente.
3. Para requisições `POST` e `PUT`, defina o corpo da requisição como JSON.
4. Envie as requisições e verifique as respostas.

## Executando Testes Unitários

1. **Execute os testes com o Maven**:

   ```bash
   mvn test
   ```

2. **Sobre os Testes**:
   - Os testes unitários cobrem os métodos CRUD para verificar a criação, atualização, recuperação e remoção de produtos.
   - Utilizamos **JUnit** para criação dos testes e **Mockito** para simulação de dados no repositório, garantindo que o comportamento da camada de serviço seja isolado.

## Exemplo de Teste Unitário

Abaixo, um exemplo de como um teste de criação de produto pode ser estruturado:

```java
@Test
public void testCriarProduto() {
    Produto produto = new Produto("Produto Teste", "Descrição do teste", 19.99, 5);
    when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

    Produto resultado = produtoService.criarProduto(produto);

    assertNotNull(resultado);
    assertEquals("Produto Teste", resultado.getNome());
    verify(produtoRepository, times(1)).save(produto);
}
```

## Observações Finais

Este projeto tem o objetivo de demonstrar o uso de Spring Boot para criar uma API RESTful com operações CRUD e a aplicação de testes unitários para garantir a integridade e confiabilidade do sistema.
