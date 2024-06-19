package Claridad.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curso")

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_curso;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "modalidad")
    private String modalidad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "requisitos_previos")
    private String requisitos_previos;
}
