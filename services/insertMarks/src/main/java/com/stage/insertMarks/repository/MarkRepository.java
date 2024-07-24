package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Integer>{
}
