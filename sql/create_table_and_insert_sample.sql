CREATE DATABASE IF NOT EXISTS player_evaluation;
USE player_evaluation;

CREATE TABLE indexer (
                         index_id INT(11) AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(64) NOT NULL,
                         valueMin FLOAT NOT NULL,
                         valueMax FLOAT NOT NULL
);

CREATE TABLE player (
                        player_id INT(11) AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(64) NOT NULL,
                        full_name VARCHAR(128) NOT NULL,
                        age VARCHAR(10) NOT NULL,
                        index_id INT(11) NOT NULL,
                        FOREIGN KEY (index_id) REFERENCES indexer(index_id)
);

CREATE TABLE player_index (
                              id INT(11) AUTO_INCREMENT PRIMARY KEY,
                              player_id INT(11) NOT NULL,
                              index_id INT(11) NOT NULL,
                              value FLOAT NOT NULL,
                              FOREIGN KEY (player_id) REFERENCES player(player_id),
                              FOREIGN KEY (index_id) REFERENCES indexer(index_id)
);player

INSERT INTO indexer (name, valueMin, valueMax) VALUES ('speed',10,100);
INSERT INTO indexer (name, valueMin, valueMax) VALUES ('strength',0,10);
INSERT INTO indexer (name, valueMin, valueMax) VALUES ('accurate',0,1);
