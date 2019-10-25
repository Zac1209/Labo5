-- Bcrypt https://www.browserling.com/tools/bcrypt
--https://en.wikipedia.org/wiki/Bcrypt
--Valeur par défaut 10
insert into COMPTES( username,fullname,password, role)
--Password Buster123
values
('buster@debian.org','Buster','$2a$10$9eLGH.l3NllHjt7JvsRlS..H2pTCXSUHK34h77.0K/KIHGwua354S', 'ADMIN');
insert into COMPTES( username,fullname,password, role)
--Password Stretch123
values
('stretch@debian.org','Stretch','$2a$10$m0Bu4eWMDjJ0jqGImmY.GencUnfkaHRh4YcDQ4MVS8RJDSVF1WH2i', 'MEMBRE');
insert into COMPTES( username,fullname,password, role)
--Password Wheezy123
values
('wheezy@debian.org','Wheezy','$2a$10$Lbfw7B28ezfYKyh3c7F/7eoXWIjkq7m2e5uONX3zz0wnbLex6edG', 'MEMBRE');
insert into COMPTES( username,fullname,password, role)
--Password Jessie123
values
('jessie@debian.org','Jessie','$2a$10$RlzhcoNOJ1tdLnfwMVixGOfQF5teAmaakEmkEhuc43.IrDM4BTUBG', 'MEMBRE');
--Password Sqeeze123
insert into COMPTES( username,fullname,password, role )
values
('sqeeze@debian.org','Sqeeze','$2a$10$medzhChewerGRVTCJwKuWeUpadsqgN.GgxJq3yUN5vX8Smhdrrv2W', 'ADMIN');
--Password a pour tests
insert into COMPTES( username,fullname,password, role )
values ('a','a','$2a$10$z296cTBbYr8ip9ZXZnzwkuO.tg66hefngF4BwewhPwhBSAr6OXzqi',
'MEMBRE');