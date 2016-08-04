import java.util.ArrayList;

public class LabSection{

    private int sectionNumber;
    // list of GTA available for this lab
    private ArrayList<String> candidates;
    private String nominated;


    /*********************************************************************
     *                              Setter
     *********************************************************************/
    public void setNominated(String nominated){
        this.nominated = nominated;
    }

    public void setCandidates(ArrayList<String> candidates){
        this.candidates = candidates;
    }

    public void setSectionNumber(int sectionNumber){
        this.sectionNumber = sectionNumber;
    }

    /*********************************************************************
     *                              Getter
     *********************************************************************/
    public int getSectionNumber(){
        return sectionNumber;
    }

    public ArrayList<String> getCandidates(){
        return candidates;
    }

    public String getNominated(){
        return nominated;
    }
}