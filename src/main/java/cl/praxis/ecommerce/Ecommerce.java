package cl.praxis.ecommerce;

import cl.praxis.ecommerce.entities.*;
import cl.praxis.ecommerce.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Ecommerce {
    public static void main(String[] args) {
        SpringApplication.run(Ecommerce.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, AddressRepository addressRepository, CategoryRepository categoryRepository, DetailRepository detailRepository, OrderRepository orderRepository, ProductRepository productRepository, PayRepository payRepository) {
        return args -> {
            /* Permissions */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            /* Roles */
            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();


            /* Users */
            UserEntity user1 = UserEntity.builder()
                    .name("Bryan")
                    .lastName("Cabrera")
                    .email("bryan@correo.com")
                    .password("$2a$10$iulxRLZAcfA/fcc/0vP9H.4XqQ.gohJUt1DE5NRvUehCTOH6lGnmS")
                    .phone(12345678)
                    .registerDate(LocalDate.of(2024, 9,12))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity user2 = UserEntity.builder()
                    .name("Erick")
                    .lastName("Obregón")
                    .email("erick@correo.com")
                    .password("$2a$10$iulxRLZAcfA/fcc/0vP9H.4XqQ.gohJUt1DE5NRvUehCTOH6lGnmS")
                    .phone(23456789)
                    .registerDate(LocalDate.of(2024, 9,13))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            UserEntity user3 = UserEntity.builder()
                    .name("Pablo")
                    .lastName("Torres")
                    .email("pablo@correo.com")
                    .password("$2a$10$iulxRLZAcfA/fcc/0vP9H.4XqQ.gohJUt1DE5NRvUehCTOH6lGnmS")
                    .phone(98765432)
                    .registerDate(LocalDate.of(2024, 9,14))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();


            userRepository.saveAll((List.of(user1, user2, user3)));

            /* Address */
            Address address1 = Address.builder()
                    .addressName("Calle Falsa 123")
                    .city("Springfield")
                    .code("67890")
                    .userEntity(user1)
                    .build();

            Address address2 = Address.builder()
                    .addressName("Calle Falsa 456")
                    .city("Villa Alemana")
                    .code("12345")
                    .userEntity(user2)
                    .build();

            Address address3 = Address.builder()
                    .addressName("Calle Falsa 789")
                    .city("Viña del Mar")
                    .code("64527")
                    .userEntity(user3)
                    .build();

            addressRepository.saveAll((List.of(address1, address2, address3)));

            /* Categories */
            Category category1 = Category.builder()
                    .categoryName("Electrónica")
                    .build();

            Category category2 = Category.builder()
                    .categoryName("Cocina")
                    .build();

            Category category3 = Category.builder()
                    .categoryName("Decoración")
                    .build();

            Category category4 = Category.builder()
                    .categoryName("Muebles")
                    .build();

            categoryRepository.saveAll((List.of(category1, category2, category3, category4)));

            /* Order */
            Order order1 = Order.builder()
                    .orderDate(LocalDate.now())
                    .state("PENDIENTE")
                    .userEntity(user1)
                    .build();

            Order order2 = Order.builder()
                    .orderDate(LocalDate.now())
                    .state("PAGADO")
                    .userEntity(user1)
                    .build();

            Order order3 = Order.builder()
                    .orderDate(LocalDate.now())
                    .state("PENDIENTE")
                    .userEntity(user2)
                    .build();

            orderRepository.saveAll((List.of(order1, order2, order3)));

            /* Products */
            Product product1 = Product.builder()
                    .productName("Laptop Gaming")
                    .description("Desata tu potencial gamer con esta laptop de alto rendimiento. Con gráficos impactantes, un diseño ultramoderno y un teclado retroiluminado RGB, estarás listo para ganar cada partida. Equipada con una pantalla de alta resolución y un sistema de refrigeración avanzada, esta laptop ofrece una experiencia de juego fluida e inmersiva.")
                    .price(1200000)
                    .stock(20)
                    .category(category1)
                    .build();

            Product product2 = Product.builder()
                    .productName("Smartwatch")
                    .description("Tu asistente personal en la muñeca: este smartwatch combina elegancia y funcionalidad. Monitorea tu salud, recibe notificaciones al instante y sigue tus actividades diarias con precisión. Su diseño moderno y resistente lo convierte en el accesorio perfecto para todo momento")
                    .price(144990)
                    .stock(15)
                    .category(category1)
                    .build();

            Product product3 = Product.builder()
                    .productName("Teléfono Celular")
                    .description("Redefine la experiencia móvil con este smartphone de última generación. Pantalla OLED sin bordes, cámara de alta resolución y un rendimiento rápido que te mantiene conectado y productivo. Elegancia, potencia y tecnología en tus manos.")
                    .price(619990)
                    .stock(10)
                    .category(category1)
                    .build();

            Product product4 = Product.builder()
                    .productName("Audífonos Inalámbricos")
                    .description("Libérate de los cables y disfruta de la música en su máxima expresión. Con tecnología de cancelación de ruido, batería de larga duración y un diseño ergonómico, estos audífonos inalámbricos son perfectos para cualquier momento del día.")
                    .price(79990)
                    .stock(5)
                    .category(category1)
                    .build();

            Product product5 = Product.builder()
                    .productName("Lámpara de Pie Moderna")
                    .description("Ilumina tus espacios con estilo. Esta lámpara de pie moderna combina diseño minimalista y funcionalidad, perfecta para crear un ambiente cálido en cualquier habitación.")
                    .price(57990)
                    .stock(12)
                    .category(category2)
                    .build();

            Product product6 = Product.builder()
                    .productName("Estantería Flotante")
                    .description("Optimiza y decora tus paredes con esta estantería flotante. De diseño versátil y acabado en madera, es perfecta para exhibir libros, plantas o decoraciones, dando un toque moderno y ordenado a cualquier espacio.")
                    .price(24990)
                    .stock(8)
                    .category(category2)
                    .build();

            Product product7 = Product.builder()
                    .productName("Portavelas de Cristal")
                    .description("Elegancia y calidez en un solo detalle. Este portavelas de cristal añade un toque sofisticado a tus espacios, perfecto para crear un ambiente acogedor en cenas, reuniones o momentos de relax. Diseño delicado y brillo encantador.")
                    .price(10990)
                    .stock(2)
                    .category(category2)
                    .build();

            Product product8 = Product.builder()
                    .productName("Espejo de Pared")
                    .description("Amplía y decora tus espacios con este elegante espejo de pared. Su diseño versátil complementa cualquier estilo, desde moderno hasta clásico, brindando luminosidad y profundidad a tus ambientes. Perfecto para baños, recibidores o dormitorios.")
                    .price(49990)
                    .stock(16)
                    .category(category2)
                    .build();

            Product product9 = Product.builder()
                    .productName("Batidora")
                    .description("La batidora ideal para tus recetas favoritas. Con potencia y durabilidad, esta batidora permite crear desde mezclas suaves hasta masas densas en minutos. Un imprescindible para los amantes de la cocina.")
                    .price(39990)
                    .stock(10)
                    .category(category3)
                    .build();

            Product product10 = Product.builder()
                    .productName("Báscula Digital")
                    .description("Precisión en cada medida con esta báscula digital compacta y elegante. Perfecta para la cocina, control de peso o ingredientes de repostería. Fácil de usar, con pantalla retroiluminada y diseño minimalista.")
                    .price(15000)
                    .stock(7)
                    .category(category3)
                    .build();

            Product product11 = Product.builder()
                    .productName("Molino de Café")
                    .description("Para los amantes del café, nada mejor que un molido fresco y aromático. Este molino de café garantiza la molienda perfecta en segundos, permitiéndote disfrutar de una taza de café con sabor y aroma incomparables.")
                    .price(20000)
                    .stock(20)
                    .category(category3)
                    .build();

            Product product12 = Product.builder()
                    .productName("Olla a Presión")
                    .description("Cocina rápido y fácil con esta olla a presión de alta calidad. Perfecta para guisos, carnes y sopas, manteniendo los sabores y nutrientes de tus ingredientes. Su sistema seguro y eficiente ahorra tiempo y energía.")
                    .price(48990)
                    .stock(6)
                    .category(category3)
                    .build();

            Product product13 = Product.builder()
                    .productName("Sillín Giratorio")
                    .description("Versatilidad y comodidad en un solo asiento. Este sillín giratorio es ideal para espacios modernos, con un diseño ergonómico y altura ajustable que lo hace perfecto para oficinas o salas de reuniones.")
                    .price(67990)
                    .stock(11)
                    .category(category4)
                    .build();

            Product product14 = Product.builder()
                    .productName("Sillín de Exterior")
                    .description("Disfruta del aire libre con estilo. Este sillín de exterior es resistente a la intemperie, de diseño moderno y ergonómico, ideal para jardines, terrazas o balcones. Su estructura duradera asegura comodidad y elegancia en cualquier espacio exterior.")
                    .price(48000)
                    .stock(5)
                    .category(category4)
                    .build();

            Product product15 = Product.builder()
                    .productName("Sofá Modular")
                    .description("Personaliza tu espacio con este sofá modular adaptable. Sus piezas se pueden reconfigurar según tus necesidades, combinando confort y estilo en cualquier sala o salón. Diseño contemporáneo y tapizado de alta calidad.")
                    .price(750000)
                    .stock(1)
                    .category(category4)
                    .build();

            Product product16 = Product.builder()
                    .productName("Sofá Cama")
                    .description("Comodidad y funcionalidad en uno: este sofá cama es perfecto para visitas inesperadas. Diseño elegante, fácil de convertir y con un colchón cómodo para un descanso reparador. Ideal para salas pequeñas o apartamentos.")
                    .price(289990)
                    .stock(4)
                    .category(category4)
                    .build();


            productRepository.saveAll((List.of(product1, product2, product3, product4, product5, product6, product7, product8,
                    product9, product10, product11, product12, product13, product14, product15, product16)));

            /* Pay */
            Pay pay = Pay.builder()
                    .totalAmount(40000)
                    .payDate(LocalDate.now())
                    .order(order1)
                    .build();

            payRepository.save(pay);

            /* Detail */
            Detail detail = Detail.builder()
                    .amount(2)
                    .subtotal(40000)
                    .order(order1)
                    .product(product11)
                    .build();

            detailRepository.save(detail);
        };
    }
}