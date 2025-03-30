CREATE TABLE IF NOT EXISTS financial_health
(
    id
    INT
    PRIMARY
    KEY,
    description
    VARCHAR
(
    255
) NOT NULL
    );

-- Insertar los valores del enum 'FinancialHealth'
INSERT
IGNORE INTO financial_health (id, description) VALUES (1, 'Crítica');
INSERT
IGNORE INTO financial_health (id, description) VALUES (2, 'Pobre');
INSERT
IGNORE INTO financial_health (id, description) VALUES (3, 'Aceptable');
INSERT
IGNORE INTO financial_health (id, description) VALUES (4, 'Buena');
INSERT
IGNORE INTO financial_health (id, description) VALUES (5, 'Excelente');

CREATE TABLE IF NOT EXISTS goal_priority
(
    id
    INT
    PRIMARY
    KEY,
    description
    VARCHAR
(
    255
) NOT NULL
    );

-- Insertar los valores del enum 'GoalPriority'
INSERT
IGNORE INTO goal_priority (id, description) VALUES (1, 'Baja');
INSERT
IGNORE INTO goal_priority (id, description) VALUES (2, 'Media');
INSERT
IGNORE INTO goal_priority (id, description) VALUES (3, 'Alta');
INSERT
IGNORE INTO goal_priority (id, description) VALUES (4, 'Crítica');


CREATE TABLE IF NOT EXISTS goal_type
(
    id
    INT
    PRIMARY
    KEY,
    description
    VARCHAR
(
    255
) NOT NULL
    );

-- Insertar los valores del enum 'GoalType'
INSERT
IGNORE INTO goal_type (id, description) VALUES (1, 'Ahorro');
INSERT
IGNORE INTO goal_type (id, description) VALUES (2, 'Inversión');


CREATE TABLE IF NOT EXISTS month
(
    id
    INT
    PRIMARY
    KEY,
    description
    VARCHAR
(
    255
) NOT NULL
    );

-- Insertar los valores del enum 'Month'
INSERT
IGNORE INTO month (id, description) VALUES (1, 'Enero');
INSERT
IGNORE INTO month (id, description) VALUES (2, 'Febrero');
INSERT
IGNORE INTO month (id, description) VALUES (3, 'Marzo');
INSERT
IGNORE INTO month (id, description) VALUES (4, 'Abril');
INSERT
IGNORE INTO month (id, description) VALUES (5, 'Mayo');
INSERT
IGNORE INTO month (id, description) VALUES (6, 'Junio');
INSERT
IGNORE INTO month (id, description) VALUES (7, 'Julio');
INSERT
IGNORE INTO month (id, description) VALUES (8, 'Agosto');
INSERT
IGNORE INTO month (id, description) VALUES (9, 'Septiembre');
INSERT
IGNORE INTO month (id, description) VALUES (10, 'Octubre');
INSERT
IGNORE INTO month (id, description) VALUES (11, 'Noviembre');
INSERT
IGNORE INTO month (id, description) VALUES (12, 'Diciembre');

CREATE TABLE IF NOT EXISTS transaction_type
(
    id
    INT
    PRIMARY
    KEY,
    description
    VARCHAR
(
    255
) NOT NULL
    );

-- Insertar los valores del enum 'TransactionType'
INSERT
IGNORE INTO transaction_type (id, description) VALUES (1, 'Ingreso');
INSERT
IGNORE INTO transaction_type (id, description) VALUES (2, 'Gasto');