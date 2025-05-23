-- Tabla Propietario
CREATE TABLE Propietario (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             nombre VARCHAR(100) NOT NULL,
                             direccion VARCHAR(200),
                             telefono VARCHAR(20)
);

-- Tabla Animal
CREATE TABLE Mascota (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        nombre VARCHAR(50) NOT NULL,
                        fechaNacimiento DATE NOT NULL,
                        raza VARCHAR(100) NOT NULL,
                        peso DECIMAL(5,2) NOT NULL,
                        tieneChip BOOLEAN NOT NULL,
                        urlFoto VARCHAR(800),
                        id_propietario INT NOT NULL,
                        FOREIGN KEY (id_propietario) REFERENCES Propietario(id) ON DELETE CASCADE
);