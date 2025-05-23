package com.oscar.mascotasonline.repository;

import com.oscar.mascotasonline.model.Mascota;
import com.oscar.mascotasonline.model.Propietario;
import com.oscar.mascotasonline.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
    List<Mascota> findMascotaByRaza(Raza raza);

    @Query("SELECT m FROM Mascota m ORDER BY m.fechaNacimiento DESC LIMIT :n")
    List<Mascota> findTopNMascotasMasJovenes(@Param("n") int n);

    List<Mascota> findMascotasByPropietario(Propietario propietario);
}
