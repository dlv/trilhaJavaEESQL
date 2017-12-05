# ![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)

[Home](../../../README.md) :: [Módulo Financeiro](../../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](../FU-Lancamento-Contas-Mensais.md) :: [WS-Incluir Lancamento Conta Mensal](WS-Incluir-Lancamento-Conta-Mensal.md)

## WebService: Incluir Lançamento Conta Mensal

### Objetivo

Inclusão de lançamentos de conta mensal

## Parâmetros de Entrada

| # | Escopo | Atributo | Tipo | Obrig. | Descrição |
|:-:|:------:|:---------|:----:|:------:|:----------|
| 1 | Body| Lancamento.descricaoLancamento | json | S | Campo com a descrição do Lancamento | 

## Retornos

### Retornos de Sucesso

| # | Atributo                          | Tipo | Descrição                         |
|:-:| --------------------------------- | :---------: | ------------------------------------ |
| 1 | Nome do Atributo (case sensitive) | Texto, Inteiro, Numérico(12,2)        | Descrição do campo e valores válidos |

### Retornos de Erro

| # | Status Http                         | Código | Validação                         | Mensagem |
|:-:| --------------------------------- | :---------: | ------------------------------------|----|
| 1 | Nome do Atributo (case sensitive) | Texto, Inteiro, Numérico(12,2)        | Descrição do campo e valores válidos | |

## Nível de Acesso

Utiliza política de segurança padrão do produto.

_[Sobre o Portal de Documentação](../../../About/About.md)_

![Rodape](../../../ReadMe-Anexos/Rodape.png)
