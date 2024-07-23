CREATE TABLE token_blacklist
(
    idToken         integer PRIMARY KEY,
    jti        VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    expires_at TIMESTAMP
);

CREATE SEQUENCE token_blacklist_SEQ START WITH 1 INCREMENT BY 1;
