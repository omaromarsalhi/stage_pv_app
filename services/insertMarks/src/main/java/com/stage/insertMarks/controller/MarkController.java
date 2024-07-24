package com.stage.insertMarks.controller;

import com.stage.insertMarks.entity.Mark;
import com.stage.insertMarks.service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marks")
public class MarkController {

    @Autowired
    private MarkService markService;

    // Create or Update a Mark
    @PostMapping
    public ResponseEntity<Mark> createOrUpdateMark(@RequestBody Mark mark) {
        Mark savedMark = markService.saveMark(mark);
        return new ResponseEntity<>(savedMark, HttpStatus.CREATED);
    }

    // Get a Mark by ID
    @GetMapping("/{id}")
    public ResponseEntity<Mark> getMarkById(@PathVariable("id") Integer id) {
        Optional<Mark> mark = markService.getMarkById(id);
        if (mark.isPresent()) {
            return new ResponseEntity<>(mark.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Marks
    @GetMapping
    public ResponseEntity<List<Mark>> getAllMark() {
        List<Mark> marks = markService.getAllMark();
        return new ResponseEntity<>(marks, HttpStatus.OK);
    }

    // Delete a Mark by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMark(@PathVariable("id") Integer id) {
        Optional<Mark> mark = markService.getMarkById(id);
        if (mark.isPresent()) {
            markService.deleteMark(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
