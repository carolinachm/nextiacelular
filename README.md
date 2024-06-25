# NextiaCelular API

## Descrição
NextiaCelular é uma API de loja virtual desenvolvida em Java com Spring Boot e PostgreSQL. A API permite gerenciar clientes, categorias de produtos, produtos, promoções, estoques e endereços.

## Estrutura do Projeto
O projeto é dividido nas seguintes tabelas principais:

1. **Cliente**
   - Informações sobre os clientes da loja.
2. **Categoria**
   - Categorias dos produtos vendidos na loja.
3. **Produto**
   - Detalhes dos produtos disponíveis na loja.
4. **Promoção**
   - Informações sobre promoções e descontos aplicáveis aos produtos.
5. **Estoque**
   - Gerenciamento do estoque dos produtos.
6. **Endereço**
   - Endereços associados aos clientes.

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **PostgreSQL**

## Pré-requisitos
- Java 17 ou superior
- Spring Boot 2.5 ou superior
- PostgreSQL 13 ou superior

## Instalação
1. Clone o repositório:
    ```sh
    git clone https://github.com/seuusuario/nextiacelular.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd nextiacelular
    ```

3. Configure o banco de dados PostgreSQL no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/nextiacelular
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Execute o projeto:
    ```sh
    ./mvnw spring-boot:run
    ```

## Futuras Implementações
1. Api de pagamento

2. Testes Unitários

   Serão adicionados testes unitários para garantir a qualidade do código e a corretude das funcionalidades.

3. Testes Automatizados

   Serão implementados testes automatizados para verificar o funcionamento correto da API em diferentes cenários.

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (git checkout -b feature/nova-feature).
3. Commit suas mudanças (git commit -m 'Adiciona nova feature').
4. Envie para o branch (git push origin feature/nova-feature).
5. bra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.

