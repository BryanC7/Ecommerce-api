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

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
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

            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
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

            UserEntity user4 = UserEntity.builder()
                    .name("José")
                    .lastName("Ortega")
                    .email("jose@correo.com")
                    .password("$2a$10$iulxRLZAcfA/fcc/0vP9H.4XqQ.gohJUt1DE5NRvUehCTOH6lGnmS")
                    .phone(87654321)
                    .registerDate(LocalDate.of(2024, 9,15))
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            userRepository.saveAll((List.of(user1, user2, user3, user4)));

            /* Address */
            Address address = Address.builder()
                    .addressName("Calle Falsa 123")
                    .city("Springfield")
                    .code("12345")
                    .userEntity(user1)
                    .build();

            addressRepository.save(address);

            /* Category */
            Category category = Category.builder()
                    .categoryName("Electrónica")
                    .build();

            categoryRepository.save(category);

            /* Order */
            Order order = Order.builder()
                    .orderDate(LocalDate.now())
                    .state("PENDIENTE")
                    .userEntity(user1)
                    .build();

            orderRepository.save(order);

            /* Product */
            Product product = Product.builder()
                    .productName("Laptop")
                    .description("Laptop gaming de alta gama")
                    .price(1500)
                    .stock(10)
                    .category(category)
                    .build();

            productRepository.save(product);

            /* Pay */
            Pay pay = Pay.builder()
                    .totalAmount(2000)
                    .payDate(LocalDate.now())
                    .order(order)
                    .build();

            payRepository.save(pay);

            /* Details */
            Detail detail = Detail.builder()
                    .amount(2)
                    .subtotal(200)
                    .order(order)
                    .product(product)
                    .build();

            detailRepository.save(detail);

        };
    }
}