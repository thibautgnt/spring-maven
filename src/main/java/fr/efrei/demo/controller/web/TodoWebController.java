package fr.efrei.demo.controller.web;

import fr.efrei.demo.model.Todo;
import fr.efrei.demo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todos")
public class TodoWebController {

    private final TodoService todoService;

    @Autowired
    public TodoWebController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        model.addAttribute("newTodo", new Todo());
        return "todo/list";
    }

    @GetMapping("/completed")
    public String listCompletedTodos(Model model) {
        model.addAttribute("todos", todoService.getCompletedTodos());
        model.addAttribute("newTodo", new Todo());
        model.addAttribute("filterActive", "completed");
        return "todo/list";
    }

    @GetMapping("/active")
    public String listActiveTodos(Model model) {
        model.addAttribute("todos", todoService.getActiveTodos());
        model.addAttribute("newTodo", new Todo());
        model.addAttribute("filterActive", "active");
        return "todo/list";
    }

    @GetMapping("/search")
    public String searchTodos(@RequestParam String keyword, Model model) {
        model.addAttribute("todos", todoService.searchTodos(keyword));
        model.addAttribute("newTodo", new Todo());
        model.addAttribute("searchKeyword", keyword);
        return "todo/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "todo/create";
    }

    @PostMapping
    public String createTodo(@Valid @ModelAttribute("todo") Todo todo, 
                             BindingResult result, 
                             RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "todo/create";
        }
        
        todoService.createTodo(todo);
        attributes.addFlashAttribute("success", "Tâche créée avec succès!");
        return "redirect:/todos";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("todo", todoService.getTodoById(id));
        return "todo/edit";
    }

    @PostMapping("/{id}")
    public String updateTodo(@PathVariable Long id, 
                             @Valid @ModelAttribute("todo") Todo todo, 
                             BindingResult result, 
                             RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "todo/edit";
        }
        
        todoService.updateTodo(id, todo);
        attributes.addFlashAttribute("success", "Tâche mise à jour avec succès!");
        return "redirect:/todos";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTodoStatus(@PathVariable Long id, RedirectAttributes attributes) {
        Todo todo = todoService.toggleTodoStatus(id);
        String status = todo.isCompleted() ? "terminée" : "active";
        attributes.addFlashAttribute("success", "Tâche marquée comme " + status + "!");
        return "redirect:/todos";
    }

    @GetMapping("/{id}/delete")
    public String deleteTodo(@PathVariable Long id, RedirectAttributes attributes) {
        todoService.deleteTodo(id);
        attributes.addFlashAttribute("success", "Tâche supprimée avec succès!");
        return "redirect:/todos";
    }
}
