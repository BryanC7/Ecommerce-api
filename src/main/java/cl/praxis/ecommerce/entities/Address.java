package cl.praxis.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "direcciones")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direccion", nullable = false, length = 100)
    private String addressName;

    @Column(name = "ciudad", nullable = false, length = 100)
    private String city;

    @Column(name = "codigo_postal", nullable = false, length = 100)
    private String code;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity userEntity;
}
