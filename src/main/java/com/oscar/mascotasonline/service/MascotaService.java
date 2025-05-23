package com.oscar.mascotasonline.service;

import com.oscar.mascotasonline.model.Mascota;
import com.oscar.mascotasonline.model.Propietario;
import com.oscar.mascotasonline.model.Raza;
import com.oscar.mascotasonline.repository.MascotaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public Optional<Mascota> getMascotaById(int id) {
        return mascotaRepository.findById(id);
    }

    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public List<Mascota> getAllMascotas(PageRequest pageRequest) {
        return mascotaRepository.findAll(pageRequest).getContent();
    }

    public List<Mascota> getMascotasByRaza(Raza raza) {
        return mascotaRepository.findMascotaByRaza(raza);
    }

    public List<Mascota> getTopNMascotasMasJovenes(int n) {
        return mascotaRepository.findTopNMascotasMasJovenes(n);
    }

    public List<Mascota> getMascotasByPropietario(Propietario propietario) {
        return mascotaRepository.findMascotasByPropietario(propietario);
    }
}
