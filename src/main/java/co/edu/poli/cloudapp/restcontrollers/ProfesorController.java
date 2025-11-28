package co.edu.poli.cloudapp.restcontrollers;

import co.edu.poli.cloudapp.dto.ProfesorDTO;
import co.edu.poli.cloudapp.services.IProfesorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final IProfesorService service;

    public ProfesorController(IProfesorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProfesorDTO>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorDTO> obtener(@PathVariable Long id) {
        ProfesorDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProfesorDTO> crear(@RequestBody ProfesorDTO dto) {
        ProfesorDTO creado = service.create(dto);
        return ResponseEntity.created(URI.create("/api/profesores/" + creado.getIdProfesor())).body(creado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorDTO> actualizar(@PathVariable Long id, @RequestBody ProfesorDTO dto) {
        if (service.findById(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.findById(id) == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
