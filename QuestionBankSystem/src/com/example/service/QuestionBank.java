package com.example.service;

import com.example.model.Question;
import java.util.*;

public class QuestionBank {
    private Map<String, Question> questions = new HashMap<>();
    private Set<String> categories = new HashSet<>();

    public void addQuestion(Question q) {
        questions.put(q.getId(), q);
        categories.add(q.getCategory());
    }
    
    public Question getById(String id) { return questions.get(id); }
    public Collection<Question> getAll() { return questions.values(); }
    public Set<String> getCategories() { return categories; }
    public Map<String, Question> getMap() { return questions; }

    public List<Question> searchByKeyword(String keyword) {
        List<Question> result = new ArrayList<>();
        String kw = keyword.toLowerCase();
        for (Question q : questions.values()) {
            if (q.getText().toLowerCase().contains(kw)) {
                result.add(q);
            }
        }
        return result;
    }
}