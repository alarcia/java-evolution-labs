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

| Feature Area | Legacy Approach | Modern Approach |
| :--- | :--- | :--- |
| **Variable Declaration** | Explicit typing (`List<String> h = ...`) | **Local Type Inference** (`var h = ...`) |
| **Collections** | Mutable, verbose (`new ArrayList` + `.add`) | **Factory Methods** (`List.of()`) |
| **Multi-line Strings** | Concatenation hell (`"{\n" + val + "\n}"`) | **Text Blocks** (`""" ... """`) |
| **String Validation** | `str != null && !str.trim().isEmpty()` | **Methods** (`str.isBlank()`) |
| **File I/O** | `BufferedReader` loop inside try-catch | **NIO 2** (`Files.readString()`) <br/>|

### 🧪 Lab 02: Data Modeling with Records
**Goal:** Simplify data transfer objects (DTOs) by enforcing immutability and eliminating boilerplate code.

| Feature Area | Legacy Approach | Modern Approach |
| :--- | :--- | :--- |
| **Class Definition** | Verbose (`private final` fields + Constructor) | **Compact Header** (`record Name(...)`) |
| **Boilerplate** | Manual `equals`, `hashCode`, `toString` | **Auto-generated** by Compiler |
| **Data Access** | Java Bean Getters (`getAmount()`) | **Fluent Accessors** (`amount()`) |
| **Validation** | Manual checks inside full constructor | **Compact Constructor** (Validation logic only) |
| **Mutability** | Mutable Setters (`setAmount(...)`) | **Immutable** (Use "Wither" pattern for copies) |

### 🧪 Lab 03: Switch Expressions
**Goal:** Reduce cyclomatic complexity and prevent logical bugs by using exhaustive, functional switch expressions.

| Feature Area | Legacy Approach | Modern Approach |
| :--- | :--- | :--- |
| **Structure** | Control Flow Statement (`switch ... case: break;`) | **Functional Expression** (`var res = switch(...)`) |
| **Fall-through** | Accidental (Missing `break` executes next case) | **No Fall-through** (Arrow syntax `->` is precise) |
| **Return Value** | Must assign to external variable | **Direct Return** (Returns value or uses `yield`) |
| **Safety** | Compiler ignores missing Enum cases | **Exhaustiveness Check** (Compiler error if case missing) |

### 🧪 Lab 04: Pattern Matching & Type Switches
**Goal:** Remove explicit casting and simplify polymorphic logic using type patterns.

| Feature Area | Legacy Approach (Java 8) | Modern Approach (Java 21) |
| :--- | :--- | :--- |
| **Type Checking** | `if (obj instanceof String)` | `if (obj instanceof String s)` |
| **Casting** | Manual: `String s = (String) obj;` | **Automatic**: Variable injected instantly |
| **Control Flow** | Cascade of `if-else if-else` | **Pattern Switch** (`case Integer i ->`) |
| **Conditional Logic** | Nested `if` inside the block | **Guarded Patterns** (`case ... when ...`) |
| **Null Handling** | Explodes or requires explicit check | `case null ->` supported |

### 🧪 Lab 05: Sequenced Collections
**Goal:** Unify access to the first and last elements across different collection types.

| Feature Area | Legacy Approach (Java 8) | Modern Approach (Java 21) |
| :--- | :--- | :--- |
| **Get First** | `list.get(0)` vs `set.iterator().next()` | **Unified:** `coll.getFirst()` |
| **Get Last** | `list.get(size-1)` vs `Manual Loop` | **Unified:** `coll.getLast()` (O(1)) |
| **Reverse View** | `Collections.reverse(list)` (Mutates!) | **Unified:** `coll.reversed()` (Lightweight View) |
| **Hierarchy** | Fragmented (`Deque`, `List`, `SortedSet`) | **Unified Interface:** `SequencedCollection` |