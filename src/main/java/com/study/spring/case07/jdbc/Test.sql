create table emp(
	eid int not null auto_increment, -- 主鍵	
	ename varchar(50), -- 員工名稱
	age int , -- 員工年齡
	createtime timestamp null default CURRENT_TIME,
	primary key (eid),
);

create table job(
	jid int not null auto_increment, -- 主鍵	
	jname varchar(50), -- 工作名稱
	eid int not null, -- 員工ID
	primary key (jid),
	foreign key(eid) references emp(eid) -- 外鍵關聯
);

-- 左關聯查詢 (給 simpleFlatMapper 使用 請參考 case07/TestReadEmpAndJob2)
select e.eid , e.ename , e.age, e.createtime ,
j.jid as job_jid ,j.jname as job_jname ,j.eid as job_eid from emp e left outer join job j on j.eid = e.eid