package cl.praxis.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pedido", nullable = false, length = 100)
    private LocalDate orderDate;

    @Column(name = "estado", nullable = false, length = 50)
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "order")
    private List<Detail> detailList;
}