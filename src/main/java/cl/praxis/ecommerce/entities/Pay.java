package cl.praxis.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "pagos")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "monto_total", nullable = false)
    private int totalAmount;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate payDate;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Order order;
}