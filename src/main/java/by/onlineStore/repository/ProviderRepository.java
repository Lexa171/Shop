package by.onlineStore.repository;

import by.onlineStore.bean.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Optional<Provider> findOneById(Long id);
}
