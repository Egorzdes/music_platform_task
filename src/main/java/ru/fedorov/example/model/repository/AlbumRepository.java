package ru.fedorov.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.fedorov.example.model.dao.AlbumDao;


import java.util.List;


@Repository
public interface AlbumRepository extends JpaRepository<AlbumDao, Long> {

    @Query("from AlbumDao where idExecutorDao.id = :executorId" )
    List<AlbumDao> findByIdExecutor(Long executorId);

}
