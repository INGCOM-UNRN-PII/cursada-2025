package ar.unrn.igualdad;

import java.util.*;

public class Classificator<T extends Filtrable> {

    private final List<Filtrator<T>> filtrators = new ArrayList<>();

    public Classificator(Filtrator<T>... filtrators) {
        this.filtrators.addAll(Arrays.asList(filtrators));
    }

    public Classificator(Collection<Filtrator<T>> filtrators) {
        this.filtrators.addAll(filtrators);
    }

    public Map<String, List<T>> classify(Collection<T> filtrables, Map<Filtrator<T>, String> keyMap, String defaultGroup) {
        Map<String, List<T>> classification = new HashMap<>();
        // Initialize groups
        for (String groupName : keyMap.values()) {
            classification.put(groupName, new ArrayList<>());
        }
        classification.put(defaultGroup, new ArrayList<>());

        for (T filtrable : filtrables) {
            boolean classified = false;
            for (Filtrator<T> filtrator : filtrators) {
                if (filtrator.filtra(filtrable) && keyMap.containsKey(filtrator)) {
                    classification.get(keyMap.get(filtrator)).add(filtrable);
                    classified = true;
                    break; // Assuming a Filtrable belongs to only one group
                }
            }
            if (!classified) {
                classification.get(defaultGroup).add(filtrable);
            }
        }
        return classification;
    }

    public Map<Filtrator<T>, List<T>> classifyByFiltrator(Collection<T> filtrables) {
        Map<Filtrator<T>, List<T>> classification = new HashMap<>();
        for (Filtrator<T> filtrator : filtrators) {
            classification.put(filtrator, new ArrayList<>());
        }
        classification.put(null, new ArrayList<>()); // Group for those that don't match any

        for (T filtrable : filtrables) {
            boolean matched = false;
            for (Filtrator<T> filtrator : filtrators) {
                if (filtrator.filtra(filtrable)) {
                    classification.get(filtrator).add(filtrable);
                    matched = true;
                    break; // Assuming an object can only belong to one group
                }
            }
            if (!matched) {
                classification.get(null).add(filtrable);
            }
        }
        return classification;
    }
}