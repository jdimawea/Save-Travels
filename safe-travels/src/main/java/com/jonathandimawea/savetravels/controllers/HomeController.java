package com.jonathandimawea.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jonathandimawea.savetravels.models.Expense;
import com.jonathandimawea.savetravels.services.ExpenseService;

@Controller
public class HomeController {
	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/")
	public String dashboard(Model model) {
		List<Expense> icecreams = expenseService.allExpenses();
		model.addAttribute("icecreams", icecreams);
		return "dashboard.jsp";
	}

	@GetMapping("/expenses/{id}")
	public String showOneExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "showOne.jsp";
	}

	// --------------------------- CREATE ------------------------------------
	// CREATE -- Get to render a form, post to process the form

	// RENDER CREATE FORM
	// OPTION 1
	@GetMapping("/expenses/new")
	public String createForm(@ModelAttribute("expense") Expense expense) {
		return "createForm.jsp";
	}

	@PostMapping("/expenses/new")
	public String processCreate(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	@GetMapping("/expenses")
	public String dashboardForm(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}

	// PROCESS THE CREATE FORM (POST)
	@PostMapping("/expenses")
	public String processDashboardCreate(@Valid @ModelAttribute("expense")Expense expense, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	// ------------------------- EDIT ---------------------------------
	// findOne + create

	@GetMapping("/expenses/edit/{id}")
	public String editForm(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "editForm.jsp";
	}

	@PutMapping("/expenses/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "editForm.jsp";
		} else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	
}
