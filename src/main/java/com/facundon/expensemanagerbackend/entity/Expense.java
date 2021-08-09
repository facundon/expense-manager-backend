package com.facundon.expensemanagerbackend.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.facundon.expensemanagerbackend.utils.Category;
import com.facundon.expensemanagerbackend.utils.Interval;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Expense {
   @Id
   @GeneratedValue
   private int id;

   private double value;

   private String concept;

   @Enumerated(EnumType.STRING)
   private Category category;

   @Enumerated(EnumType.STRING)
   private Interval paymentInterval;

   private int monthsLeft;
}
