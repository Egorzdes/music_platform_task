package ru.fedorov.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fedorov.example.model.dao.ProductDao;

@Repository
public interface ProductRepository extends JpaRepository<ProductDao, Long> {
}
