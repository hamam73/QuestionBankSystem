package com.example.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void save(T obj, String path) throws IOException {
        try (Writer w = new FileWriter(path)) {
            GSON.toJson(obj, w);
        }
    }

    public static <T> List<T> loadList(String path, Class<T> clazz) throws IOException {
        Type type = TypeToken.getParameterized(List.class, clazz).getType();
        try (Reader r = new FileReader(path)) {
            List<T> l = GSON.fromJson(r, type);
            return l == null ? new ArrayList<>() : l;
        }
    }
}