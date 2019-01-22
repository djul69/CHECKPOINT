package fr.wildcodeschool.checpointwild.model;

import java.util.Arrays;

public class JsonGeo {
    private String nom;
    private String code;
    private String codeDepartement;
    private String codeRegion;
    private String[] codesPostaux;
    private String population;

    public JsonGeo(String nom, String code, String codeDepartement, String codeRegion, String[] codesPostaux, String population) {
        this.nom = nom;
        this.code = code;
        this.codeDepartement = codeDepartement;
        this.codeRegion = codeRegion;
        this.codesPostaux = codesPostaux;
        this.population = population;
    }

    public JsonGeo() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String[] getCodesPostaux() {
        return codesPostaux;
    }

    public void setCodesPostaux(String[] codesPostaux) {
        this.codesPostaux = codesPostaux;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
