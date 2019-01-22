package fr.wildcodeschool.checpointwild.model;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_patient;

    private String nom;
    private String prenom;
    private String num;
    private String commentaires;

    @Transient
    private int codeSexe;
    @Transient
    private int annee;
    @Transient
    private int mois;
    @Transient
    private int dep;
    @Transient
    private int commune;
    @Transient
    private String communeLibelle;

    public Patient() {
    }

    public Patient(String nom, String prenom, String num, String commentaires) {
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.commentaires = commentaires;
    }

    public long getId_patient() {
        return id_patient;
    }

    public void setId_patient(long id_patient) {
        this.id_patient = id_patient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public int getCodeSexe() {
        return codeSexe;
    }

    public void setCodeSexe(int codeSexe) {
        this.codeSexe = codeSexe;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public int getCommune() {
        return commune;
    }

    public void setCommune(int commune) {
        this.commune = commune;
    }

    public String getCommuneLibelle() {
        return communeLibelle;
    }

    public void setCommuneLibelle(String communeLibelle) {
        this.communeLibelle = communeLibelle;
    }
}
