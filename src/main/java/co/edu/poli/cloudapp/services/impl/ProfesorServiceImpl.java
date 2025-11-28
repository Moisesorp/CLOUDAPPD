package co.edu.poli.cloudapp.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.poli.cloudapp.dto.ProfesorDTO;
import co.edu.poli.cloudapp.entities.Profesor;
import co.edu.poli.cloudapp.repositories.ProfesorRepository;
import co.edu.poli.cloudapp.services.IProfesorService;


@Service
@Transactional
public class ProfesorServiceImpl implements IProfesorService {

    @Autowired
    private ProfesorRepository repoProfesor;
    private ModelMapper modelMapper;

    public ProfesorServiceImpl(ProfesorRepository repository, ModelMapper modelMapper) {
        this.repoProfesor = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProfesorDTO create(ProfesorDTO profesorDTO) {
        Profesor entidad = modelMapper.map(profesorDTO, Profesor.class);
        Profesor saved = repoProfesor.save(entidad);
        return modelMapper.map(saved, ProfesorDTO.class);
    }

    @Override
    public ProfesorDTO update(Long id, ProfesorDTO profesorDTO) {
        Optional<Profesor> exists = repoProfesor.findById(id);
        if (!exists.isPresent()) {
            return null; // o lanza una excepción personalizada si prefieres
        }
        // Asegurarse de mantener el id correcto
        profesorDTO.setIdProfesor(id);
        Profesor entidad = modelMapper.map(profesorDTO, Profesor.class);
        Profesor updated = repoProfesor.save(entidad);
        return modelMapper.map(updated, ProfesorDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (repoProfesor.existsById(id)) {
            repoProfesor.deleteById(id);
        } else {
            // no hacer nada o lanzar excepción según tu política
        }
    }

    @Override
    public ProfesorDTO findById(Long id) {
        return repoProfesor.findById(id)
                .map(p -> modelMapper.map(p, ProfesorDTO.class))
                .orElse(null);
    }

    @Override
    public List<ProfesorDTO> findAll() {
        return repoProfesor.findAll().stream()
                .map(p -> modelMapper.map(p, ProfesorDTO.class))
                .collect(Collectors.toList());
    }
}
