package com.stage.insertMarks.controller;

import com.stage.insertMarks.dto.MarkDTO;
import com.stage.insertMarks.dto.ModuleDTO;
import com.stage.insertMarks.dto.StudentMarkDTO;
import com.stage.insertMarks.entity.Mark;
import com.stage.insertMarks.entity.Module;
import com.stage.insertMarks.entity.StudentMark;
import com.stage.insertMarks.service.StudentMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/studentMarks")
@CrossOrigin(origins = "http://localhost:3000")
public class StudentMarkController {

    @Autowired
    private StudentMarkService studentMarkService;
    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping
    public ResponseEntity<StudentMarkDTO> createStudentMark(@RequestBody StudentMarkDTO studentMarkDTO) {
        System.out.println("Received StudentMarkDTO: " + studentMarkDTO);
        try {
            // Ajoutez des vérifications ou des validations ici si nécessaire
            StudentMark studentMark = convertToEntity(studentMarkDTO);
            StudentMark savedStudentMark = studentMarkService.saveStudentMark(studentMark);
            return new ResponseEntity<>(convertToDTO(savedStudentMark), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating StudentMark", e);
        }
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping
    public ResponseEntity<List<StudentMarkDTO>> getAllStudentMarks() {
        try {
            List<StudentMark> studentMarks = studentMarkService.getAllStudentMarks();
            List<StudentMarkDTO> studentMarkDTOs = studentMarks.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(studentMarkDTOs, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving StudentMarks", e);
        }
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/{studentId}/{markId}")
    public ResponseEntity<Void> deleteStudentMark(@PathVariable Integer studentId, @PathVariable Integer markId) {
        try {
            studentMarkService.deleteStudentMark(studentId, markId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error deleting StudentMark", e);
        }
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

    private StudentMark convertToEntity(StudentMarkDTO studentMarkDTO) {
        StudentMark studentMark = new StudentMark();
        studentMark.setStudentId(studentMarkDTO.getStudentId());
        studentMark.setMarkId(studentMarkDTO.getMarkId());
        studentMark.setMark(convertToEntity(studentMarkDTO.getMark()));
        return studentMark;
    }

    private Mark convertToEntity(MarkDTO markDTO) {
        Mark mark = new Mark();
        // Ne pas setter l'ID si vous voulez que la base de données le génère
        mark.setMarkCc(markDTO.getMarkCc());
        mark.setMarkExam(markDTO.getMarkExam());
        mark.setMarkTp(markDTO.getMarkTp());
        mark.setModule(convertToEntity(markDTO.getModule()));
        return mark;
    }

    private Module convertToEntity(ModuleDTO moduleDTO) {
        if (moduleDTO.getCoefficient() == null) {
            throw new IllegalArgumentException("Coefficient cannot be null");
        }

        Module module = new Module();
        module.setIdModule(moduleDTO.getIdModule());
        module.setName(moduleDTO.getName());
        module.setCoefficient(moduleDTO.getCoefficient());
        return module;
    }

}
