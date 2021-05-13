CREATE TABLE tasks
(
    id  serial PRIMARY KEY,
    name    VARCHAR(255)  NOT  NULL,
    description   VARCHAR(255)  NOT NULL,
    status    VARCHAR(255)  NOT  NULL,
    priority    VARCHAR(255)  NOT NULL,
);
