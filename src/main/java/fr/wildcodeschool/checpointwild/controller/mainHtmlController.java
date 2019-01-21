package fr.wildcodeschool.checpointwild.controller;

import fr.wildcodeschool.checpointwild.dao.PatientRepository;
import fr.wildcodeschool.checpointwild.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class mainHtmlController {

    @Autowired
    private PatientRepository patientRepository;

    @Value("${error.message}")
    private String errorMessage;

    @Value("${error.message2}")
    private String errorMessage2;

    @Value("l'utilisateur existe déjà")
    private String errorMessage3;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/listPatient"}, method = RequestMethod.GET)
    public String personList(Model model) {
        for (Patient patient :patientRepository.findAll()
             ) {
            patient.setCodeSexe(Integer.parseInt(patient.getNum().substring(0,1)));
            patient.setAnnee(Integer.parseInt(patient.getNum().substring(1,3)));
            patient.setMois(Integer.parseInt(patient.getNum().substring(3,5)));
            patient.setDep(Integer.parseInt(patient.getNum().substring(5,7)));
            patient.setCommune(Integer.parseInt(patient.getNum().substring(7,10)));
        }
        model.addAttribute("patients", patientRepository.findAll());
        DeleteForm deleteForm = new DeleteForm();
        model.addAttribute("deleteForm", deleteForm);
        SecuForm secuForm = new SecuForm();
        model.addAttribute("secuForm", secuForm);
        NomForm nomForm = new NomForm();
        model.addAttribute("nomForm", nomForm);
        return "listPatient";
    }

    @RequestMapping(value = {"/addPatient"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        PatientForm patientForm = new PatientForm();
        model.addAttribute("patientForm", patientForm);
        return "addPatient";
    }

    @RequestMapping(value = {"/addPatient"}, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("patientForm") PatientForm patientForm) {
        String nom = patientForm.getNom();
        String prenom = patientForm.getPrenom();
        String num_secu = patientForm.getNum();
        String commentaires = patientForm.getCommentaires();

        patientRepository.save(new Patient(nom, prenom, num_secu, commentaires));
        if (nom != null && nom.length() > 0
                && num_secu != null && num_secu.length() > 0) {
            return "redirect:/listPatient";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "addPatient";
    }

    @RequestMapping(value = {"/deletePerson"}, method = RequestMethod.POST)
    public String deletePerson(Model model, @ModelAttribute("deleteForm") DeleteForm deleteForm) {
        Long id = deleteForm.getId_patient();
        if (patientRepository.findById(id).isPresent()) {
            patientRepository.deleteById(id);
            return "redirect:/listPatient";
        }
        model.addAttribute("errorMessage2", errorMessage2);
        model.addAttribute("users", patientRepository.findAll());
        return "listPatient";
    }

    @RequestMapping(value ={"/searchByNumSec"} , method = RequestMethod.POST)
    public String searchByNumSecu (Model model, @ModelAttribute("secuForm") SecuForm secuForm){
        String num_secu = secuForm.getNum();
        model.addAttribute("patients", patientRepository.findPatientByNumContains(num_secu));
        return "searchByNumSec";
    }

    @RequestMapping(value ={"/searchByName"} , method = RequestMethod.POST)
    public String searchByName(Model model, @ModelAttribute("nomForm") NomForm nomForm){
        String nom = nomForm.getNom();
        List<Patient> myList= patientRepository.findAll().stream().filter(x -> (x.getNom()).equals(nom)).collect(Collectors.toList());
        model.addAttribute("patients", myList);
        return "searchByName";
    }
}
