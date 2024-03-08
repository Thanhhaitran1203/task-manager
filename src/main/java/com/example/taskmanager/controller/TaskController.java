package com.example.taskmanager.controller;

import com.example.taskmanager.model.Category;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.category.ICategoryService;
import com.example.taskmanager.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public Iterable<Category> listCategory(){
        return categoryService.findAll();
    }
    @GetMapping("")
    public ModelAndView listTask(){
        ModelAndView modelAndView = new ModelAndView("/task/index");
        Iterable<Task> tasks = taskService.findAll();
        modelAndView.addObject("tasks",tasks);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task",new Task());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("task") Task task){
        taskService.save(task);
        return "redirect:/task";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateForm(@PathVariable Long id) {
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/task/update");
            modelAndView.addObject("task", task.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("task") Task task,
                         RedirectAttributes redirect) {
        taskService.save(task);
        redirect.addFlashAttribute("message", "Update customer successfully");
        return "redirect:/task";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        taskService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/task";
    }
}
