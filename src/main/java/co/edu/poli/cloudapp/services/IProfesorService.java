package co.edu.poli.cloudapp.services;

import java.util.List;

import co.edu.poli.cloudapp.dto.ProfesorDTO;

public interface IProfesorService {

    ProfesorDTO create(ProfesorDTO profesorDTO);

    ProfesorDTO update(Long id, ProfesorDTO profesorDTO);

    void delete(Long id);

    ProfesorDTO findById(Long id);

    List<ProfesorDTO> findAll();
}

