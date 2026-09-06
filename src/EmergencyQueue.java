import model.Patient;
import java.util.LinkedList;
import java.util.Queue;

public class EmergencyQueue {
    Queue<Patient> queue = new LinkedList<>();

    public void enqueue(Patient p) {
        queue.add(p);
        System.out.println("Added: " + p.name);
    }

    public Patient dequeue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Patient p = queue.poll();
        System.out.println("Removed: " + p.name);
        return p;
    }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }
        System.out.println("Waiting Patients:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}