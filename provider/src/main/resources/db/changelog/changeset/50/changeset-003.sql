CREATE TABLE ss.match_statuses(
  status_id INTEGER NOT NULL PRIMARY KEY,
  name VARCHAR(50)
);

INSERT INTO ss.match_statuses(status_id, name) VALUES
  (1, 'Not Started'),
  (2, 'In Progress'),
  (3, 'Paused'),
  (4, 'Cancelled'),
  (5, 'Finished');

CREATE SEQUENCE ss.matches_seq
  MINVALUE 1
  CYCLE;

CREATE TABLE ss.matches(
  match_id INTEGER NOT NULL PRIMARY KEY DEFAULT NEXTVAL('ss.matches_seq'),
  starts_at TIMESTAMP NOT NULL,
  duration_min INTEGER NULL,
  status INTEGER NOT NULL,
  CONSTRAINT match_status_fk
    FOREIGN KEY(status)
    REFERENCES ss.match_statuses(status_id)
);

CREATE TABLE ss.match_participants(
  match_id INTEGER NOT NULL,
  player_id INTEGER NOT NULL,
  is_host BOOLEAN NOT NULL, -- the way to determine player(s) from different sides and their order
  CONSTRAINT match_participant_pk
    PRIMARY KEY (match_id, player_id),
  CONSTRAINT match_participant_match_fk
    FOREIGN KEY(match_id)
    REFERENCES ss.matches(match_id),
  CONSTRAINT match_participant_player_fk
    FOREIGN KEY(player_id)
    REFERENCES ss.players(player_id)
);

CREATE TABLE ss.match_results(
  match_id INTEGER NOT NULL PRIMARY KEY,
  is_host_winner BOOLEAN NOT NULL,
  is_technical_defeat BOOLEAN NOT NULL,
  CONSTRAINT match_result_match_fk
    FOREIGN KEY(match_id)
    REFERENCES ss.matches(match_id)
);
