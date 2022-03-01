package com.jonathandimawea.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jonathandimawea.savetravels.models.Expense;
import com.jonathandimawea.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	// OPTION 1
	// adding the book repository as a dependency
	private final ExpenseRepository expenseRepo;

	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}

	// FindAll
	public List<Expense> allExpenses() {
		return expenseRepo.findAll();
	}

	// Create
	public Expense createExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	// ShowOne
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepo.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}

	// updateOne --- findOne + create
	// Option 1
	public Expense updateExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	// deleteOne
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

}
