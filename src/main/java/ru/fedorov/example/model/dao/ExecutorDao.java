package ru.fedorov.example.model.dao;


import lombok.*;
import ru.fedorov.example.controller.dto.executor.ExecutorDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Musician
 */
@Entity
@Table(name = "executor" )
@Getter
@Setter
@NoArgsConstructor
public class ExecutorDao implements Serializable {

    private static final long serialVersionUID = 7857297083810091971L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name" )
    private String name;
    @Column(name = "members" )
    private String members;
    @Column(name = "origin" )
    private String origin;

    @OneToMany(mappedBy = "idExecutorDao" )
    private List<AlbumDao> albumDaoList;

    public ExecutorDao(ExecutorDto executorDto) {
        this.id = executorDto.getExecutorId();
        this.members = executorDto.getMembers();
        this.name = executorDto.getName();
        this.origin = executorDto.getOrigin();
    }
}
