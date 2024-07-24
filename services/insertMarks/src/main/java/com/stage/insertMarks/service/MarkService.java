package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.Mark;

import java.util.List;
import java.util.Optional;

public interface MarkService {
    Mark saveMark(Mark mark);
    Optional<Mark> getMarkById(Integer id);
    List<Mark> getAllMark();
    void deleteMark(Integer id);
}
