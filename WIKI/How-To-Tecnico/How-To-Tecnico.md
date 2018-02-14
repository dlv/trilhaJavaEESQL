![Cabecalho](../ReadMe-Anexos/Cabecalho.png)

[Home](../ReadMe.md) :: [How-to Técnico](How-To-Tecnico.md)


# How-To Técnico

**NOTA AO DESENVOLVEDOR:** Adicione aqui qualquer procedimento que precise documentar, como instalação e configuração de ambiente, por exemplo.

| Procedimento                                                                     | Descrição                                 |
|----------------------------------------------------------------------------------|-------------------------------------------|
| [Intruções Trilha JEE-SQL](Intrucoes-Trilha-JEE-SQL/Intrucoes-Trilha-JEE-SQL.md) | Instruções para realização dos exercícios |


Executando a aplicação:
1. Para rodar com teste unitário execute: "mvn wildfly-swarm:run" diretorio da aplicação.
2. Para rodar sem teste unitário execute: "mvn clean install wildfly-swarm:run -DskipTests=true".
3. Para rodar com debug "mvn clean install wildfly-swarm:run -DskipTests=true -Dswarm.debug.port=8787".

_[Sobre o Portal de Documentação](../About/About.md)_


![Rodape](../ReadMe-Anexos/Rodape.png)
