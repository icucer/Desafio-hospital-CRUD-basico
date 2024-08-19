package cl.praxis.hospital_post_pandemia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "diagnostico", nullable = false, length = 254)
    private String diagnostico;

    @Column(name = "fecha_ingreso", nullable = false)
    private String fecha_ingreso;

    @Column(name = "habitacion", nullable = false, length = 5)
    private String habitacion;

}
