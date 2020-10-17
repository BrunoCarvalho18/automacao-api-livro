#language: pt
#encoding UTF-8

@geral
Funcionalidade: Criar Livro 
                Eu como usuario gostaria
                de cadastrar/criar um livro

@criarlivro @post
Esquema do Cenario: Criar um livro
       Dado que eu realize uma requisicao na API para criar o livro  "<userId>"  "<id>"  "<title>"  "<body>"
       Entao a API me retorna o status code 201
      
Exemplos:
|userId|id           |title                                    |body                                       |
|1     | 1           | Livro do Daniel e do Elton              |Aprendendo API com Daniel e Elton          |


