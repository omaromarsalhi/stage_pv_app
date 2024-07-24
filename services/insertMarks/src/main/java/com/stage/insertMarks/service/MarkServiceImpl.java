package com.stage.insertMarks.service;

import com.stage.insertMarks.entity.Mark;
import com.stage.insertMarks.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements MarkService{

    @Autowired
    private MarkRepository markRepository;

    @Override
    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    @Override
    public Optional<Mark> getMarkById(Integer id) {
        return markRepository.findById(id);
    }

    @Override
    public List<Mark> getAllMark() {
        return markRepository.findAll();
    }

    @Override
    public void deleteMark(Integer id) {
        markRepository.deleteById(id);
    }
}
