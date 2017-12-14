# ![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../ReadMe.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)


## WebService: Alterar Lançamento Conta Mensal

### Objetivo

Alteração de lançamentos cadastrados.

## Parâmetros de Entrada

**Exemplo** :

`curl -v -X PUT -H "Content-Type: application/json" -d '{"id":20,"descricaoLancamento":"Barzinho","data":"2017-12-12","valor":68.85,tipoLancamento":"OUTROS"}' http://localhost:8080/lancamento/api/alterar`

|   #   | Escopo | Atributo                       |   Tipo  | Obrig. | Descrição                                                    |
|:-----:|:------:|--------------------------------|:-------:|:------:|--------------------------------------------------------------|
|   1   |  Body  | Lancamento.id                  | Integer |    S   | Campo com o código de identificação do lançamento            |
|   2   |        | Lancamento.descricaoLancamento |  String |    S   | Campo com a descrição do Lancamento                          |
|   3   |        | Lancamento.data                |   Date  |    S   | Campo com a data ocorrida do Lancamento. Formato ano-mes-dia |
|   4   |        | Lancamento.valor               |  Double |    S   | Campo com o valor do Lancamento                              |
|   5   |        | Lancamento.tipoLancamento      |  String |    S   | Campo com o tipo de Lancamento                               |

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
