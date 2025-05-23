INSERT INTO Propietario (id, nombre, direccion, telefono) VALUES
                                                              (1, 'María López', 'Calle Sol 45, Madrid', '611223344'),
                                                              (2, 'Carlos Ruiz', 'Avenida Luz 12, Barcelona', '655667788'),
                                                              (3, 'Ana Torres', 'Plaza Mayor 3, Sevilla', NULL),
                                                              (4, 'Juan Méndez', 'Camino Real 78, Valencia', '644556677'),
                                                              (5, 'Laura Gómez', 'Calle Flor 33, Málaga', '622334455'),
                                                              (6, 'Pedro Sánchez', 'Avenida Mar 2, Santander', NULL);

INSERT INTO Mascota (id, nombre, fechaNacimiento, raza, peso, tieneChip, urlFoto, id_propietario) VALUES
                                                                                             (1, 'Max', '2020-05-15', 'Perro', 28.50, TRUE, 'https://content.nationalgeographic.com.es/medio/2024/06/11/espigas-perros-chalabala-2_2582898c_240611203111_800x800.jpg', 1),
                                                                                             (2, 'Thor', '2021-02-28', 'Perro', 32.00, FALSE, 'https://estaticosgn-cdn.deia.eus/clip/4ba1557b-5a6b-4321-8521-ba6aa7673018_16-9-discover-aspect-ratio_default_0.jpg', 1),
                                                                                             (3, 'Luna', '2019-11-10', 'Perro', 30.75, TRUE, 'https://www.hogarmania.com/archivos/202401/razas-de-perros-salvajes-xl-1280x720x80xX.jpg', 2),
                                                                                             (4, 'Misi', '2022-07-04', 'Gato', 12.30, TRUE, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8t5Qv9hoArKjwgA25zZgoNoKuhbVU2zc6-A&s', 2),
                                                                                             (5, 'Nala', '2023-01-12', 'Gato', 4.20, FALSE, 'https://s3.abcstatics.com/abc/www/multimedia/sociedad/2024/07/11/gato-RaZLibek03KjY2lBzGD2qEN-1200x840@diario_abc.jpg', 1),
                                                                                             (6, 'Rocky','2022-03-10', 'Perro', 18.00, TRUE, 'https://www.srperro.com/media/post/eac45040-030c-42b3-a027-7ee1a563bd5a.600x429.jpeg.webp', 4),
                                                                                             (7, 'Cleo', '2020-08-22', 'Gato', 5.10, FALSE, 'https://static.nationalgeographic.es/files/styles/image_3200/public/nationalgeographic_1468962.jpg?w=1900&h=1400', 4),
                                                                                             (8, 'Paco', '2021-04-05', 'Loro', 0.35, FALSE, 'https://www.adiosmascota.es/wp-content/uploads/2022/05/Alimentacion_correcta_de_un_loro.jpg', 5),
                                                                                             (9, 'Algodón', '2023-05-20', 'Conejo', 2.10, TRUE, 'https://static.maskokotas.com/blog/wp-content/uploads/2020/12/hare-4375952_1920-1.jpg', 5),
                                                                                             (10, 'Toby', '2018-12-15', 'Perro', 22.50, TRUE, 'https://www.hola.com/horizon/landscape/9922c2fd3797-consejos-mejorar-calidad-vida-perro-anciano-t.jpg', 5),
                                                                                             (11, 'Misty','2022-09-30', 'Gato', 4.80, TRUE, 'https://hospitalveterinariodonostia.com/wp-content/uploads/2020/10/gatos.png', 6),
                                                                                             (12, 'Speedy', '2017-07-07', 'Tortuga', 1.20, FALSE, 'https://upload.wikimedia.org/wikipedia/commons/e/e7/Chelonoidis_chilensis_en_un_fondo_blanco.jpg', 6),
                                                                                             (13, 'Rex','2023-01-05', 'Perro', 8.90, FALSE, 'https://s10.s3c.es/imag/_v0/4629x2526/3/4/2/chihuahua-perro-ladrando-istock.jpg', 3),
                                                                                             (14, 'Simba','2021-11-11', 'Gato', 4.50, TRUE, 'https://images.ctfassets.net/denf86kkcx7r/4IPlg4Qazd4sFRuCUHIJ1T/f6c71da7eec727babcd554d843a528b8/gatocomuneuropeo-97', 1),
                                                                                             (15, 'Kira','2020-10-10', 'Perro', 24.00, TRUE, 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Golden_Retriever_9-year_old.jpg', 2);