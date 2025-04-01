package fr.efrei.demo.repository;

import fr.efrei.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    List<Todo> findByCompletedTrue();
    
    List<Todo> findByCompletedFalse();
    
    @Query("SELECT t FROM Todo t ORDER BY t.priority ASC")
    List<Todo> findAllOrderByPriorityAsc();
    
    List<Todo> findByTitleContainingIgnoreCase(String keyword);
}
