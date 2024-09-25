package cl.praxis.ecommerce.repositories;

import cl.praxis.ecommerce.entities.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {
}
