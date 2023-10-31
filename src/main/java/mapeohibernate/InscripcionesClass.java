package mapeohibernate;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "inscripciones", schema = "umgpost", catalog = "umgpost")
public class InscripcionesClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_inscripcion", nullable = false)
    private int idInscripcion;
    @Basic
    @Column(name = "id_estudiante", nullable = true)
    private Integer idEstudiante;
    @Basic
    @Column(name = "id_curso", nullable = true)
    private Integer idCurso;
    @Basic
    @Column(name = "fecha_inscripcion", nullable = false)
    private Date fechaInscripcion;
    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id_estudiante")
    private EstudiantesClass estudiantesByIdEstudiante;
    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    private CursosClass cursosByIdCurso;

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionesClass that = (InscripcionesClass) o;
        return idInscripcion == that.idInscripcion && Objects.equals(idEstudiante, that.idEstudiante) && Objects.equals(idCurso, that.idCurso) && Objects.equals(fechaInscripcion, that.fechaInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInscripcion, idEstudiante, idCurso, fechaInscripcion);
    }

    public EstudiantesClass getEstudiantesByIdEstudiante() {
        return estudiantesByIdEstudiante;
    }

    public void setEstudiantesByIdEstudiante(EstudiantesClass estudiantesByIdEstudiante) {
        this.estudiantesByIdEstudiante = estudiantesByIdEstudiante;
    }

    public CursosClass getCursosByIdCurso() {
        return cursosByIdCurso;
    }

    public void setCursosByIdCurso(CursosClass cursosByIdCurso) {
        this.cursosByIdCurso = cursosByIdCurso;
    }
}
