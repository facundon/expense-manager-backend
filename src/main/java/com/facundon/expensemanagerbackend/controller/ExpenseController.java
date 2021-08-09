package com.facundon.expensemanagerbackend.controller;

import java.util.List;

import com.facundon.expensemanagerbackend.entity.Expense;
import com.facundon.expensemanagerbackend.service.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExpenseController {
   @Autowired
   private ExpenseService service;

   @PostMapping("/addExpense")
   public Expense addExpense(@RequestBody Expense expense) {
      return service.saveExpense(expense);
   }

   @GetMapping("/expenses")
   public List<Expense> findAllExpenses() {
      return service.getExpenses();
   }

   @GetMapping("/expense/{id}")
   public Expense findExpenseById(@PathVariable int id) {
      return service.getExpenseById(id);
   }

   @PutMapping("/update")
   public Expense updateExpense(@RequestBody Expense newExpense) {
      return service.updateExpense(newExpense);
   }

   @DeleteMapping("/delete/expense/{id}")
   public String deleteExpense(@PathVariable int id) {
      return service.deleteExpense(id);
   }
}
