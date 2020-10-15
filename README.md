## Estoque de Peças

### Comentário:
- No programaPrincipal adotamos a escolha de utilzar um laço de repetição para que o usuário tivesse a oportunidade de escolher as opções de acordo com o menu, após a escolha do usuário o programa redireciona a comportamentos de inserção, deleção, seleção e criação. Fora do programa principal, existem métodos para o encurtamento do código, e que ajudam na interação de entrada de dados. Feito isso, criamos classes com atributos, construtores e getters/setters. Utilizamos ENUMS no código, pois haviam várias constantes, tanto no Banco de Dados como no Java.

## Classes:
#### Interface;
#### PecaDAO;
#### VendaDAO;
#### ProgramaPrincipal;
#### Enum;
#### Peca;

## Interagindo com o BD:
#### POJO;
#### DAO;
#### CONNECTION FACTORY;

## Banco De Dados - MYSQL
### Comandos utilizados:
- CREATE
- INSERT
- SELECT
- UPDATE
- DELETE
- WHERE

## Modelagem:
- Tabela
- Classes

## Organização: 
- Trello

### Endpoints Peça:
- Cadastrar uma nova peça;
- Consultar uma peça pelo seu código de barras;
- Listar todas as peças em estoque;
- Listar todas as peças começadas com o nome começado por um determinado texto(ex: todas as peças com o nome começado pela letra m);
- Listar todas as peças para um determinado modelo de carro (o carro deverá ser lido);
- Listar todas as peças de uma determinada categoria;
- Remover uma peça do estoque;
- Voltar para o menu principal;

### Endpoints Vendas:
- Realizar uma venda informando a quantidade e o código de barras de uma peça;
- Aqui você deverá criar uma estratégia para validar se é possível vender quantidade de peças informadas (de acordo com a quantidade em estoque) e também, caso a venda se concretiza você deverá armazenar o valor da venda em memória (em uma variável). Lembre-se de que o preço de venda deverá ser multiplicado pela quantidade pra obter esse valor.
- Extrair o relatório de vendas do dia
- Aqui, um arquivo deverá ser criado com uma listagem de todas as peças (identificadas pelo código de barras e o nome) vendidas no dia (considere o dia uma execução do programa, esses dados não deverão ser persistidos em um banco, somente a quantidade de peças em estoque será alterada à cada compra) e no final o total de faturamento (soma das vendas do dia).
- Voltar para o menu principal.

### Colaboradores: 
#### Anderson Oliveira Cancio
#### Carlos Henrique F. dos Santos
#### Cristiano Soares da Silva
