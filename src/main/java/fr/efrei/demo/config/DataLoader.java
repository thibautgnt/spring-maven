package fr.efrei.demo.config;

import fr.efrei.demo.model.Todo;
import fr.efrei.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final TodoRepository todoRepository;

    @Autowired
    public DataLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... args) {
        // Vérifier si des données existent déjà
        if (todoRepository.count() == 0) {
            loadSampleData();
        }
    }

    private void loadSampleData() {
        LocalDateTime now = LocalDateTime.now();
        
        Todo todo1 = new Todo();
        todo1.setTitle("Finaliser le rapport de projet");
        todo1.setDescription("Compléter l'analyse des résultats et préparer la présentation PowerPoint");
        todo1.setCompleted(false);
        todo1.setPriority(1);
        todo1.setCreatedAt(now.minusDays(2));
        todo1.setUpdatedAt(now.minusDays(1));

        Todo todo2 = new Todo();
        todo2.setTitle("Réunion d'équipe hebdomadaire");
        todo2.setDescription("Préparer l'ordre du jour et les points à discuter");
        todo2.setCompleted(true);
        todo2.setPriority(2);
        todo2.setCreatedAt(now.minusDays(5));
        todo2.setUpdatedAt(now.minusDays(1));

        Todo todo3 = new Todo();
        todo3.setTitle("Faire les courses");
        todo3.setDescription("Acheter des fruits, légumes et produits laitiers");
        todo3.setCompleted(false);
        todo3.setPriority(3);
        todo3.setCreatedAt(now.minusDays(1));
        todo3.setUpdatedAt(now.minusDays(1));

        Todo todo4 = new Todo();
        todo4.setTitle("Réserver un restaurant pour vendredi");
        todo4.setDescription("Pour le dîner d'anniversaire");
        todo4.setCompleted(false);
        todo4.setPriority(2);
        todo4.setCreatedAt(now.minusDays(3));
        todo4.setUpdatedAt(now.minusDays(3));

        Todo todo5 = new Todo();
        todo5.setTitle("Payer les factures mensuelles");
        todo5.setDescription("Électricité, internet et assurance");
        todo5.setCompleted(true);
        todo5.setPriority(1);
        todo5.setCreatedAt(now.minusDays(10));
        todo5.setUpdatedAt(now.minusDays(5));

        todoRepository.saveAll(Arrays.asList(todo1, todo2, todo3, todo4, todo5));
    }
}
