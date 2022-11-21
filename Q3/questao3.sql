--Criação de tabelas
CREATE TABLE CONTRATOS(
	id int primary key,
	valor_parcela int,
	parcelas int
);
CREATE TABLE PESSOAS(
	id int primary key,
	nome varchar(255),
	inadimplente bool,
	dt_completo date,
	contrato_id int,
	foreign key(contrato_id) references contratos(id)
);
CREATE TABLE PAGAMENTOS(	
	id int primary key,
	pessoa_id int,
	dt_pagamento date,
	foreign key (pessoa_id) references Pessoas(id)
);
--Inserção de dados 
---Tabela Contrato
INSERT INTO Contratos(id, valor_parcela, parcelas)
VALUES
	(1, 150, 100),
	(2, 300, 48),
	(3, 550, 24),
	(4, 1000, 12);
---Tabela Pessoas
INSERT INTO PESSOAS(id, nome, contrato_id, INADIMPLENTE, dt_completo)
VALUES
	(1, 'Cristian Ghyprievy', 2, true, null),
	(2, 'Joana Cabel', 1, true, null),
	(3, 'John Serial', 3, true, null),
	(4, 'Michael Seven', 2, false,'2021-09-20'::date);
---TABELA PAGAMENTOS
INSERT INTO PAGAMENTOS(id, pessoa_id, dt_pagamento)
VALUES
	(1, 4, '2021-09-01'::date),
	(2, 3, '2021-09-05'::date),
	(3, 1, '2021-09-19'::date),
	(4, 2, '2021-09-25'::date);

--Parte 1 da questão 3
---Selecionar o nome, dia do mês e valor da parcela para clientes que estão
---inadimplentes.
SELECT pessoa.nome as NOME, extract(day from pagamento.dt_pagamento) as DIA_MES, contrato.valor_parcela as VALOR_PARCELA
FROM PESSOAS pessoa JOIN CONTRATOS contrato on pessoa.contrato_id = contrato.id
	JOIN PAGAMENTOS pagamento on pessoa.id = pagamento.pessoa_id
WHERE pessoa.inadimplente = true
ORDER BY 1;

--Parte 2 da questão 3
---Selecionar o nome e valor total pago de clientes com pagamento completo.
SELECT pessoa.nome as NOME, (contrato.valor_parcela * contrato.parcelas) as VALOR_PARCELA
FROM PESSOAS pessoa JOIN CONTRATOS contrato on pessoa.contrato_id = contrato.id
WHERE pessoa.inadimplente = false
ORDER BY 1;





