package xyz.kolokolov.simpleservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.kolokolov.simpleservice.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
