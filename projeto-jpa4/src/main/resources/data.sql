insert into pais
(id, nome)
values
(null, 'Itália'),
(null, 'EUA'),
(null, 'Japão'),
(null, 'Coreia');

insert into fabricante
(id, nome, pais_origem_id)
values
(null, 'Fiat', 1),
(null, 'GM', 2),
(null, 'Honda', 3),
(null, 'Hyndai', 4);

insert into carro
(id, modelo, potencia, fabricante_id)
values
(null, 'Palio', 1.0, 1),
(null, 'Uno', 1.2, 1),
(null, 'Onix', 1.5, 2),
(null, 'Fit', 1.8, 3),
(null, 'City', 2.0, 3),
(null, 'HB20', 1.4, 4);