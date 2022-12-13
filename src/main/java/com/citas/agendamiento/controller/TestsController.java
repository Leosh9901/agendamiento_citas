package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Test;
import com.citas.agendamiento.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestsController {

    @Autowired
    private TestsService testsService;

    @GetMapping("/allTests")
    public ResponseEntity<List<Test>> getAllTests() {

        List<Test> tests = null;

        try {
            tests = testsService.getAllTests();
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<List<Test>>(tests, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Test> getTestsById(@PathVariable("id") int testId) {

        Test test = null;

        try {
            test = testsService.getTestById(testId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Test>(test, HttpStatus.OK);
    }

    @PostMapping("/addTest")
    public ResponseEntity<Test> addTest(@RequestBody Test test) {

        Test tests = null;

        try {
            tests = testsService.addOrUpdateTest(test);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Test>(tests, HttpStatus.CREATED);
    }

    @PutMapping("/updateTest")
    public ResponseEntity<Test> updateTest(@RequestBody Test test) {

        Test tests = null;

        try {
            tests = testsService.addOrUpdateTest(test);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Test>(tests, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Test> deletedTest(@PathVariable("id") int testId) {

        Test test = null;

        try {
            test = testsService.deletedTest(testId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Test>(test, HttpStatus.OK);
    }

}
