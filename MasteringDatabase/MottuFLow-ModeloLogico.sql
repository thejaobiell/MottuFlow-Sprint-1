/*
                        MOTTU-FLOW
    João Gabriel Boaventura Marques e Silva | RM554874 | 2TDSB-2025
    Léo Motta Lima | RM557851 | 2TDSB-2025
    Lucas Leal das Chagas | RM551124 | 2TDSB-2025
*/


DROP TABLE funcionario CASCADE CONSTRAINTS;
DROP TABLE status CASCADE CONSTRAINTS;
DROP TABLE patio CASCADE CONSTRAINTS;
DROP TABLE moto CASCADE CONSTRAINTS;
DROP TABLE camera CASCADE CONSTRAINTS;
DROP TABLE aruco_tag CASCADE CONSTRAINTS;
DROP TABLE localidade CASCADE CONSTRAINTS;

CREATE TABLE funcionario (
    ID  INTEGER PRIMARY KEY,
    nome VARCHAR2(100 BYTE) NOT NULL,
    cpf VARCHAR2(14 BYTE) NOT NULL,
    cargo VARCHAR2(50 BYTE) NOT NULL,
    telefone VARCHAR2(20 BYTE) NOT NULL,
    usuario VARCHAR2(50 BYTE) NOT NULL,
    senha VARCHAR2(100 BYTE) NOT NULL
);

CREATE TABLE patio (
    id_patio INTEGER PRIMARY KEY,
    nome VARCHAR2(100 BYTE) NOT NULL,
    endereco VARCHAR2(200 BYTE) NOT NULL,
    capacidade_maxima INTEGER NOT NULL
);

CREATE TABLE moto (
    id_moto INTEGER PRIMARY KEY,
    placa VARCHAR2(10 BYTE) NOT NULL,
    modelo VARCHAR2(50 BYTE) NOT NULL,
    fabricante VARCHAR2(50 BYTE) NOT NULL,
    ano INTEGER NOT NULL,
    id_patio INTEGER NOT NULL,
    localizacao_atual VARCHAR2(100 BYTE) NOT NULL,
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio)
);

CREATE TABLE camera (
    id_camera INTEGER PRIMARY KEY,
    status_operacional VARCHAR2(20 BYTE) NOT NULL,
    localizacao_fisica VARCHAR2(255 BYTE) NOT NULL,
    id_patio INTEGER NOT NULL,
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio)
);

CREATE TABLE aruco_tag (
    id_tag INTEGER PRIMARY KEY,
    codigo VARCHAR2(50 BYTE) NOT NULL,
    id_moto INTEGER NOT NULL,
    status VARCHAR2(20 BYTE) NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto)
);

CREATE TABLE status (
    id_status INTEGER PRIMARY KEY,
    id_moto INTEGER NOT NULL,
    tipo_status VARCHAR2(50 BYTE) NOT NULL,
    descricao VARCHAR2(255 BYTE),
    data_status TIMESTAMP DEFAULT current_timestamp,
    id_funcionario INTEGER NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto),
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(ID)
);

CREATE TABLE localidade (
    id_localidade INTEGER PRIMARY KEY,
    data_hora TIMESTAMP NOT NULL,
    id_moto INTEGER NOT NULL,
    id_patio INTEGER NOT NULL,
    ponto_referencia VARCHAR2(100 BYTE) NOT NULL,
    id_camera INTEGER NOT NULL,
    FOREIGN KEY (id_moto) REFERENCES moto(id_moto),
    FOREIGN KEY (id_patio) REFERENCES patio(id_patio),
    FOREIGN KEY (id_camera) REFERENCES camera(id_camera)
);

INSERT INTO funcionario (ID, nome, cpf, cargo, telefone, usuario, senha) VALUES (1, 'Joao Silva', '12345678900', 'Gerente', '11999990001', 'joaosilva', 'senha123');
INSERT INTO funcionario (ID, nome, cpf, cargo, telefone, usuario, senha) VALUES (2, 'Maria Souza', '22345678900', 'Tecnico', '11999990002', 'mariasouza', 'senha123');
INSERT INTO funcionario (ID, nome, cpf, cargo, telefone, usuario, senha) VALUES (3, 'Carlos Lima', '32345678900', 'Analista', '11999990003', 'carloslima', 'senha123');
INSERT INTO funcionario (ID, nome, cpf, cargo, telefone, usuario, senha) VALUES (4, 'Ana Costa', '42345678900', 'Supervisor', '11999990004', 'anacosta', 'senha123');
INSERT INTO funcionario (ID, nome, cpf, cargo, telefone, usuario, senha) VALUES (5, 'Pedro Rocha', '52345678900', 'Motorista', '11999990005', 'pedrorocha', 'senha123');

