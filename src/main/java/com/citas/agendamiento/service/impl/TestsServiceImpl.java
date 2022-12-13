package com.citas.agendamiento.service.impl;

import com.citas.agendamiento.entity.Test;
import com.citas.agendamiento.repository.TestsRepository;
import com.citas.agendamiento.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestsServiceImpl implements TestsService {

    @Autowired
    private TestsRepository testsRepository;

    @Override
    public List<Test> getAllTests() {
        return (List<Test>) testsRepository.findAll();
    }

    @Override
    public Test getTestById(int testId) {
        return testsRepository.findById(testId).orElse(null);
    }

    @Override
    public Test addOrUpdateTest(Test test) {
        return testsRepository.save(test);
    }

    @Override
    public Test deletedTest(int testId) throws Exception {
        Test deletedTest = null;
        try {

            deletedTest = testsRepository.findById(testId).orElse(null);
            if (deletedTest == null) {
                throw new Exception("Test not available");
            } else {
                testsRepository.deleteById(testId);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return deletedTest;
    }
}
