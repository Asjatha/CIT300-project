import model.TreatmentRecord;
import java.util.Stack;

public class TreatmentStack {
    Stack<TreatmentRecord> stack = new Stack<>();

    public void push(TreatmentRecord record) {
        stack.push(record);
        System.out.println("Treatment added: " + record.treatment);
    }

    public TreatmentRecord pop() {
        if (stack.isEmpty()) {
            System.out.println("No treatment records!");
            return null;
        }
        TreatmentRecord r = stack.pop();
        System.out.println("Removed: " + r.treatment);
        return r;
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("No treatment history.");
            return;
        }
        System.out.println("Treatment History (Recent first):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