INSERT INTO patio (id_patio, nome, endereco, capacidade_maxima) VALUES (1, 'Patio Central', 'Rua A 123', 50);
INSERT INTO patio (id_patio, nome, endereco, capacidade_maxima) VALUES (2, 'Patio Norte', 'Rua B 456', 30);
INSERT INTO patio (id_patio, nome, endereco, capacidade_maxima) VALUES (3, 'Patio Sul', 'Rua C 789', 40);
INSERT INTO patio (id_patio, nome, endereco, capacidade_maxima) VALUES (4, 'Patio Leste', 'Rua D 321', 20);
INSERT INTO patio (id_patio, nome, endereco, capacidade_maxima) VALUES (5, 'Patio Oeste', 'Rua E 654', 25);

INSERT INTO moto (id_moto, placa, modelo, fabricante, ano, id_patio, localizacao_atual) VALUES (1, 'ABC1234', 'CG150', 1, 2020, 1, 'Rua A');
INSERT INTO moto (id_moto, placa, modelo, fabricante, ano, id_patio, localizacao_atual) VALUES (2, 'DEF5678', 'Biz110', 2, 2021, 2, 'Rua B');
INSERT INTO moto (id_moto, placa, modelo, fabricante, ano, id_patio, localizacao_atual) VALUES (3, 'GHI9012', 'XRE300', 3, 2019, 3, 'Rua C');
INSERT INTO moto (id_moto, placa, modelo, fabricante, ano, id_patio, localizacao_atual) VALUES (4, 'JKL3456', 'PCX150', 4, 2022, 4, 'Rua D');
INSERT INTO moto (id_moto, placa, modelo, fabricante, ano, id_patio, localizacao_atual) VALUES (5, 'MNO7890', 'Fazer250', 5, 2023, 5, 'Rua E');

INSERT INTO camera (id_camera, status_operacional, localizacao_fisica, id_patio) VALUES (1, 'Operacional', 'Entrada Patio Central', 1);
INSERT INTO camera (id_camera, status_operacional, localizacao_fisica, id_patio) VALUES (2, 'Manutencao', 'Saida Patio Norte', 2);
INSERT INTO camera (id_camera, status_operacional, localizacao_fisica, id_patio) VALUES (3, 'Operacional', 'Corredor Patio Sul', 3);
INSERT INTO camera (id_camera, status_operacional, localizacao_fisica, id_patio) VALUES (4, 'Inoperante', 'Portao Patio Leste', 4);
INSERT INTO camera (id_camera, status_operacional, localizacao_fisica, id_patio) VALUES (5, 'Operacional', 'Garagem Patio Oeste', 5);

INSERT INTO aruco_tag (id_tag, codigo, id_moto, status) VALUES (1, 'TAG001', 1, 'Ativo');
INSERT INTO aruco_tag (id_tag, codigo, id_moto, status) VALUES (2, 'TAG002', 2, 'Ativo');
INSERT INTO aruco_tag (id_tag, codigo, id_moto, status) VALUES (3, 'TAG003', 3, 'Inativo');
INSERT INTO aruco_tag (id_tag, codigo, id_moto, status) VALUES (4, 'TAG004', 4, 'Ativo');
INSERT INTO aruco_tag (id_tag, codigo, id_moto, status) VALUES (5, 'TAG005', 5, 'Manutencao');

