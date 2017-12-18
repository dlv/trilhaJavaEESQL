![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[Home](../../../../README.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos.md) :: [WS-Pesquisar Lancamentos por Período](WS-Pesquisar-Lancamentos-Por-Periodo.md)


# WebService: Pesquisar Lancamentos por Período

## Objetivo

Pesquisa de lançamentos por período de tempo (dia/mês/ano)

**Exemplo:**
`http://localhost:8080/lancamento/api/periodo/13/12/2017`

## Parâmetros de Entrada

|   #   | Escopo | Atributo | Tipo    | Obrig. | Descrição                                  |
|:-----:|:------:|----------|---------|:------:|--------------------------------------------|
|   1   |  Body  | dia      | Integer |    S   | Campo que descrever o dia a ser pesquisado |
|   2   |  Body  | mes      | Integer |    S   | Campo que descrever o mês a ser pesquisado |
|   3   |  Body  | ano      | Integer |    S   | Campo que descrever o ano a ser pesquisado |

## Retornos

### Retornos de Sucesso

|   #   | Atributo |  Tipo | Descrição                                                                                                                                              |
|:-----:|:--------:|:-----:|--------------------------------------------------------------------------------------------------------------------------------------------------------|
|   1   |   Body   |  JSON | Retona Status Code 200 do protocolo Status Http e no corpo do documento HTML, retorna o json com lista de lançamentos encontrados pelo data informada. |

### Retornos de Erro

|   #   | Status Http | Código | Validação      | Mensagem        |
|:-----:|:-----------:|:------:|----------------|-----------------|
|   1   |     404     |    -   | Data Incorreta | Not Found       |
|   1   |     200     |    -   | Data Incorreta | JSON vazio `[]` |

## Nível de Acesso

Utiliza política de segurança padrão do produto.

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
