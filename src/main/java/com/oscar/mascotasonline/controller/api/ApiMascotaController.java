package com.oscar.mascotasonline.controller.api;

import com.oscar.mascotasonline.dto.MascotaDTO;
import com.oscar.mascotasonline.dto.PropietarioDTO;
import com.oscar.mascotasonline.model.Mascota;
import com.oscar.mascotasonline.model.Propietario;
import com.oscar.mascotasonline.model.Raza;
import com.oscar.mascotasonline.service.MascotaService;
import com.oscar.mascotasonline.service.PropietarioService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin("*")
public class ApiMascotaController {

    private final MascotaService mascotaService;
    private final PropietarioService propietarioService;

    public ApiMascotaController(MascotaService mascotaService, PropietarioService propietarioService) {
        this.mascotaService = mascotaService;
        this.propietarioService = propietarioService;
    }

    // Ejercicio 1: Mostrar mascota por ID
    @GetMapping("/mascotas/{id}")
    public ResponseEntity<MascotaDTO> showMascotaById(@PathVariable("id") int id) {
        Optional<Mascota> optMascota = mascotaService.getMascotaById(id);
        if (optMascota.isPresent()) {
            MascotaDTO mascotaDTO = convertMascotaToDto(optMascota.get());
            return new ResponseEntity<>(mascotaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // Ejercicio 2: Subir una mascota
    @PostMapping(path = "/mascotas", consumes = "application/json")
    public ResponseEntity<Mascota> saveMascota(@RequestBody Mascota mascota) {
        Mascota savedMascota = mascotaService.save(mascota);
        if (savedMascota != null) {
            return new ResponseEntity<>(savedMascota, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // Ejercicio 3: Listar todas las mascotas
    @GetMapping("/mascotas")
    public ResponseEntity<List<MascotaDTO>> showAllMascotas() {
        List<Mascota> mascotas = mascotaService.getAllMascotas();
        List<MascotaDTO> mascotasDTO = listMascotasToDTO(mascotas);
        return new ResponseEntity<>(mascotasDTO, HttpStatus.OK);
    }

    // Ejercicio 4: Listar por raza
    @GetMapping("/mascotas/raza/{raza}")
    public ResponseEntity<List<MascotaDTO>> showMascotasByRaza(@PathVariable("raza") String raza) {
        Raza razaMascota = Raza.valueOf(raza);
        List<Mascota> mascotas = mascotaService.getMascotasByRaza(razaMascota);
        List<MascotaDTO> mascotasDTO = listMascotasToDTO(mascotas);
        return new ResponseEntity<>(mascotasDTO, HttpStatus.OK);
    }

    // Ejercicio 5: Listar las 20 mascotas más jóvenes (hecho para mostrar las N mascotas más jovenes)
    @GetMapping("mascotas/jovenes/{limit}")
    private List<MascotaDTO> showNMascotasByAgeAscending(@PathVariable int limit) {
        List<Mascota> mascotas = mascotaService.getTopNMascotasMasJovenes(limit);
        return listMascotasToDTO(mascotas);
    }

    // Ejercicio 6: Mostrar todas las mascotas en páginas de a 5
    @GetMapping("/mascotas/paged/{page}")
    public ResponseEntity<Iterable<MascotaDTO>> getAllMascotasPaged(@PathVariable int page) {
        PageRequest pageRequest = PageRequest.of(page, 5);
        List<Mascota> mascotas = mascotaService.getAllMascotas(pageRequest);
        return new ResponseEntity<>(listMascotasToDTO(mascotas), HttpStatus.OK);
    }

    // Ejercicio 7: Borrar una mascota
    @DeleteMapping("mascotas/{id}")
    public ResponseEntity<MascotaDTO> deleteMascota(@PathVariable int id) {
        Optional<Mascota> optMascota = mascotaService.getMascotaById(id);
        if (optMascota.isPresent()) {
            MascotaDTO mascota = convertMascotaToDto(optMascota.get());
            return new ResponseEntity<>(mascota, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Ejercicio 8: Mostrar todas las mascotas de un propietario
    @GetMapping("propietario/{id}")
    public ResponseEntity<List<MascotaDTO>> showMascotasPropietario(@PathVariable int id) {
        Optional<Propietario> propietario = propietarioService.getPropietarioById(id);
        if (propietario.isPresent()) {
            List<Mascota> mascotas = mascotaService.getMascotasByPropietario(propietario.get());
            return new ResponseEntity<>(listMascotasToDTO(mascotas), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Ejercicio 9: Mostrar quien es el propietario de una mascota
    @GetMapping("/mascotas/{id}/propietario")
    public ResponseEntity<PropietarioDTO> showPropietarioByMascota(@PathVariable int id) {
        Optional<Mascota> optMascota = mascotaService.getMascotaById(id);
        if (optMascota.isPresent()) {
            MascotaDTO mascota = convertMascotaToDto(optMascota.get());
            Optional<Propietario> optPropietario = propietarioService.getPropietarioById(mascota.getId());
            if (optPropietario.isPresent()) {
                PropietarioDTO propietarioDTO = convertPropietarioToDto(optPropietario.get());
                return new ResponseEntity<>(propietarioDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // Metodos auxiliares para convertir mascotas o listas de mascotas a DTO
    private MascotaDTO convertMascotaToDto(Mascota mascota) {
        MascotaDTO dto = new MascotaDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setFechaNacimiento(mascota.getFechaNacimiento());
        dto.setRaza(mascota.getRaza().toString());
        dto.setPeso(mascota.getPeso());
        dto.setTieneChip(mascota.isTieneChip());
        dto.setUrlFoto(mascota.getUrlFoto());

        if (mascota.getPropietario() != null) {
            PropietarioDTO propietarioDTO = new PropietarioDTO();
            propietarioDTO.setId(mascota.getPropietario().getId());
            propietarioDTO.setNombre(mascota.getPropietario().getNombre());
            propietarioDTO.setDireccion(mascota.getPropietario().getDireccion());
            propietarioDTO.setTelefono(mascota.getPropietario().getTelefono());
            dto.setPropietario(propietarioDTO);
        }

        return dto;
    }

    private PropietarioDTO convertPropietarioToDto(Propietario propietario) {
        PropietarioDTO dto = new PropietarioDTO();
        dto.setId(propietario.getId());
        dto.setNombre(propietario.getNombre());
        dto.setDireccion(propietario.getDireccion());
        dto.setTelefono(propietario.getTelefono());

        return dto;
    }

    private List<MascotaDTO> listMascotasToDTO(List<Mascota> mascotas) {
        return mascotas.stream()
                .map(this::convertMascotaToDto)
                .toList();
    }
}
