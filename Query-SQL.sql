select * from comentarios;

select * from usuarios;

select * from posts;

select * from comentarios where post=4;

delete from comentarios where id=9;

select * from usuarios;

select * from comentarios c where post=2;

select * from comentarios c where post=2 ORDER BY c.id desc LIMIT 3;