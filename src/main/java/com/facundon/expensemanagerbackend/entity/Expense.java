package com.facundon.expensemanagerbackend.entity;

import java.time.LocalDate;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OrderColumn;

import com.facundon.expensemanagerbackend.utils.Category;
import com.facundon.expensemanagerbackend.utils.Kind;
import com.facundon.expensemanagerbackend.utils.Months;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.lang.Nullable;

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
   private Kind kind;

   @Nullable
   @ColumnDefault(value="null")
   private LocalDate risedAt;

   @ElementCollection
   @OrderColumn
   @Enumerated(EnumType.STRING)
   private Months[] repeatMonth;
}
