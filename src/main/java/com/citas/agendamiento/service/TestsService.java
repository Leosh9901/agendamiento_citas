package com.citas.agendamiento.service;

import com.citas.agendamiento.entity.Test;

import java.util.List;

public interface TestsService {

    List<Test> getAllTests();

    Test getTestById(int testId);

    Test addOrUpdateTest(Test test);

    Test deletedTest(int testId) throws Exception;
}
