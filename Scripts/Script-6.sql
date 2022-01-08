create table if not exists wallet (
	wid integer not null auto_increment,
	wname varchar(50), -- 名稱
	money integer default 0,
	primary key (wid)
);