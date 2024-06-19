# Rotas

## Clientes

| Método HTTP | Rota            | Função                     | Necessita autenticação |
|-------------|-----------------|----------------------------|------------------------|
| GET         | /cliente/{id}   | Localiza um cliente        | Sim                    |
| GET         | /cliente        | Pesquisa todos os clientes | Sim                    |
| POST        | /cliente        | Insere um cliente          | Não                    |
| DELETE      | /cliente/{id}   | Deleta um cliente          | Sim                    |

## Compras

| Método HTTP | Rota                      | Função                                | Necessita autenticação |
|-------------|---------------------------|---------------------------------------|------------------------|
| GET         | /compra/{id}              | Localiza uma compra                   | Sim                    |
| GET         | /compra                   | Pesquisa todas as compras             | Sim                    |
| GET         | /compra/cliente/{idcliente} | Pesquisa todas as compras de um cliente | Sim                    |
| POST        | /compra                   | Insere uma compra                     | Sim                    |
| DELETE      | /compra/{id}              | Deleta uma compra                     | Sim                    |

## Endereços

| Método HTTP | Rota                        | Função                                | Necessita autenticação |
|-------------|-----------------------------|---------------------------------------|------------------------|
| GET         | /endereco/{id}              | Localiza um endereço                  | Sim                    |
| GET         | /endereco                   | Pesquisa todos os endereços           | Sim                    |
| GET         | /endereco/cliente/{idcliente} | Pesquisa todos os endereços de um cliente | Sim                    |
| POST        | /endereco                   | Insere um endereço                    | Sim                    |
| DELETE      | /endereco/{id}              | Deleta um endereço                    | Sim                    |

## Itens de Compra

| Método HTTP | Rota                       | Função                                | Necessita autenticação |
|-------------|----------------------------|---------------------------------------|------------------------|
| GET         | /itemcompra/{idcompra}     | Pesquisa todos os itens de uma compra | Sim                    |
| POST        | /itemcompra                | Insere um item de uma compra          | Sim                    |
| DELETE      | /itemcompra/{id}           | Deleta um item de uma compra          | Sim                    |

## Produtos

| Método HTTP | Rota            | Função                     | Necessita autenticação |
|-------------|-----------------|----------------------------|------------------------|
| GET         | /produto/{id}   | Localiza um produto        | Não                    |
| GET         | /produto        | Pesquisa todos os produtos | Não                    |
| POST        | /produto        | Insere um produto          | Sim                    |
| DELETE      | /produto/{id}   | Deleta um produto          | Sim                    |

## Usuários

| Método HTTP | Rota            | Função                                | Necessita autenticação |
|-------------|-----------------|---------------------------------------|------------------------|
| POST        | /usuario/login  | Recebe um token para acesso da API    | Não                    |

## Bugs
Com a implementação da validação do token, as validações foram perdidas

## Cassio
Implementação da base da API

## Andrew
Implementação das validações

## Gabriel
Implementação do token

