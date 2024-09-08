package dh.backend.clinicamvc.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TurnoResponseDto {
    private Integer id;
    private PacienteResponseDto paciente;
    private OdontologoResponseDto odontologo;
    private String fecha;
}
