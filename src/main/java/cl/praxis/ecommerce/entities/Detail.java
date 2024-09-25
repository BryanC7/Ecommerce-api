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
@Table(name = "detalles")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad", nullable = false)
    private int amount;

    @Column(name = "subtotal", nullable = false)
    private int subtotal;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Product product;
}