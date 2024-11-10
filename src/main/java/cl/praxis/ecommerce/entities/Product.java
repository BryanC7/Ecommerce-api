package cl.praxis.ecommerce.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "productos")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String productName;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String description;

    @Column(name = "precio", nullable = false)
    private int price;

    @Column(name = "cantidad", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonBackReference
    private Category category;
}