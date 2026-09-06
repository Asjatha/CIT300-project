package model;

public class Visit {
    public String visitId;
    public String date;
    public String doctor;
    public String diagnosis;
    public String treatment;

    public Visit(String visitId, String date, String doctor, String diagnosis, String treatment) {
        this.visitId = visitId;
        this.date = date;
        this.doctor = doctor;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public String toString() {
        return visitId + " | " + date + " | " + doctor + " | " + diagnosis + " | " + treatment;
    }
}