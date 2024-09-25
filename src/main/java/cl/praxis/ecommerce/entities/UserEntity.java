package cl.praxis.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String lastName;

    @Column(name = "correo", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "clave", nullable = false, length = 100)
    private String password;

    @Column(name = "telefono", nullable = false, length = 20)
    private int phone;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate registerDate;

    @Column(name = "esta_activa")
    private boolean isEnabled;

    @Column(name = "cuenta_no_expirada")
    private boolean accountNoExpired;

    @Column(name = "cuenta_no_bloqueada")
    private boolean accountNoLocked;

    @Column(name = "credencial_no_expirada")
    private boolean credentialNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();
}