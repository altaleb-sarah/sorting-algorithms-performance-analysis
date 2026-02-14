# Sorting Algorithms Performance Analysis (Java)

## Overview
This project implements and benchmarks three classical sorting algorithms using Java and Object-Oriented Programming principles.

Implemented algorithms:
- Insertion Sort
- Bubble Sort
- Quick Sort

The objective of this project is to analyze time complexity, performance behavior, and optimization techniques through experimental evaluation.

---

## Features
- OOP-based implementation in Java
- Performance benchmarking up to 1,000,000 elements
- Comparison across sorted, reversed, and random datasets
- Randomized pivot selection to prevent StackOverflowError in Quick Sort
- Complexity analysis (O(n), O(n²), O(n log n))

---

## Technologies Used
- Java
- Object-Oriented Programming (OOP)

---

## Key Learning Outcomes
- Practical understanding of algorithmic complexity
- Performance testing and benchmarking
- Handling recursion depth limitations
- Writing structured and modular Java code

---

## StackOverflowError Fix (QuickSort)

### Problem
While benchmarking Quick Sort on large datasets (especially sorted or nearly-sorted inputs), the algorithm sometimes triggered a `StackOverflowError`.
This happened because choosing a poor pivot (e.g., first/last element) repeatedly produces highly unbalanced partitions, causing recursion depth to grow close to `O(n)`.

### Solution
To reduce the probability of worst-case partitioning, I applied **randomized pivot selection**:
- Randomly select an index between `low` and `high`
- Swap the random element with the chosen pivot position
- Continue partitioning normally

This significantly reduces the chance of repeatedly hitting worst-case behavior and helps keep recursion depth closer to `O(log n)` in practice.
