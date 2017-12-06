# ![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)

[Home](../../../README.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)

## WebService: Incluir Lançamento Conta Mensal

### Objetivo

Inclusão de lançamentos de conta mensal

## Parâmetros de Entrada

| # | Escopo | Atributo | Tipo | Obrig. | Descrição |
|:-:|:------:|:---------|:----:|:------:|:----------|
| 1 | Body| Lancamento.descricaoLancamento | String | S | Campo com a descrição do Lancamento |
| 2 | | Lancamento.data | Date | S | Campo com a data ocorrida do Lancamento. Formato ano-mes-dia |
| 3 | | Lancamento.valor | Double | S | Campo com o valor do Lancamento |
| 4 | | Lancamento.tipoLancamento | String | S | Campo com o tipo de Lancamento |

## Retornos

### Retornos de Sucesso

| # | Atributo                          | Tipo | Descrição                         |
|:-:| --------------------------------- | :---------: | ------------------------------------ |
| 1 | Body | String        | Descrição da URI gerada do novo lançamento incluido |

### Retornos de Erro

| # | Status Http                         | Código | Validação                         | Mensagem |
|:-:| --------------------------------- | :---------: | ------------------------------------|----|
| 1 | 406 | -        | Objeto é nulo | Lancamento inválido. |
| 2 | 406 | -        | Data nula ou vazia | Data de Lancamento inválida. |
| 3 | 406 | -        | Descrição nula ou vazia | Descrição do Lancamento inválido. |
| 4 | 406 | -        | Valor nulo ou menor que zero(0) | Valor de Lancamento inválido. |

## Nível de Acesso

Utiliza política de segurança padrão do produto.

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
