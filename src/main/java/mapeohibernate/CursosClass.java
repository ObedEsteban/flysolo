package mapeohibernate;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "cursos", schema = "umgpost", catalog = "umgpost")
public class CursosClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_curso", nullable = false)
    private int idCurso;
    @Basic
    @Column(name = "nombre_curso", nullable = false, length = 100)
    private String nombreCurso;
    @Basic
    @Column(name = "profesor", nullable = false, length = 50)
    private String profesor;
    @OneToMany(mappedBy = "cursosByIdCurso")
    private Collection<InscripcionesClass> inscripcionesByIdCurso;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosClass that = (CursosClass) o;
        return idCurso == that.idCurso && Objects.equals(nombreCurso, that.nombreCurso) && Objects.equals(profesor, that.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, nombreCurso, profesor);
    }

    public Collection<InscripcionesClass> getInscripcionesByIdCurso() {
        return inscripcionesByIdCurso;
    }

    public void setInscripcionesByIdCurso(Collection<InscripcionesClass> inscripcionesByIdCurso) {
        this.inscripcionesByIdCurso = inscripcionesByIdCurso;
    }
}
