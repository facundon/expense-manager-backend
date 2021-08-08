package com.facundon.expensemanagerbackend.repository;

import com.facundon.expensemanagerbackend.entity.Expense;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
}
