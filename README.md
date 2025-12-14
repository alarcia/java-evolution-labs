# Java Evolution Labs 🧪

**Mastering the Modern Java Ecosystem through Refactoring**

This repository serves as a technical reference for modernizing Java applications. It demonstrates key language features and architectural improvements by contrasting legacy implementation patterns with modern, idiomatic solutions.

## 🎯 Project Goal
The primary objective is to highlight the **"Delta"** in Java development—showcasing how code readability, safety, and performance have evolved over the years.

Rather than theoretical documentation, this project uses a **"Refactoring-First"** approach. Each lab presents a specific coding scenario, dissecting the transformation from verbose, imperative code to concise, functional, and modern standards.

## 🛠 Methodology
The repository focuses on practical scenarios encountered in enterprise development:
* **Syntax Modernization:** Reducing boilerplate and improving expressiveness.
* **Data Modeling:** Transitioning from traditional POJOs to immutable data carriers.
* **Concurrency:** shifting from platform threads to scalable virtual threads.
* **Flow Control:** Leveraging pattern matching and improved switching logic.

## 📂 Repository Structure
Each "Micro-Lab" is self-contained and organized to facilitate direct comparison:

```text
/java-evolution-labs
  /01-lab-concept-name
     /legacy  (Traditional implementation style)
     /modern  (Refactored implementation using latest features)
```

### 🧪 Lab 01: Syntax Cleanup & Boilerplate Reduction
**Goal:** Eliminate visual noise and imperative plumbing to focus on business logic.

| Feature Area | Legacy Approach (Java 8) | Modern Approach (Java 21) |
| :--- | :--- | :--- |
| **Variable Declaration** | Explicit typing (`List<String> h = ...`) | **Local Type Inference** (`var h = ...`) |
| **Collections** | Mutable, verbose (`new ArrayList` + `.add`) | **Factory Methods** (`List.of()`) |
| **Multi-line Strings** | Concatenation hell (`"{\n" + val + "\n}"`) | **Text Blocks** (`""" ... """`) |
| **String Validation** | `str != null && !str.trim().isEmpty()` | **Methods** (`str.isBlank()`) |
| **File I/O** | `BufferedReader` loop inside try-catch | **NIO 2** (`Files.readString()`) |