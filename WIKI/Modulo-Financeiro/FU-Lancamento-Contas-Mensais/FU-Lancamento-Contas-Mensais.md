# ![Cabecalho](../../ReadMe-Anexos/Cabecalho.png)

[Home](../../README.md) :: [Módulo Financeiro](../Modulo-Financeiro.md) :: [FU-Lançamento Contas Mensais](FU-Lancamento-Contas-Mensais/FU-Lancamento-Contas-Mensais.md)

## Funcionalidade: Lançamento Contas Mensais

### Descrição

Esta funcionalidade permite ao **Usuário** o lançamento de contas de despesas mensais com:

* Data
* Descrição
* Valor

As contas são organizadas por tipo de lançamento.

## Funcionalidades Impactadas

| Funcionalidade                                                                                        | Descrição                                      |
|-------------------------------------------------------------------------------------------------------|------------------------------------------------|
| [FU-Consulta Lançamentos](../FU-Consulta-Lancamentos/FU-Consulta-Lancamentos.md)                      | Consulta de Lançamento de Contas Mensais       |
| [FU-Conta Corrente](../FU-Conta-Corrente/FU-Conta-Corrente.md)                                        | Atualização de Totais de Conta Corrente        |
| [FU-Log Rastreamento Contas](../FU-Log-Rastreamento-Contas/FU-Log-Rastreamento-Contas.md)             | Log Rastreamento Lançamentos em Conta Corrente |
| [FU-Notificação Novo Lançamento](../FU-Notificacao-Novo-Lancamento/FU-Notificacao-Novo-Lancamento.md) | Notificacao Web Browser de Novo Lançamento     |

## Regras de Negócios

| Regra de Negócios                                                          | Descrição                                                      |
|----------------------------------------------------------------------------|----------------------------------------------------------------|
| [RN-Campos Contas Mensais](Regras-de-Negocios/RN-Campos-Contas-Mensais.md) | Campos e valores válidos para os lançamentos de contas mensais |
| [RN-Tipo de Lançamento](Regras-de-Negocios/RN-Tipo-de-Lancamento.md)       | Enumeração dos Tipos de Lançamento                             |

## Web Services

| Web Service                                                                              | Descrição                                      |
|------------------------------------------------------------------------------------------|------------------------------------------------|
| [WS-Incluir Lancamento Conta Mensal](Web-Services/WS-Incluir-Lancamento-Conta-Mensal.md) | Inclusão de novo Lançamento Conta Mensal       |
| [WS-Alterar Lancamento Conta Mensal](Web-Services/WS-Alterar-Lancamento-Conta-Mensal.md) | Alteração de Lançamento Conta Mensal existente |
| [WS-Excluir Lancamento Conta Mensal](Web-Services/WS-Excluir-Lancamento-Conta-Mensal.md) | Remoção de Lançamento Conta Mensal existente   |

## Estrutura de Classes

| Pacote                       | Classe                | Descrição                                                                          |
|------------------------------|-----------------------|------------------------------------------------------------------------------------|
| br.com.logic.trilha.resource | CL-LancamentoResource | Classe que disponibiliza os serviços para integração de outros sistemas            |
| br.com.logic.trilha.beans    | CL-LancamentoBean     | Classe responsável em realizar a comunicação entre o WebService e o Banco de Dados |
| br.com.logic.trilha.daos     | CL-LancamentoDAO      | Classe responsável em persistir as informações no Banco de Dados                   |

_Diagrama UML: [UML-Classes-Lancamento-Contas-Mensais.asta](FU-Lancamento-Contas-Mensais-Anexos/UML-Classes-Lancamento-Contas-Mensais.asta)_

## Estrutura de Entidades

| Operação | Banco/Schema   | Entidade            | Descrição                                               |
|:--------:|----------------|---------------------|---------------------------------------------------------|
|    ISU   | sistema/public | TB-LancamentoMensal | Despesas Mensais Lançadas                               |
|     S    | sistema/public | TB-TipoLancamento   | Normalização dos Tipo de Lançamento para Contas Mensais |

\* _Operações:_ (I)nsert, (S)elect, (U)pdate, (D)elete

_Diagrama DER: [DER-Lancamento-Contas-Mensais.asta](FU-Lancamento-Contas-Mensais-Anexos/DER-Lancamento-Contas-Mensais.asta)_

## Diagramas Técnicos Opcionais

**NOTA AO DESENVOLVEDOR:** Se o desenv entender como necessário, pode sem criados diagramas técnicos especificando algum comportamento ou característica da funcionaldiade

| Diagrama           | Descrição             |
|--------------------|-----------------------|
| Link-para-Diagrama | Descrição do diagrama |

## Cenários de Teste Manuais

**NOTA AO DESENVOLVEDOR:** No momento, este projeto não possui interfaces gráficas com interação entre atores e sistema. Sendo assim, ainda não possui cenários de teste manuais.

_[Sobre o Portal de Documentação](../../About/About.md)_


![Rodape](../../ReadMe-Anexos/Rodape.png)
