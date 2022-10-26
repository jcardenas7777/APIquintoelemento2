INSERT IGNORE INTO rol(id, nombre_rol) VALUES(1, "Administrador"),
                                            (2, "Doctor"),
                                            (3, "Recepcion");


-- INSERT  INTO  usuario (id,id_Usuario,nombres,apellidos,tipo_Documento,documento,fecha_De_Nacimiento,
-- email,username,password,password_Encriptada,direccion,creado,id_rol) VALUES 
-- (1,"e7127c42-9c94-4e45-89b3-227f8db2a13d","Administrador","Administrador",
-- "CC","123",1996-11-17,"Administrador@Administrador.Administrador","admin","admin",
-- "$2a$10$TSss9z6IOaMrwV6Vks.nTusSYNx82RGK6cEwr9V9Fjr3rjURtXIUK","Administrador","123",2022-10-25,1);


INSERT IGNORE INTO usuario(id, apellidos, celular, direccion, documento, email, id_usuario, nombres, password, password_encriptada, tipo_documento,username, id_rol) VALUES (1,'Administrador','123','Administrador','123','Administrador@Administrador.Administrador','e7127c42-9c94-4e45-89b3-227f8db2a13d','Administrador','admin','$2a$10$TSss9z6IOaMrwV6Vks.nTusSYNx82RGK6cEwr9V9Fjr3rjURtXIUK','cc','admin',1)