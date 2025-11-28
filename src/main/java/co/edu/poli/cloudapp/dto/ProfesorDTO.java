package co.edu.poli.cloudapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfesorDTO {

    private Long idProfesor;
    private String nomProfesor;
    private String apeProfesor;
    private String email;
    private String especialidad;
}

