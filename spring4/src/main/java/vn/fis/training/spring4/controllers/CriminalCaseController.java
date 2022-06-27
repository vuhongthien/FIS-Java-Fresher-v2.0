package vn.fis.training.spring4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.spring4.models.CriminalCase;
import vn.fis.training.spring4.services.CriminalCaseServiceImpl;

import java.util.List;

// http://localhost:8080/criminal

@RestController
@RequestMapping("/criminal")
public class CriminalCaseController {

    @Autowired
    private CriminalCaseServiceImpl criminalCaseService;

    // http://localhost:8080/criminal/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<CriminalCase>> getAll() {
        List<CriminalCase> list = criminalCaseService.getAll();
        return new ResponseEntity<List<CriminalCase>>(list, HttpStatus.OK);
    }
    @PutMapping("/updateCri")
    public CriminalCase updateCri(@RequestParam(name="criId")Long criId, @RequestParam(name="updateShortDes")String updateShortDes) {
        CriminalCase updateCri = new CriminalCase();
        updateCri.setId(criId);
        updateCri.setShortDescription(updateShortDes);
        return criminalCaseService.update(updateCri);
    }


    // http://localhost:8080/criminal/findById/2
    @GetMapping("/findById/{criId}")
    public CriminalCase findById(@PathVariable(name="criId")Long criId) {
        return criminalCaseService.findById(criId);
    }
    @DeleteMapping("/deleteCri")
    public CriminalCase deleteCri(@RequestParam(name="criId")Long criId) {
        return criminalCaseService.delete(criId);
    }

    // http://localhost:8080/criminal/createCri?criId=12&shortDes=des12s
    @PostMapping("/createCri")
    public CriminalCase createCri(@RequestParam(name="criId")Long criId, @RequestParam(name="shortDes")String shortDes) {
        CriminalCase createCri = new CriminalCase();
        createCri.setId(criId);
        createCri.setShortDescription(shortDes);
        return criminalCaseService.create(createCri);
    }

    // http://localhost:8080/criminal/updateCri?criId=12&updateShortDes=short12 has updated

    // http://localhost:8080/criminal/deleteCri?criId=12

}
