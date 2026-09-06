import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data Structures
        PatientBST bst = new PatientBST();
        EmergencyQueue eq = new EmergencyQueue();
        TreatmentStack ts = new TreatmentStack();
        VisitLinkedList vll = new VisitLinkedList();

        // Preload Initial Sample Data silently
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream()));
        preloadSampleData(bst, eq, ts, vll);
        System.setOut(originalOut);

        boolean running = true;
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice (0-14): ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                String input = scanner.nextLine().trim();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\n[Error] Invalid input! Please enter a number between 0 and 14.\n");
                continue;
            }

            System.out.println();
            switch (choice) {
                case 1: // Add New Patient (BST)
                    System.out.println("--- Add New Patient (BST) ---");
                    try {
                        System.out.print("Enter Patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        if (bst.search(id) != null) {
                            System.out.println("[Error] Patient with ID " + id + " already exists!");
                            break;
                        }
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Contact: ");
                        String contact = scanner.nextLine().trim();
                        System.out.print("Enter Condition: ");
                        String condition = scanner.nextLine().trim();

                        Patient newPatient = new Patient(id, name, age, contact, condition);
                        bst.insert(newPatient);
                        System.out.println("Patient added successfully: " + newPatient);
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid number entered. Patient could not be added.");
                    }
                    break;

                case 2: // Search Patient by ID (BST)
                    System.out.println("--- Search Patient by ID (BST) ---");
                    try {
                        System.out.print("Enter Patient ID to search: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        Patient found = bst.search(id);
                        if (found != null) {
                            System.out.println("Patient Found: " + found);
                        } else {
                            System.out.println("Patient not found with ID: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid Patient ID.");
                    }
                    break;

                case 3: // Delete Patient by ID (BST)
                    System.out.println("--- Delete Patient by ID (BST) ---");
                    try {
                        System.out.print("Enter Patient ID to delete: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        Patient existing = bst.search(id);
                        if (existing != null) {
                            bst.delete(id);
                            System.out.println("Patient with ID " + id + " deleted successfully.");
                        } else {
                            System.out.println("Patient not found with ID: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid Patient ID.");
                    }
                    break;

                case 4: // Display All Patients (BST)
                    System.out.println("--- All Patients (Ascending ID Order) ---");
                    bst.inorder();
                    break;

                case 5: // Add Patient to Emergency Waiting Queue
                    System.out.println("--- Add Patient to Emergency Waiting Queue ---");
                    try {
                        System.out.print("Enter Patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Contact: ");
                        String contact = scanner.nextLine().trim();
                        System.out.print("Enter Emergency Condition: ");
                        String condition = scanner.nextLine().trim();

                        Patient ep = new Patient(id, name, age, contact, condition);
                        eq.enqueue(ep);
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid number entered. Patient could not be added to queue.");
                    }
                    break;

                case 6: // Process Next Patient in Queue
                    System.out.println("--- Process Next Patient in Queue ---");
                    Patient processed = eq.dequeue();
                    if (processed != null) {
                        System.out.println("Currently treating: " + processed);
                    }
                    break;

                case 7: // Show Emergency Waiting List
                    System.out.println("--- Emergency Waiting List ---");
                    eq.display();
                    break;

                case 8: // Add Treatment Record (Stack)
                    System.out.println("--- Add Treatment Record (Stack) ---");
                    try {
                        System.out.print("Enter Patient ID: ");
                        int patientId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter Treatment / Medication: ");
                        String treatment = scanner.nextLine().trim();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine().trim();

                        TreatmentRecord tr = new TreatmentRecord(patientId, treatment, date);
                        ts.push(tr);
                    } catch (NumberFormatException e) {
                        System.out.println("[Error] Invalid Patient ID entered.");
                    }
                    break;

                case 9: // Remove Last Treatment Record (Undo) (Stack)
                    System.out.println("--- Remove Last Treatment Record (Undo) ---");
                    ts.pop();
                    break;

                case 10: // Show Completed Treatment History (Stack)
                    System.out.println("--- Completed Treatment History ---");
                    ts.display();
                    break;

                case 11: // Add Visit Record to Patient (SinglyLinkedList)
                    System.out.println("--- Add Visit Record to Patient (SinglyLinkedList) ---");
                    System.out.print("Enter Visit ID (e.g. V001): ");
                    String visitId = scanner.nextLine().trim();
                    System.out.print("Enter Date (YYYY-MM-DD): ");
                    String vDate = scanner.nextLine().trim();
                    System.out.print("Enter Doctor Name: ");
                    String doctor = scanner.nextLine().trim();
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine().trim();
                    System.out.print("Enter Treatment / Prescription: ");
                    String vTreatment = scanner.nextLine().trim();

                    Visit visit = new Visit(visitId, vDate, doctor, diagnosis, vTreatment);
                    vll.add(visit);
                    break;

                case 12: // Remove Visit Record from Patient (SinglyLinkedList)
                    System.out.println("--- Remove Visit Record from Patient ---");
                    System.out.print("Enter Visit ID to remove: ");
                    String remVisitId = scanner.nextLine().trim();
                    vll.remove(remVisitId);
                    break;

                case 13: // Search Visit Record in Patient (SinglyLinkedList)
                    System.out.println("--- Search Visit Record in Patient ---");
                    System.out.print("Enter Visit ID to search: ");
                    String searchVisitId = scanner.nextLine().trim();
                    vll.search(searchVisitId);
                    break;

                case 14: // Display Visit History of Patient (SinglyLinkedList)
                    System.out.println("--- Patient Visit History ---");
                    vll.display();
                    break;

                case 0: // Exit
                    System.out.println("==================================================================");
                    System.out.println("         Thank you for using Hospital Management System!          ");
                    System.out.println("==================================================================");
                    running = false;
                    break;

                default:
                    System.out.println("[Error] Choice out of range! Please enter a number from 0 to 14.");
                    break;
            }
            System.out.println();
        }
        } catch (java.util.NoSuchElementException e) {
            System.out.println("\n[Session terminated. Goodbye!]");
        } finally {
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("==================================================================");
        System.out.println("                        MAIN CONSOLE MENU                         ");
        System.out.println("==================================================================");
        System.out.println("--- Patient Records Management (BST) ---");
        System.out.println("  1. Add New Patient");
        System.out.println("  2. Search Patient by ID");
        System.out.println("  3. Delete Patient by ID");
        System.out.println("  4. Display All Patients (Ascending ID Order)");
        System.out.println();
        System.out.println("--- Emergency Queue Management (Queue) ---");
        System.out.println("  5. Add Patient to Emergency Waiting Queue");
        System.out.println("  6. Process Next Patient in Queue");
        System.out.println("  7. Show Emergency Waiting List");
        System.out.println();
        System.out.println("--- Treatment History Management (Stack) ---");
        System.out.println("  8. Add Treatment Record");
        System.out.println("  9. Remove Last Treatment Record (Undo)");
        System.out.println(" 10. Show Completed Treatment History");
        System.out.println();
        System.out.println("--- Patient Visit History Management (SinglyLinkedList) ---");
        System.out.println(" 11. Add Visit Record to Patient");
        System.out.println(" 12. Remove Visit Record from Patient");
        System.out.println(" 13. Search Visit Record in Patient");
        System.out.println(" 14. Display Visit History of Patient");
        System.out.println();
        System.out.println("  0. Exit System");
        System.out.println("==================================================================");
    }

    private static void preloadSampleData(PatientBST bst, EmergencyQueue eq, TreatmentStack ts, VisitLinkedList vll) {
        // Preload BST Patients
        bst.insert(new Patient(103, "Arun", 45, "9876543210", "Fever"));
        bst.insert(new Patient(101, "Priya", 30, "9876543211", "Cough"));
        bst.insert(new Patient(102, "Ravi", 50, "9876543212", "Diabetes"));
        bst.insert(new Patient(105, "Sita", 28, "9876543213", "Allergy"));
        bst.insert(new Patient(104, "Kumar", 35, "9876543214", "Asthma"));

        // Preload Emergency Queue
        eq.enqueue(new Patient(201, "Suresh", 40, "9988776655", "Accident"));
        eq.enqueue(new Patient(202, "Meena", 25, "9988776656", "Heart Pain"));
        eq.enqueue(new Patient(203, "Vijay", 55, "9988776657", "Stroke"));

        // Preload Treatment Stack
        ts.push(new TreatmentRecord(101, "Paracetamol", "2026-01-10"));
        ts.push(new TreatmentRecord(102, "Insulin", "2026-01-11"));
        ts.push(new TreatmentRecord(103, "Antibiotics", "2026-01-12"));

        // Preload Visit Linked List
        vll.add(new Visit("V001", "2026-01-01", "Dr. Siva", "Cold", "Rest"));
        vll.add(new Visit("V002", "2026-01-05", "Dr. Ram", "Fever", "Paracetamol"));
        vll.add(new Visit("V003", "2026-01-10", "Dr. Priya", "Infection", "Antibiotics"));

        System.out.println("[System] Sample records preloaded successfully.\n");
    }
}

