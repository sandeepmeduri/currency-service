DROP TABLE IF EXISTS tb_exchange;
 
CREATE TABLE tb_exchange (
  id SERIAL  PRIMARY KEY,
  currency_from TEXT  NOT NULL,
  currency_to TEXT NOT NULL,
  currency_conversion NUMERIC (5, 2) NOT NULL
);

insert into tb_exchange(currency_from,currency_to,currency_conversion)
values('USD','INR',65.0);
insert into tb_exchange(currency_from,currency_to,currency_conversion)
values('EUR','INR',75.0);
insert into tb_exchange(currency_from,currency_to,currency_conversion)
values('AUD','INR',25.0);