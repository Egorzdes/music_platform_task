package ru.fedorov.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fedorov.example.model.dao.ExecutorDao;

import java.util.Optional;

@Repository
public interface ExecutorRepository extends JpaRepository<ExecutorDao, Long> {

    Optional<ExecutorDao> findById(Long executorId);
}
