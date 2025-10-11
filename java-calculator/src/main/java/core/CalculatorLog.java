package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.ExpressionFormatter;

public class CalculatorLog {
    private final List<String> history = new ArrayList<>();
    private final Map<String, String> cache = new HashMap<>();

    public void save(String expression, String result) {
        history.add(ExpressionFormatter.format(expression, result));
        cache.put(expression, result);
    }

    public String getFromCache(String expression) {
        return cache.get(expression);
    }

    public String getHistories() {
        return String.join("\n", history);
    }
}
