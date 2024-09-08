package dh.backend.clinicamvc.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnoModificarDto {
    private Integer id;
    private Integer paciente_id;
    private Integer odontologo_id;
    private String fecha;
}
