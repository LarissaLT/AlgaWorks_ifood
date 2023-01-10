insert into cozinha (id, nome) values (1, 'Indiana');
insert into cozinha (id, nome) values (2, 'Japonesa');
insert into cozinha (id, nome) values (3, 'Tailandesa');

insert into restaurante (id, nome, taxa_frete, cozinha_id) values (1, 'Tuk Tuk Comida Indiana', 15, 1);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (2, 'Sushi da praça', 4.5, 2);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (3, 'Thai Gourmet', 10, 3);
insert into restaurante (id, nome, taxa_frete, cozinha_id) values (4, 'Thai Delivery', 9.50, 3);

insert into estado (id, nome) values (1, 'Rio de Janeiro');
insert into estado (id, nome) values (2, 'São Paulo');
insert into estado (id, nome) values (3, 'Minas Gerais');

insert into cidade (id, nome, estado_id) values (1, 'Paraty', 1);
insert into cidade (id, nome, estado_id) values (2, 'São Paulo', 2);
insert into cidade (id, nome, estado_id) values (3, 'Campinas', 2);
insert into cidade (id, nome, estado_id) values (4, 'Uberlândia', 3);
insert into cidade (id, nome, estado_id) values (5, 'Belo Horizonte', 3);