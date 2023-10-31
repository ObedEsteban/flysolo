package mapeohibernate;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estudiantes", schema = "umgpost", catalog = "umgpost")
public class EstudiantesClass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_estudiante", nullable = false)
    private int idEstudiante;
    @Basic
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @OneToMany(mappedBy = "estudiantesByIdEstudiante")
    private Collection<InscripcionesClass> inscripcionesByIdEstudiante;

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudiantesClass that = (EstudiantesClass) o;
        return idEstudiante == that.idEstudiante && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, nombre, apellido, email);
    }

    public Collection<InscripcionesClass> getInscripcionesByIdEstudiante() {
        return inscripcionesByIdEstudiante;
    }

    public void setInscripcionesByIdEstudiante(Collection<InscripcionesClass> inscripcionesByIdEstudiante) {
        this.inscripcionesByIdEstudiante = inscripcionesByIdEstudiante;
    }
}
