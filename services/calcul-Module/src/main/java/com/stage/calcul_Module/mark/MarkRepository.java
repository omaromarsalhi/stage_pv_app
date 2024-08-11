package com.stage.calcul_Module.mark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> findByIdModule(int idModule);


    @Query("""
             select distinct mark from Mark mark  where mark.idMark in ?1 and  mark.idModule = ?2
    """)
    Mark findMark(List<Integer> markIds, int idModule);
}
