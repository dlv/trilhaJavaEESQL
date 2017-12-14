![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


# WebService: Excluir Lançamento Conta Mensal

### Objetivo

Remoção de Lançamento Conta Mensal existente.

## Parâmetros de Entrada

**Exemplo** :

`curl -v -X DELETE -H "Content-Type: application/json" -d '{"id":1}' http://localhost:8080/lancamento/api/excluir`

|   #   | Escopo | Atributo                       |   Tipo  | Obrig. | Descrição                                                    |
|:-----:|:------:|--------------------------------|:-------:|:------:|--------------------------------------------------------------|
|   1   |  Body  | Lancamento.id                  | Integer |    S   | Campo com o código de identificação do lançamento            |

## Retornos

### Retornos de Sucesso

|   #   | Atributo |  Tipo  | Descrição                                       |
|:-----:|:--------:|:------:|-------------------------------------------------|
|   1   |   Body   | String | Retona Status Code 200 do protocolo Status Http |

### Retornos de Erro

|   #   | Status Http | Código | Validação                                     | Mensagem              |
|:-----:|:-----------:|:------:|-----------------------------------------------|-----------------------|
|   1   |     406     |    -   | Objeto é nulo                                 | Parametro Inválido.   |
|   2   |     406     |    -   | Código do Lançamento menor ou igual a zero(0) | Parametro Id Inválido |

## Nível de Acesso

Utiliza política de segurança padrão do produto.

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
