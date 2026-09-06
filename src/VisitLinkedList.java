import model.Visit;

class VisitNode {
    Visit visit;
    VisitNode next;
    
    VisitNode(Visit v) {
        visit = v;
        next = null;
    }
}

public class VisitLinkedList {
    VisitNode head;

    public void add(Visit v) {
        VisitNode newNode = new VisitNode(v);
        newNode.next = head;
        head = newNode;
        System.out.println("Visit added: " + v.visitId);
    }
    public void remove(String visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return;
        }
        if (head.visit.visitId.equals(visitId)) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }
        VisitNode curr = head;
        while (curr.next != null && !curr.next.visit.visitId.equals(visitId)) {
            curr = curr.next;
        }
        if (curr.next != null) {
            curr.next = curr.next.next;
            System.out.println("Visit " + visitId + " removed.");
        } else {
            System.out.println("Visit ID not found.");
        }
    }
    public Visit search(String visitId) {
        VisitNode curr = head;
        while (curr != null) {
            if (curr.visit.visitId.equals(visitId)) {
                System.out.println("Found: " + curr.visit);
                return curr.visit;
            }
            curr = curr.next;
        }
        System.out.println("Visit ID not found.");
        return null;
    }
    public void display() {
        if (head == null) {
            System.out.println("No visit history.");
            return;
        }
        System.out.println("Visit History:");
        VisitNode curr = head;
        while (curr != null) {
            System.out.println(curr.visit);
            curr = curr.next;
        }
    }
}
