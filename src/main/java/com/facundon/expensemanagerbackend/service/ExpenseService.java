package com.facundon.expensemanagerbackend.service;

import java.time.LocalDate;
import java.util.List;

import com.facundon.expensemanagerbackend.entity.Expense;
import com.facundon.expensemanagerbackend.repository.ExpenseRepository;
import com.facundon.expensemanagerbackend.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
   @Autowired
   private ExpenseRepository repository;

   public Expense saveExpense(Expense expense) {
      return repository.save(expense);
   }

   public List<Expense> getExpenses() {
      return repository.findAll();
   }

   public Expense getExpenseById(int id) {
      return repository.findById(id).orElse(null);
   }

   public String deleteExpense(int id) {
      repository.deleteById(id);
      return "deleted" + id;
   }

   public Expense updateExpense(Expense newExpense) {
      Expense existingExpense = repository.findById(newExpense.getId()).orElse(null);
      existingExpense.setConcept(newExpense.getConcept());
      existingExpense.setValue(newExpense.getValue());
      existingExpense.setCategory(newExpense.getCategory());
      LocalDate today = DateUtils.getTodayDate();
      existingExpense.setRisedAt(today);
      return repository.save(existingExpense);
   }
 }
