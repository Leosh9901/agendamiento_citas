package com.citas.agendamiento.controller;

import com.citas.agendamiento.entity.Tests;
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
    public ResponseEntity<List<Tests>> getAllTests() {

        List<Tests> tests = null;

        try {
            tests = testsService.getAllTests();
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<List<Tests>>(tests, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Tests> getTestsById(@PathVariable("id") int testId) {

        Tests tests = null;

        try {
            tests = testsService.getTestById(testId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Tests>(tests, HttpStatus.OK);
    }

    @PostMapping("/addTest")
    public ResponseEntity<Tests> addTest(@RequestBody Tests test) {

        Tests tests = null;

        try {
            tests = testsService.addOrUpdateTest(test);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Tests>(tests, HttpStatus.OK);
    }

    @PutMapping("/updateTest")
    public ResponseEntity<Tests> updateTest(@RequestBody Tests test) {

        Tests tests = null;

        try {
            tests = testsService.addOrUpdateTest(test);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Tests>(tests, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tests> deletedTest(@PathVariable("id") int testId) {

        Tests tests = null;

        try {
            tests = testsService.deletedTest(testId);
        } catch (Exception ex) {
            ex.getMessage();
        }

        return new ResponseEntity<Tests>(tests, HttpStatus.OK);
    }

}
