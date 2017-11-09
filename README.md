# ExemploRest (Projeto feito no Eclipse MARs)

Exemplo de Jersey 2 + Jackson + Hibernate 4 RESTFull WebServices utilizando MAVEN
Linha adicionada em 09/11/2017

Suporta os verbos: get, post, put e delete, nos formatos de FORMLÁRIO: POST e PUT e URL para PUT e DELETE

Para os testes do WEBSERVICES use: 

http://127.0.0.1:8080/exemplorest/rest/usuario (PUT e POST) ID=0 faz insert, qualquer outro ID faz update
http://127.0.0.1:8080/exemplorest/rest/usuario/todos (GET)
http://127.0.0.1:8080/exemplorest/rest/usuario/deletar/iddoregistro (DELETE) substituir iddoregistro pelo id desejado

Os campos são:

id
nome
idade
email
senha

Não foi implementada segurança. O projeto tem como padrão Java 1.8. O projeto foi criado com o Maven Archetype para WebApp.
Este projeto tem como objetivo demosntrar somente os Webservices e não utiliza Spring, porem pode-se acrescentar o Spring caso necessário.


