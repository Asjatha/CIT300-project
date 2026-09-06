import model.Patient;

class Node {
    Patient patient;
    Node left, right;
    
    Node(Patient p) {
        patient = p;
        left = right = null;
    }
}

public class PatientBST {
    Node root;
    public void insert(Patient p) {
        root = insertRec(root, p);
    }

    private Node insertRec(Node root, Patient p) {
        if (root == null) return new Node(p);
        if (p.id < root.patient.id)
            root.left = insertRec(root.left, p);
        else if (p.id > root.patient.id)
            root.right = insertRec(root.right, p);
        return root;
    }
    public Patient search(int id) {
        return searchRec(root, id);
    }

    private Patient searchRec(Node root, int id) {
        if (root == null) return null;
        if (id == root.patient.id) return root.patient;
        return id < root.patient.id ? searchRec(root.left, id) : searchRec(root.right, id);
    }
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node root, int id) {
        if (root == null) return null;
        if (id < root.patient.id)
            root.left = deleteRec(root.left, id);
        else if (id > root.patient.id)
            root.right = deleteRec(root.right, id);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            Node min = root.right;
            while (min.left != null) min = min.left;
            root.patient = min.patient;
            root.right = deleteRec(root.right, min.patient.id);
        }
        return root;
    }
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient);
            inorderRec(root.right);
        }
    }
}
