
alter table token_blacklist add COLUMN idUser integer;
alter table token_blacklist add constraint fk_tokens foreign key (idUser) references users;