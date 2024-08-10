package com.stage.insertMarks.marks;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marks/")
@RequiredArgsConstructor
public class InsertMarksController {

    private final MarksService marksService;


    @PostMapping("/professorCredentials/{idProfessor}")
    public ResponseEntity<ProfessorResponse> retrieveData(
            @PathVariable int idProfessor
    ) {
        return ResponseEntity.ok(marksService.retrieveData(idProfessor));
    }
}
