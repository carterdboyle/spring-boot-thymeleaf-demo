//package com.example.springboot.controller;
//
//import com.example.springboot.model.Employee;
//import com.example.springboot.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    // display list of employees for homepage index.html
//    @GetMapping("/")
//    public String viewHomePage(Model model) {
//        return findPaginated(1, "firstName", "asc", model);
//    }
//
//    @GetMapping("/showNewEmployeeForm")
//    public String showNewEmployeeForm(Model model) {
//        // Create model attribute to bind form data
//        Employee employee = new Employee();
//        model.addAttribute("employee", employee);
//        return "new_employee";
//    }
//
//    @PostMapping("/saveEmployee")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
//        // save employee to database
//        employeeService.saveEmployee(employee);
//        return "redirect:/";
//    }
//
//    @GetMapping("/showFormForUpdate/{id}")
//    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
//        // Get the employee from the service based on the id
//        Employee employee = employeeService.getEmployeeById(id);
//
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("employee", employee);
//        return "update_employee";
//    }
//
//    @GetMapping("/deleteEmployee/{id}")
//    public String deleteEmployee(@PathVariable(value = "id") long id) {
//
//        // delete method from service
//        employeeService.deleteEmployeeById(id);
//
//        return "redirect:/";
//    }
//
//    @GetMapping("/page/{pageNo}")
//    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
//                                @RequestParam("sortField") String sortField,
//                                @RequestParam("sortDirection") String sortDirection,
//                                Model model) {
//        int pageSize = 5;
//
//        Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDirection);
//        List<Employee> listEmployees = page.getContent();
//
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalItems", page.getTotalElements());
//
//        model.addAttribute("sortField", sortField);
//        model.addAttribute("sortDirection", sortDirection);
//        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? "desc" : "asc");
//
//        model.addAttribute("listEmployees", listEmployees);
//
//        return "index";
//    }
//
//}
