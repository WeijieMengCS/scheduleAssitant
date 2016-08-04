import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by mengxueluo on 8/4/16.
 */
public class LabSectionAssignmentTest {

    @Test
    public void FinalLabScheduleShouldBeValid(){
        String fileName = "testLabAssignment_GTA.csv";
        TimeAnalyzer analyzer = new TimeAnalyzer();
        // get basic data from the test file
        analyzer.formFullyFilled(fileName);
        ArrayList<String> timeSlots = analyzer.getTimeSlots();
        ArrayList<ArrayList<String>> data = analyzer.getData();

        // set the basic data for labSectionAnalyzer
        LabSectionAnalyzer labSectionAnalyzer = new LabSectionAnalyzer();
        labSectionAnalyzer.setTimeSlots(timeSlots);
        labSectionAnalyzer.setData(data);

        // generate the final lab schedule
        labSectionAnalyzer.getFinalLabSchedule();

        // reset the doable sections for each gta
        labSectionAnalyzer.setInfoForEachGTA();

        LabSection[] labSections = labSectionAnalyzer.getLabSectionList();
        GTA[] gtas = labSectionAnalyzer.getGTAList();

        // check if the final lab schedule is valid
        int sectionNumber;
        int indexOfGTA;
        String nominated;
        int indexOfSection;

        for (LabSection section : labSections){
            nominated = section.getNominated();
            sectionNumber = section.getSectionNumber();
            indexOfGTA = labSectionAnalyzer.getIndexOfGTA(nominated);
            indexOfSection = gtas[indexOfGTA].getDoableSectionList().indexOf(sectionNumber);
            assertTrue("The nominated should be able to attend the assigned lab section", indexOfSection != -1);
        }
    }
}
