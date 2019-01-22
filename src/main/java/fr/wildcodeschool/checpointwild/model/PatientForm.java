package fr.wildcodeschool.checpointwild.model;

public class PatientForm {
    private String nom;
    private String prenom;
    private String num;
    private String commentaires;


    private int codeSexe;
    private int annee;
    private int mois;
    private int dep;
    private int commune;
    private String communeLibelle;

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
