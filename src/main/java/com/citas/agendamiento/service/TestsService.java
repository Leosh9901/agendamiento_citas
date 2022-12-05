package com.citas.agendamiento.service;

import com.citas.agendamiento.entity.Tests;

import java.util.List;

public interface TestsService {

    List<Tests> getAllTests();

    Tests getTestById(int testId);

    Tests addOrUpdateTest(Tests test);

    Tests deletedTest(int testId) throws Exception;
}
