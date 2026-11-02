package com.example.service;

import com.example.model.Result;
import java.util.*;

public class ResultManager {
    private List<Result> results = new ArrayList<>();

    public void add(Result r) { results.add(r); }
    public List<Result> getAll() { return results; }

    public List<Result> searchByStudentName(String name) {
        List<Result> matched = new ArrayList<>();
        String n = name.toLowerCase();
        for (Result r : results) {
            if (r.getStudent().getName().toLowerCase().contains(n)) {
                matched.add(r);
            }
        }
        return matched;
    }

    
    public void sortNatural() { 
        Collections.sort(results); 
    }
    
    
    public void sortByStudentName() { 
        results.sort(Comparator.comparing(r -> r.getStudent().getName())); 
    }
}