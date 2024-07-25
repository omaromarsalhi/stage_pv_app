package com.stage.insertMarks.controller;

import com.stage.insertMarks.dto.MarkDTO;
import com.stage.insertMarks.dto.ModuleDTO;
import com.stage.insertMarks.dto.StudentMarkDTO;
import com.stage.insertMarks.entity.Mark;
import com.stage.insertMarks.entity.Module;  // Assurez-vous que cet import est correct
import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.service.StudentMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/studentMarks")
public class StudentMarkController {

    @Autowired
    private StudentMarkService studentMarkService;

    @PostMapping
    public ResponseEntity<StudentMarkDTO> createStudentMark(@RequestBody StudentMark studentMark) {
        StudentMark savedStudentMark = studentMarkService.saveStudentMark(studentMark);
        return new ResponseEntity<>(convertToDTO(savedStudentMark), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentMarkDTO>> getAllStudentMarks() {
        List<StudentMark> studentMarks = studentMarkService.getAllStudentMarks();
        List<StudentMarkDTO> studentMarkDTOs = studentMarks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(studentMarkDTOs, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}/{markId}")
    public ResponseEntity<Void> deleteStudentMark(@PathVariable Integer studentId, @PathVariable Integer markId) {
        studentMarkService.deleteStudentMark(studentId, markId);
        return ResponseEntity.noContent().build();
    }

    private StudentMarkDTO convertToDTO(StudentMark studentMark) {
        StudentMarkDTO dto = new StudentMarkDTO();
        dto.setStudentId(studentMark.getStudentId());
        dto.setMarkId(studentMark.getMarkId());
        dto.setMark(convertMarkToDTO(studentMark.getMark()));
        return dto;
    }

    private MarkDTO convertMarkToDTO(Mark mark) {
        MarkDTO dto = new MarkDTO();
        dto.setIdMark(mark.getIdMark());
        dto.setMarkCc(mark.getMarkCc());
        dto.setMarkExam(mark.getMarkExam());
        dto.setMarkTp(mark.getMarkTp());
        dto.setModule(convertModuleToDTO(mark.getModule()));
        return dto;
    }

    private ModuleDTO convertModuleToDTO(Module module) {
        ModuleDTO dto = new ModuleDTO();
        dto.setIdModule(module.getIdModule());
        dto.setName(module.getName());
        dto.setCoefficient(module.getCoefficient());
        return dto;
    }
}
