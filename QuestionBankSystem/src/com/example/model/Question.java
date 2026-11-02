package com.example.model;

public class Question {
    private String id;
    private String text;
    private String category;
    private String answer;

    public Question() {} 

    public Question(String id, String text, String category, String answer) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.answer = answer;
    }
    
    public String getId() { return id; }
    public String getText() { return text; }
    public String getCategory() { return category; }
    public String getAnswer() { return answer; }

    @Override
    public String toString() {
        return "Question[" + id + "] " + text + " (" + category + ")";
    }
}