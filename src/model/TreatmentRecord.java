package model;

public class TreatmentRecord {
    public int patientId;
    public String treatment;
    public String date;

    public TreatmentRecord(int patientId, String treatment, String date) {
        this.patientId = patientId;
        this.treatment = treatment;
        this.date = date;
    }

    public String toString() {
        return patientId + " | " + treatment + " | " + date;
    }
}