INSERT INTO status (id_status, id_moto, tipo_status, descricao, id_funcionario, data_status)VALUES (1, 1, 'Disponível', 'Moto pronta para uso e em boas condições.', 1, TIMESTAMP '2025-05-16 08:00:00');
INSERT INTO status (id_status, id_moto, tipo_status, descricao, id_funcionario, data_status)VALUES (2, 2, 'Inativo', 'Aguardando documentação.', 3, TIMESTAMP '2025-05-16 08:10:00');
INSERT INTO status (id_status, id_moto, tipo_status, descricao, id_funcionario, data_status)VALUES (3, 3, 'Manutenção', 'Substituição de corrente e revisão geral.', 2, TIMESTAMP '2025-05-16 08:20:00');
INSERT INTO status (id_status, id_moto, tipo_status, descricao, id_funcionario, data_status)VALUES (4, 4, 'Reservado', 'Reservada para cliente via aplicativo.', 4, TIMESTAMP '2025-05-16 08:30:00');
INSERT INTO status (id_status, id_moto, tipo_status, descricao, id_funcionario, data_status)VALUES (5, 5, 'Baixa por Boletim de Ocorrência', 'Moto furtada, boletim registrado.', 1, TIMESTAMP '2025-05-16 08:40:00');



INSERT INTO localidade (id_localidade, data_hora, id_moto, id_patio, ponto_referencia, id_camera) VALUES (1, TIMESTAMP '2025-05-16 08:00:00', 1, 1, 'Portao A', 1);
INSERT INTO localidade (id_localidade, data_hora, id_moto, id_patio, ponto_referencia, id_camera) VALUES (2, TIMESTAMP '2025-05-16 08:10:00', 2, 2, 'Portao B', 2);
INSERT INTO localidade (id_localidade, data_hora, id_moto, id_patio, ponto_referencia, id_camera) VALUES (3, TIMESTAMP '2025-05-16 08:20:00', 3, 3, 'Portao C', 3);
INSERT INTO localidade (id_localidade, data_hora, id_moto, id_patio, ponto_referencia, id_camera) VALUES (4, TIMESTAMP '2025-05-16 08:30:00', 4, 4, 'Portao D', 4);
INSERT INTO localidade (id_localidade, data_hora, id_moto, id_patio, ponto_referencia, id_camera) VALUES (5, TIMESTAMP '2025-05-16 08:40:00', 5, 5, 'Portao E', 5);

-----------------
/*1º PLSQL*/

SET SERVEROUTPUT ON
SET VERIFY OFF
DECLARE
    CURSOR c_status_por_funcionario IS SELECT F.nome AS nome_funcionario, COUNT(S.id_status) AS total_status, 
    COUNT(DISTINCT S.id_moto) AS motos_distintas FROM funcionario F 
    JOIN status S ON F.ID = S.id_funcionario GROUP BY F.nome ORDER BY total_status DESC;

    v_nome_funcionario funcionario.nome%TYPE;
    v_total_status NUMBER;
    v_motos_distintas NUMBER;
BEGIN
    dbms_output.put_line('--- STATUS POR FUNCIONÁRIO ---');
    FOR item IN c_status_por_funcionario LOOP
        dbms_output.put_line('Funcionário: ' || item.nome_funcionario ||' | Total de Status: ' || item.total_status || ' | Motos distintas: ' || item.motos_distintas);
    END LOOP;
END;
/

------------------
/*2º PLSQL*/

DECLARE
    CURSOR c_registro_moto_localizacao IS 
    SELECT P.nome AS nome_patio, C.localizacao_fisica AS camera_local, COUNT(L.id_localidade) AS total_registros FROM localidade L 
        JOIN patio P ON L.id_patio = P.id_patio 
        JOIN camera C ON L.id_camera = C.id_camera
        GROUP BY P.nome, C.localizacao_fisica
        ORDER BY P.nome, total_registros DESC;
BEGIN
    dbms_output.put_line('--- REGISTROS POR CÂMERA E PÁTIO ---');
    FOR item IN c_registro_moto_localizacao LOOP
        dbms_output.put_line('Pátio: ' || item.nome_patio ||' | Câmera: ' || item.camera_local ||
                             ' | Total Registros: ' || item.total_registros);
    END LOOP;
END;
/

----------------
/*3º PLSQL*/
SELECT 
    id_moto AS ID, modelo,nvl(LAG(localizacao_atual) OVER (ORDER BY id_moto), 'Vazio') AS localizacao_anterior,
    localizacao_atual AS localizacao_atual,
    nvl(LEAD(localizacao_atual) OVER (ORDER BY id_moto), 'Vazio') AS localizacao_proxima
FROM 
    moto
FETCH FIRST 5 ROWS ONLY;
/
