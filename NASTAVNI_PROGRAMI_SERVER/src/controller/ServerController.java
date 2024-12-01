/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.Kurs;
import model.NastavniProgram;
import model.Predavac;
import model.Prijavljivanje;
import model.Statistika;
import model.Student;
import so.kurs.SOGetAllKurs;
import so.kurs.SOGetAllKursevi;
import so.login.SOLogin;
import so.prijavljivanje.SOAddNewPrijavljivanje;
import so.prijavljivanje.SODeletePrijavljivanje;
import so.prijavljivanje.SOGetAllPrijavljivanje;
import so.prijavljivanje.SOUpdatePrijavljivanje;
import so.program.SOGetAllProgrami;
import so.statistika.SOGetAllStatistika;
import so.student.SOAddNewStudent;
import so.student.SODeleteStudent;
import so.student.SOGetAllStudent;
import so.student.SOUpdateStudent;

/**
 *
 * @author ivana
 */
public class ServerController {

    private static ServerController instance;

    private ServerController() {

    }

    public static ServerController getInstance() {

        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }

    private ArrayList<Predavac> listaPrijavljenihPredavaca = new ArrayList<>();

    public Predavac login(Predavac predavac) throws Exception {

        SOLogin so = new SOLogin();
        so.templateExecute(predavac);
        //System.out.println("server controller " + so.getUlogovani());
        return so.getUlogovani();

    }

    public ArrayList<Student> getAllStudent() throws Exception {

        SOGetAllStudent so = new SOGetAllStudent();
        so.templateExecute(new Student());
        return so.getListaStudenata();
    }

    public void addNewStudent(Student student) throws Exception {

        SOAddNewStudent so = new SOAddNewStudent();
        so.templateExecute(student);

    }

    public void deleteStudent(Student student) throws Exception {

        SODeleteStudent so = new SODeleteStudent();
        so.templateExecute(student);

    }

    public void updateStudent(Student student) throws Exception {
        SOUpdateStudent so = new SOUpdateStudent();
        so.templateExecute(student);
    }

    public ArrayList<NastavniProgram> getAllProgrami() throws Exception {

        SOGetAllProgrami so = new SOGetAllProgrami();
        so.templateExecute(new NastavniProgram());
        return so.getListaPrograma();
    }

    public ArrayList<Kurs> getAllKurs(Prijavljivanje pr) throws Exception {

        SOGetAllKurs so = new SOGetAllKurs();

        Kurs k = new Kurs();
        k.setPrijavljivanje(pr);
        so.templateExecute(k);

        return so.getLista();

    }

    public void addNewPrijavljivanje(Prijavljivanje pr) throws Exception {

        SOAddNewPrijavljivanje so = new SOAddNewPrijavljivanje();
        so.templateExecute(pr);

    }

    public ArrayList<Prijavljivanje> getAllPrijavljivanje() throws Exception {

        SOGetAllPrijavljivanje so = new SOGetAllPrijavljivanje();
        so.templateExecute(new Prijavljivanje());

        return so.getLista();

    }

    public void updatePrijavljivanje(Prijavljivanje pr) throws Exception {

        SOUpdatePrijavljivanje so = new SOUpdatePrijavljivanje();

        so.templateExecute(pr);

    }

    public void deletePrijavljivanje(Prijavljivanje prijBrisanje) throws Exception {
        SODeletePrijavljivanje so = new SODeletePrijavljivanje();
        so.templateExecute(prijBrisanje);
    }

    public ArrayList<Statistika> getAllStatistika() throws Exception {
        SOGetAllStatistika so = new SOGetAllStatistika();
        so.templateExecute(new Statistika());
        return so.getListaStatistika();

    }
    
    
//    public void addNewPredavac(Predavac predavac) throws Exception {
//        SOAddNewPredavac so = new SOAddNewPredavac();
//        so.templateExecute(predavac);
//    }

    public ArrayList<Predavac> getListaPrijavljenihPredavaca() {
        return listaPrijavljenihPredavaca;
    }
    
    public ArrayList<Kurs> getAllKursevi() throws Exception {

        SOGetAllKursevi so = new SOGetAllKursevi();
        so.templateExecute(new Kurs());
        return so.getListaKurseva();

    }

    public void setListaZaposlenih(ArrayList<Predavac> listaPrijavljenihPredavaca) {
        this.listaPrijavljenihPredavaca = listaPrijavljenihPredavaca;
    }

    public void logout(Predavac predavaclog) {

        listaPrijavljenihPredavaca.remove(predavaclog);

    }

    private String username = "";
    private String url = "";
    private String password = "";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  

    
    
}
