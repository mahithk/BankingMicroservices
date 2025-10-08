package com.example.demo.controller;

import com.example.demo.model.Transaction;
import com.example.demo.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")   // 👈 Base path
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction txn) {
        return transactionRepository.save(txn);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
    }
}
