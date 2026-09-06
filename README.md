# CIT300 Data Structures Assignment - Hospital Management System

[![Java Version](https://img.shields.io/badge/Java-JDK%208%20or%20higher-orange.svg)](#prerequisites)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Status](https://img.shields.io/badge/Status-Completed%20%26%20Verified-brightgreen.svg)](#verification-and-testing)

---

## 📌 Student Details

- **Student Name:** IL.Asjatha
- **Student ID:** 23DA2-1088
- **Course:** CIT300 - Data Structures and Algorithms
- **Project Title:** Hospital Management System
- **Date:** 2026-09-06

---

## 📖 Table of Contents

1. [Project Overview](#-project-overview)
2. [Data Structures & Architecture](#-data-structures--architecture)
   - [1. Binary Search Tree (BST)](#1-binary-search-tree-bst---patient-records)
   - [2. Queue (FIFO)](#2-queue-fifo---emergency-waiting-queue)
   - [3. Stack (LIFO)](#3-stack-lifo---treatment-history)
   - [4. Singly Linked List](#4-singly-linked-list---patient-visit-history)
3. [Time & Space Complexity Analysis](#-time--space-complexity-analysis)
4. [Directory & File Structure](#-directory--file-structure)
5. [Interactive Console Menu (Options 0–14)](#-interactive-console-menu-options-014)
6. [Prerequisites & Environment Setup](#-prerequisites--environment-setup)
7. [How to Compile and Run](#-how-to-compile-and-run)
8. [Sample Test Scenarios & Outputs](#-sample-test-scenarios--outputs)
9. [Error Handling & Robustness](#-error-handling--robustness)
10. [Future Enhancements](#-future-enhancements)

---

## 🏥 Project Overview

The **Hospital Management System** is a Java application designed to demonstrate the practical, real-world application of foundational **Data Structures and Algorithms (DSA)** in hospital administration.

Hospitals handle large streams of diverse data with distinct access patterns:
- Rapid indexing and retrieval of registered patients.
- Strictly fair, ordered handling of incoming emergency cases.
- Reversible tracking of clinical treatments and medications.
- Flexible, chronological recording of patient-doctor visits.

To address these requirements, this system integrates **four fundamental data structures**:
1. **Binary Search Tree (BST)** for hierarchical, sorted patient record indexing.
2. **Queue (FIFO)** for emergency triage and patient waiting queues.
3. **Stack (LIFO)** for clinical treatment logging and undo operations.
4. **Singly Linked List** for dynamic doctor visit histories.

---

## 🧩 Data Structures & Architecture

### 1. Binary Search Tree (BST) - Patient Records
- **Class:** `PatientBST.java` (with inner `Node`)
- **Key Property:** For any node with patient ID $k$, all nodes in the left subtree have ID $< k$, and all nodes in the right subtree have ID $> k$.
- **Operations:**
  - `insert(Patient p)`: Recursively traverses and inserts the patient at the correct leaf position.
  - `search(int id)`: Efficiently searches by key in logarithmic time.
  - `delete(int id)`: Handles three deletion cases (leaf node, one child, two children via in-order successor).
  - `inorder()`: Performs in-order traversal (Left $\to$ Root $\to$ Right) to print all patients sorted in ascending order by ID.

### 2. Queue (FIFO) - Emergency Waiting Queue
- **Class:** `EmergencyQueue.java`
- **Principle:** First-In, First-Out (FIFO).
- **Operations:**
  - `enqueue(Patient p)`: Adds incoming emergency patients to the rear of the queue.
  - `dequeue()`: Dequeues the next patient from the front for medical attention.
  - `display()`: Displays all patients currently waiting in order of arrival.
  - `isEmpty()`: Checks if there are waiting patients.

### 3. Stack (LIFO) - Treatment History
- **Class:** `TreatmentStack.java`
- **Principle:** Last-In, First-Out (LIFO).
- **Operations:**
  - `push(TreatmentRecord record)`: Pushes a new treatment or medication event onto the top of the stack.
  - `pop()`: Pops and removes the most recent treatment record (enabling undo / rollback of mistakenly logged treatments).
  - `display()`: Iterates from top to bottom, displaying the most recent treatments first.
  - `isEmpty()`: Checks if treatment history is empty.

### 4. Singly Linked List - Patient Visit History
- **Class:** `VisitLinkedList.java` (with `VisitNode`)
- **Structure:** Dynamic linked nodes where each `VisitNode` references the next visit node.
- **Operations:**
  - `add(Visit v)`: Inserts a new doctor visit at the head in $O(1)$ constant time.
  - `remove(String visitId)`: Searches and unlinks a visit record by its identifier.
  - `search(String visitId)`: Traverses the list to find visit details (date, doctor, diagnosis, treatment).
  - `display()`: Traverses and prints all recorded visits from newest to oldest.

---

## ⚡ Time & Space Complexity Analysis

| Data Structure | Primary Operation | Average Time Complexity | Worst Case Time Complexity | Space Complexity |
|:---|:---|:---:|:---:|:---:|
| **Binary Search Tree** | Search by ID | $O(\log n)$ | $O(n)$ (skewed tree) | $O(n)$ |
| | Insert Patient | $O(\log n)$ | $O(n)$ | $O(1)$ auxiliary |
| | Delete Patient | $O(\log n)$ | $O(n)$ | $O(1)$ auxiliary |
| | Inorder Traversal | $O(n)$ | $O(n)$ | $O(h)$ call stack |
| **Emergency Queue** | Enqueue | $O(1)$ | $O(1)$ | $O(n)$ |
| | Dequeue | $O(1)$ | $O(1)$ | $O(1)$ |
| | Display | $O(n)$ | $O(n)$ | $O(1)$ |
| **Treatment Stack** | Push | $O(1)$ | $O(1)$ | $O(n)$ |
| | Pop (Undo) | $O(1)$ | $O(1)$ | $O(1)$ |
| | Display | $O(n)$ | $O(n)$ | $O(1)$ |
| **Singly Linked List** | Add Head | $O(1)$ | $O(1)$ | $O(n)$ |
| | Remove by ID | $O(n)$ | $O(n)$ | $O(1)$ |
| | Search by ID | $O(n)$ | $O(n)$ | $O(1)$ |
| | Display | $O(n)$ | $O(n)$ | $O(1)$ |

---

## 📁 Directory & File Structure

```text
CIT300_Mid_Assignment/
│
├── bin/                             # Compiled bytecode (.class files)
│   ├── EmergencyQueue.class
│   ├── Main.class
│   ├── Node.class
│   ├── PatientBST.class
│   ├── TreatmentStack.class
│   ├── VisitLinkedList.class
│   ├── VisitNode.class
│   └── model/
│       ├── Patient.class
│       ├── TreatmentRecord.class
│       └── Visit.class
│
├── src/                             # Java Source Code
│   ├── EmergencyQueue.java          # Queue data structure implementation
│   ├── Main.java                    # Main application & interactive console menu
│   ├── PatientBST.java              # Binary Search Tree implementation
│   ├── TreatmentStack.java          # Stack data structure implementation
│   ├── VisitLinkedList.java         # Singly Linked List implementation
│   └── model/                       # Data Model Classes
│       ├── Patient.java             # Patient entity (id, name, age, contact, condition)
│       ├── TreatmentRecord.java     # Treatment record entity (patientId, treatment, date)
│       └── Visit.java               # Visit record entity (visitId, date, doctor, diagnosis, treatment)
│
├── screenshots/                     # Project screenshots & execution results
├── .gitignore                       # Git ignore configuration
└── README.md                        # Complete project documentation (A to Z)
```

---

## 🖥️ Interactive Console Menu (Options 0–14)

When `Main` is executed, the following console menu is displayed:

```text
==================================================================
                        MAIN CONSOLE MENU                         
==================================================================
--- Patient Records Management (BST) ---
  1. Add New Patient
  2. Search Patient by ID
  3. Delete Patient by ID
  4. Display All Patients (Ascending ID Order)

--- Emergency Queue Management (Queue) ---
  5. Add Patient to Emergency Waiting Queue
  6. Process Next Patient in Queue
  7. Show Emergency Waiting List

--- Treatment History Management (Stack) ---
  8. Add Treatment Record
  9. Remove Last Treatment Record (Undo)
 10. Show Completed Treatment History

--- Patient Visit History Management (SinglyLinkedList) ---
 11. Add Visit Record to Patient
 12. Remove Visit Record from Patient
 13. Search Visit Record in Patient
 14. Display Visit History of Patient

  0. Exit System
==================================================================
Enter your choice (0-14): 
```

### Detailed Menu Reference

| Option | Category | Action | Inputs Requested | Output / Behavior |
|:---:|:---|:---|:---|:---|
| **1** | BST | Add New Patient | ID, Name, Age, Contact, Condition | Inserts patient into BST (validates duplicate ID). |
| **2** | BST | Search Patient by ID | Patient ID | Displays patient info or "Not found". |
| **3** | BST | Delete Patient by ID | Patient ID | Removes patient from BST tree. |
| **4** | BST | Display All Patients | *None* | Prints all registered patients in ascending ID order. |
| **5** | Queue | Enqueue Patient | ID, Name, Age, Contact, Emergency Condition | Adds patient to emergency waiting queue. |
| **6** | Queue | Process Next Patient | *None* | Removes and displays the first patient in line. |
| **7** | Queue | Show Waiting List | *None* | Lists all patients currently waiting in queue. |
| **8** | Stack | Add Treatment Record | Patient ID, Treatment, Date | Pushes treatment onto the stack. |
| **9** | Stack | Undo Treatment | *None* | Pops and removes the most recent treatment record. |
| **10** | Stack | Show Treatment History | *None* | Displays treatment log in reverse chronological order. |
| **11** | Linked List | Add Visit Record | Visit ID, Date, Doctor, Diagnosis, Treatment | Prepends a new visit node to the head of the list. |
| **12** | Linked List | Remove Visit Record | Visit ID | Searches and deletes matching visit record. |
| **13** | Linked List | Search Visit Record | Visit ID | Displays matching visit record details. |
| **14** | Linked List | Display Visit History | *None* | Prints full visit history from newest to oldest. |
| **0** | System | Exit System | *None* | Displays exit message and terminates safely. |

---

## 🛠️ Prerequisites & Environment Setup

- **Java Development Kit (JDK):** Version 8, 11, 17, 21, or higher.
- **Operating System:** Windows, macOS, or Linux.
- **Terminal:** PowerShell, Command Prompt (CMD), Bash, or any IDE terminal.

Verify your Java installation:
```bash
java -version
javac -version
```

---

## 🚀 How to Compile and Run

### Step 1: Open Terminal in Project Folder
Ensure your working directory is the project root:
```bash
cd CIT300_Mid_Assignment
```

### Step 2: Compile the Java Files
Compile all Java classes into the `bin` directory:

- **Windows (PowerShell):**
```powershell
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
```

- **Windows (CMD) / Linux / macOS:**
```bash
javac -d bin src/*.java src/model/*.java
```

### Step 3: Run the Application
Run the interactive console menu:
```bash
java -cp bin Main
```

*(Optional alternative: run directly from `src`)*:
```bash
java -cp src Main
```

---

## 🧪 Sample Test Scenarios & Outputs

### Scenario 1: Display Preloaded Patients (Option 4)
```text
Enter your choice (0-14): 4

--- All Patients (Ascending ID Order) ---
101 | Priya | 30 | 9876543211 | Cough
102 | Ravi | 50 | 9876543212 | Diabetes
103 | Arun | 45 | 9876543210 | Fever
104 | Kumar | 35 | 9876543214 | Asthma
105 | Sita | 28 | 9876543213 | Allergy
```

### Scenario 2: Search Patient by ID (Option 2)
```text
Enter your choice (0-14): 2

--- Search Patient by ID (BST) ---
Enter Patient ID to search: 102
Patient Found: 102 | Ravi | 50 | 9876543212 | Diabetes
```

### Scenario 3: Process Emergency Queue (Option 6 & 7)
```text
Enter your choice (0-14): 6

--- Process Next Patient in Queue ---
Removed: Suresh
Currently treating: 201 | Suresh | 40 | 9988776655 | Accident

Enter your choice (0-14): 7

--- Emergency Waiting List ---
Waiting Patients:
202 | Meena | 25 | 9988776656 | Heart Pain
203 | Vijay | 55 | 9988776657 | Stroke
```

### Scenario 4: Undo Treatment Record (Option 9 & 10)
```text
Enter your choice (0-14): 9

--- Remove Last Treatment Record (Undo) ---
Removed: Antibiotics

Enter your choice (0-14): 10

--- Completed Treatment History ---
Treatment History (Recent first):
102 | Insulin | 2026-01-11
101 | Paracetamol | 2026-01-10
```

### Scenario 5: Search & Remove Visit Record (Option 13 & 12)
```text
Enter your choice (0-14): 13

--- Search Visit Record in Patient ---
Enter Visit ID to search: V001
Found: V001 | 2026-01-01 | Dr. Siva | Cold | Rest

Enter your choice (0-14): 12

--- Remove Visit Record from Patient ---
Enter Visit ID to remove: V001
Visit V001 removed.
```

---

## 🛡️ Error Handling & Robustness

The system implements defensive programming techniques:
1. **Invalid Choice Handling:** Inputs outside `0-14` or non-integer values display helpful guidance without crashing.
2. **Duplicate ID Prevention:** In BST insertion, checks ensure unique patient identification numbers.
3. **Stream & EOF Protection:** Terminal closing or EOF streams are intercepted to prevent `NoSuchElementException` crashes.
4. **Empty State Guards:** Queue, Stack, and Linked List routines provide informative notices when operations are attempted on empty collections.

---

## 🔮 Future Enhancements

- [ ] **Data Persistence:** Save and load records to/from JSON or SQL databases.
- [ ] **Balanced Trees:** Upgrade BST to AVL Tree or Red-Black Tree to guarantee $O(\log n)$ worst-case height.
- [ ] **Priority Queue:** Integrate clinical triage severity scores (e.g. Critical, Moderate, Stable) using a Min-Heap/Max-Heap Priority Queue.
- [ ] **Graphical User Interface (GUI):** Build a modern JavaFX or Web frontend.

---

## 📄 License & Acknowledgements

Developed as part of the **CIT300 Data Structures and Algorithms** curriculum. All core data structures and logic are implemented cleanly for academic demonstration and evaluation.