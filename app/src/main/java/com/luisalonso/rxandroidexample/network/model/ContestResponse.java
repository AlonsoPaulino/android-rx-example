package com.luisalonso.rxandroidexample.network.model;

import com.luisalonso.rxandroidexample.domain.Problem;

import java.util.List;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class ContestResponse {

    private String status;
    private Result result;

    static class Result {
        List<Problem> problems;
    }

    public String getStatus() {
        return status;
    }

    public List<Problem> getProblems() {
        return result.problems;
    }
}
