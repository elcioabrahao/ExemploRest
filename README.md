# ExemploRest (Projeto feito no Eclipse MARs)

Exemplo de Jersey 2 + Jackson + Hibernate 4 RESTFull WebServices utilizando MAVEN

Suporta os verbos: get, post, put e delete, nos formatos de FORMLARIO: POST e PUT e URL para PUT e DELETE

Para os testes do WEBSERVICES use: 

http://<<server>>:8080/exemplorest/rest/usuario (PUT e POST) ID=0 faz insert, qualquer outro ID faz update
http://<<server>>:8080/exemplorest/rest/usuario/todos (GET)
http://<<server>>:8080/exemplorest/rest/usuario/deletar/<<ID>> (DELETE)

Os campos são:

id
nome
idade
email
senha

Não foi implementada segurança. O projeto tem como padrão Java 1.8. O projeto foi criado com o Maven Archetye para WebApp.

