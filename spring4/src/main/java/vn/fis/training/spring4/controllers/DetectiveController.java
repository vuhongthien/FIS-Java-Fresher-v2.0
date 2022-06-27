package vn.fis.training.spring4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.spring4.models.Detective;
import vn.fis.training.spring4.services.DetectiveServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/detective")
public class DetectiveController {

    @Autowired
    private DetectiveServiceImpl detectiveService;

    // http://localhost:8080/detective/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Detective>> getAll() {
        List<Detective> list = detectiveService.getAll();
        return new ResponseEntity<List<Detective>>(list, HttpStatus.OK);
    }

    // http://localhost:8080/detective/findById/2
    @GetMapping("/findById/{criId}")
    public Detective findById(@PathVariable(name = "detId") Long criId) {
        return detectiveService.findById(criId);
    }

    // http://localhost:8080/detective/createDet
    @PostMapping("/createDet")
    public Detective createCri(@RequestParam(name = "detId") Long detId, @RequestParam(name = "firstName") String firstName) {
        Detective createDet = new Detective();
        createDet.setId(detId);
        createDet.setFirstName(firstName);
        return detectiveService.create(createDet);
    }

    // http://localhost:8080/detective/updateDet
    // http://localhost:8080/detective/updateDet?detId=3&updateFirstName=FirstName has changed
    @PutMapping("/updateDet")
    public Detective updateDet(@RequestParam(name = "detId") Long detId, @RequestParam(name = "updateFirstName") String updateFirstName) {
        Detective updateDet = new Detective();
        updateDet.setId(detId);
        updateDet.setFirstName(updateFirstName);
        return detectiveService.update(updateDet);
    }

    // http://localhost:8080/detective/deleteDet
    @DeleteMapping("/deleteDet")
    public Detective deleteDet(@RequestParam(name = "detId") Long detId) {
        return detectiveService.delete(detId);
    }

}
