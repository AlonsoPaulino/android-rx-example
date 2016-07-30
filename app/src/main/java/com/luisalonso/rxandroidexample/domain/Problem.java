package com.luisalonso.rxandroidexample.domain;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class Problem {

    private final int contestId;
    private final String index;
    private final String name;
    private final String type;

    public Problem(int contestId, String index, String name, String type) {
        this.contestId = contestId;
        this.index = index;
        this.name = name;
        this.type = type;
    }

    public int getContestId() {
        return this.contestId;
    }

    public String getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }
}
