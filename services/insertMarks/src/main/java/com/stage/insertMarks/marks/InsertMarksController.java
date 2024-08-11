package com.stage.insertMarks.marks;


import com.stage.insertMarks.user.StudentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @PostMapping("/getStudents/{gradeName}/{idModule}")
    public ResponseEntity<List<StudentAndMarkResponse>> retrieveStudents(
            @PathVariable("gradeName") String gradeName,
            @PathVariable("idModule") int idModule,
            @RequestHeader("Authorization") String headerValue
    ){
        return ResponseEntity.ok(marksService.retrieveStudents(gradeName,idModule,headerValue));
    }

    @PostMapping("/saveMarks")
    public ResponseEntity<String> saveMarks(
            @RequestBody MarksCredentials marksCredentials
    ){
        return ResponseEntity.ok(marksService.saveMarks(marksCredentials));
    }
}
