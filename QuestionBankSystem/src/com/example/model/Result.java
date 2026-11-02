package com.example.model;

public class Result implements Comparable<Result> {
    private Student student;
    private Question question;
    private boolean correct;
    private int score;
    private String date;

    public Result() {}

    public Result(Student student, Question question, boolean correct, String date) {
        this.student = student;
        this.question = question;
        this.correct = correct;
        this.score = correct ? 1 : 0;
        this.date = date;
    }
    
    public Student getStudent() { return student; }
    public Question getQuestion() { return question; }
    public boolean isCorrect() { return correct; }
    public int getScore() { return score; }
    public String getDate() { return date; }

    @Override
    public int compareTo(Result other) {
        return Integer.compare(other.score, this.score); 
    }

    @Override
    public String toString() {
        return student.getName() + " | " + question.getId() + " | " + (correct ? "Correct" : "Wrong") + " | " + date;
    }
}