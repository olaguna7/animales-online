package com.oscar.mascotasonline.service;

import com.oscar.mascotasonline.model.Mascota;
import com.oscar.mascotasonline.model.Propietario;
import com.oscar.mascotasonline.repository.PropietarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropietarioService {

    private final PropietarioRepository propietarioRepository;

    public PropietarioService(PropietarioRepository propietarioRepository) {
        this.propietarioRepository = propietarioRepository;
    }

    public Optional<Propietario> getPropietarioById(int id) {
        return propietarioRepository.findById(id);
    }

}
