package com.example.league_manager_backend.model;

import java.util.Date;
import java.util.List;

public class LeagueData {
    private List<Integer> ids;
    private List<Date> dates;

    @Override
    public String toString() {
        return "LeagueData{" +
                "ids=" + ids +
                ", dates=" + dates +
                '}';
    }
}
