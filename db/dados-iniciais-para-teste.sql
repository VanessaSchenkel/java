--------------------------------------------------------
--  Arquivo criado - Segunda-feira-Novembro-11-2019   
--------------------------------------------------------
REM INSERTING into REDESOCIAL.AMIZADE
SET DEFINE OFF;
Insert into REDESOCIAL.AMIZADE (ID,ID_SOLICITANTE,ID_SOLICITADO,ACEITADO,DATA_AMIZADE) values ('21','2','1','1',to_date('10/11/19','DD/MM/RR'));
Insert into REDESOCIAL.AMIZADE (ID,ID_SOLICITANTE,ID_SOLICITADO,ACEITADO,DATA_AMIZADE) values ('22','21','2','1',to_date('10/11/19','DD/MM/RR'));
REM INSERTING into REDESOCIAL.COMENTARIO
SET DEFINE OFF;
Insert into REDESOCIAL.COMENTARIO (ID,ID_USUARIO,ID_POST,TEXTO,DATA) values ('41','2','1','Mais um',to_date('10/11/19','DD/MM/RR'));
Insert into REDESOCIAL.COMENTARIO (ID,ID_USUARIO,ID_POST,TEXTO,DATA) values ('1','2','1','uiasih',to_date('10/11/19','DD/MM/RR'));
Insert into REDESOCIAL.COMENTARIO (ID,ID_USUARIO,ID_POST,TEXTO,DATA) values ('21','2','2','comentario',to_date('10/11/19','DD/MM/RR'));
REM INSERTING into REDESOCIAL.CURTIDA
SET DEFINE OFF;
Insert into REDESOCIAL.CURTIDA (ID,ID_USUARIO_CURTIDOR,ID_POSTAGEM,DATA) values ('41','21','22',to_date('10/11/19','DD/MM/RR'));
Insert into REDESOCIAL.CURTIDA (ID,ID_USUARIO_CURTIDOR,ID_POSTAGEM,DATA) values ('42','2','3',to_date('10/11/19','DD/MM/RR'));
REM INSERTING into REDESOCIAL.POSTAGEM
SET DEFINE OFF;
Insert into REDESOCIAL.POSTAGEM (ID,ID_USUARIO,DATA,NUMERO_CURTIDAS,TEXTO,FOTO,PRIVADO) values ('21','21',to_date('10/11/19','DD/MM/RR'),'0','Passando muito frio aqui...hehe','https://www.queroviajarmais.com/wp-content/uploads/2018/09/inverno-na-suica.jpg','1');
Insert into REDESOCIAL.POSTAGEM (ID,ID_USUARIO,DATA,NUMERO_CURTIDAS,TEXTO,FOTO,PRIVADO) values ('2','2',to_date('09/11/19','DD/MM/RR'),'0','Vou matar o javascripto','https://www.freecodecamp.org/news/content/images/2019/07/this-is-javascript.jpeg','0');
Insert into REDESOCIAL.POSTAGEM (ID,ID_USUARIO,DATA,NUMERO_CURTIDAS,TEXTO,FOTO,PRIVADO) values ('1','2',to_date('09/11/19','DD/MM/RR'),'0','Aproveitando no Peru','https://images.unsplash.com/photo-1568805647702-3d8b49681088?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=634&q=80','0');
Insert into REDESOCIAL.POSTAGEM (ID,ID_USUARIO,DATA,NUMERO_CURTIDAS,TEXTO,FOTO,PRIVADO) values ('3','1',to_date('10/11/19','DD/MM/RR'),'1','olha eu','https://static.boredpanda.com/blog/wp-content/uploads/2014/02/funny-wet-cats-coverimage.jpg','0');
Insert into REDESOCIAL.POSTAGEM (ID,ID_USUARIO,DATA,NUMERO_CURTIDAS,TEXTO,FOTO,PRIVADO) values ('22','21',to_date('10/11/19','DD/MM/RR'),'1','Olha agora minha vista ','https://images.unsplash.com/photo-1518803777327-5a904af70f7c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80','0');
REM INSERTING into REDESOCIAL.USUARIO
SET DEFINE OFF;
Insert into REDESOCIAL.USUARIO (ID,NOME_COMPLETO,EMAIL,APELIDO,DATA_NASCIMENTO,SENHA,IMAGEM_PERFIL,PAIS_ORIGEM,PAIS_ATUAL,ATIVO) values ('21','Pedro Luis','lu@lu.com','Lu',to_date('12/12/00','DD/MM/RR'),'$2a$10$.mvAsrSpfbNPbP3c/LeKI.XqRwXp/e2ckyTMl1uh3rzBZUtLkUWRW','https://randomuser.me/api/portraits/men/23.jpg','Alemanha','Suíça','1');
Insert into REDESOCIAL.USUARIO (ID,NOME_COMPLETO,EMAIL,APELIDO,DATA_NASCIMENTO,SENHA,IMAGEM_PERFIL,PAIS_ORIGEM,PAIS_ATUAL,ATIVO) values ('1','Jeferson Campos','jeferson.nobre@gmail.com','Jef',to_date('12/07/80','DD/MM/RR'),'$2a$10$GI4RLnakQTaIQz205M/X4OmduUDqu/BaN5xD2j547tfx9bf8PBb2e','https://randomuser.me/api/portraits/men/54.jpg','Espanha','Brasil','1');
Insert into REDESOCIAL.USUARIO (ID,NOME_COMPLETO,EMAIL,APELIDO,DATA_NASCIMENTO,SENHA,IMAGEM_PERFIL,PAIS_ORIGEM,PAIS_ATUAL,ATIVO) values ('2','Vanessa Schramm Schenkel da Silva','v.s.schenkel@gmail.com','Vanessinha',to_date('29/04/93','DD/MM/RR'),'$2a$10$pTAFd9cIoC0/YJdVRhwE7e.jt3xYO9h2LYwKQVbvNx1ZX4wZ2NQvi','https://images-na.ssl-images-amazon.com/images/I/71FcdrSeKlL._SL1001_.jpg','Russia','Brasil','1');
