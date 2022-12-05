package com.citas.agendamiento.service.impl;

import com.citas.agendamiento.entity.Tests;
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
    public List<Tests> getAllTests() {
        return (List<Tests>) testsRepository.findAll();
    }

    @Override
    public Tests getTestById(int testId) {
        return  testsRepository.findById(testId).orElse(null);
    }

    @Override
    public Tests addOrUpdateTest(Tests test) {
        return testsRepository.save(test);
    }

    @Override
    public Tests deletedTest(int testId) throws Exception {
        Tests deletedTest = null;
        try {

            deletedTest = testsRepository.findById(testId).orElse(null);
            if(deletedTest == null){
                throw new Exception("user not available");
            }else {
                testsRepository.deleteById(testId);
            }
        }
        catch (Exception ex){
            throw ex;
        }
        return deletedTest;
    }
}
