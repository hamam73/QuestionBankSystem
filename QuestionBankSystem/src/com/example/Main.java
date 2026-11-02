package com.example;

import com.example.model.*;
import com.example.service.*;
import com.example.util.JsonUtil;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        QuestionBank bank = new QuestionBank();
        ResultManager results = new ResultManager();

        bank.addQuestion(new Question("Q1", "What is the capital of France?", "Geography", "Paris"));
        bank.addQuestion(new Question("Q2", "2 + 2 = ?", "Math", "4"));
        bank.addQuestion(new Question("Q3", "What is the largest planet?", "Science", "Jupiter"));

        Student john = new Student("S1", "John");
        Student sarah = new Student("S2", "Sarah");
        results.add(new Result(john, bank.getById("Q1"), true, "2025-01-01"));
        results.add(new Result(sarah, bank.getById("Q2"), false, "2025-01-02"));
        results.add(new Result(john, bank.getById("Q3"), true, "2025-01-03"));

        System.out.println("Categories: " + bank.getCategories());
        
        System.out.println("\nSearch for 'capital':");
        bank.searchByKeyword("capital").forEach(System.out::println);

        System.out.println("\nSearch for student 'John':");
        results.searchByStudentName("John").forEach(System.out::println);

        System.out.println("\n--- Sorted by Score (Comparable) ---");
        results.sortNatural();
        results.getAll().forEach(System.out::println);

        System.out.println("\n--- Sorted by Student Name (Comparator) ---");
        results.sortByStudentName();
        results.getAll().forEach(System.out::println);

        try {
            JsonUtil.save(bank.getMap(), "questions.json");
            JsonUtil.save(results.getAll(), "results.json");
            System.out.println("\n✅ Files saved successfully");
            List<Result> loaded = JsonUtil.loadList("results.json", Result.class);
            System.out.println("Loaded " + loaded.size() + " results from JSON.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}