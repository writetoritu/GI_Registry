import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.FileReader;
import java.lang.*;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;
import java.util.StringTokenizer;

public class GenerateFinalReport
{
    
   //collapse columns in the master report to generate the right format
    
    static String mapYNUfields(String yes_no, String unknown)
    {
        if(yes_no.trim().length()==0)
            if(unknown.trim().length()==0)
                return "";
            else
                if(unknown.trim().equals("1"))
                    return "Unknown";
        
 //       return "XYZ";
        if(yes_no.split(":")[0].trim().equals("1"))
            return "Y";
        if(yes_no.split(":")[0].trim().equals("0"))
            return "N";
       
        return "";
        
    }
    
    static String mapRegularField(String field)
    {
        if(field.trim().length()>0)
            return field.split(":")[0];
        else
            return "";
        
    }
    
    static String mapEpicField(String field)
    {
       // System.out.println(field);
        if(field.trim().length()>0)
            return field.split(":")[1];
        else
            return "";
        
    }
    
    public static void main (String args[])
    {
           try{
               
               Writer writer = new BufferedWriter(new OutputStreamWriter(
                                                                         new FileOutputStream("data//final_report.txt"), "utf-8"));
               
                BufferedReader br = new BufferedReader(new FileReader("data//master_report.txt"));
            
                String line = br.readLine();
                //STep 1: Create the list of objects for this registry element from the data file
                //reading the input data file line-wise
               int count =0;
                while (line != null)
                {
                    if(count==0)
                    {
                         writer.write("PAT_ENC_CSN_ID|"); // Visit ID
                        writer.write(line.split("\\|")[0]+"|"); //patient id
                         writer.write(line.split("\\|")[1]+"|"); //mrn
                         writer.write("NAME|"); //name
                        writer.write(line.split("\\|")[5]+"|"); //DOB
                        writer.write(line.split("\\|")[6]+"|"); //sex
                        writer.write("RACE|"); //ethnic group
                        writer.write("WEIGHT|"); //weight in ounces
                        writer.write("HEIGHT|"); //height in foot/inches
                         writer.write("HEIGHT|"); //BMI
                        
                        writer.write("CURRENT DIAGNOSIS|"); // current diagnosis
                        
                        writer.write("DATA ENTRY USER ID|"); //  data entry user id
                        
                        writer.write("HAD_COLECTOMY_YNU|");// had colectomy ynu
                        
                        writer.write("COLECTOMY_DATE|");//  colectomy date
                        
                        writer.write("HAS_ILEO_COLO_YNU|");
                        
                        writer.write("WORST_SYMPTOMS_7DAY|");
                        
                        writer.write("LIMITATIONS_7DAY|");
                        
                        writer.write("AB_PAIN_7DAY|");
                        
                        writer.write("NUM_STOOLS_7DAY|");
                        
                        writer.write("STOOLS_INTEND_NOANS|");
                        
                        writer.write("STOOL_FORMATION_7DAY|");
                        
                        writer.write("NUM_LIQUID_STOOLS|");
                        
                        writer.write("NUMLIQ_INTEND_NOANS|");
                        
                        writer.write("BLOODY_STOOLS_YNU|");
                        
                        writer.write("AMOUNT_OF_BLOOD|");
                        
                        writer.write("NOCTURNAL_DIARRHEA_YNU|");
                        writer.write("FEVER_3OF7_YNU|");
                        writer.write("DEFINITE_ARTHRITIS_YNU|");
                        writer.write("UVEITIS_YNU|");
                        writer.write("ERYTHEMA_NODOSUM_YNU|");
                        writer.write("PYODERMA_GANGREN_YNU|");
                        writer.write("AB_EXAM_FINDINGS|");
                        writer.write("PERIRECTAL_DISEASE|");
                        writer.write("GLOBAL_ASSESSMENT|");
                        writer.write("NUTRITIONAL_STATUS|");
                        writer.write("GROWTH_STATUS|");
                        writer.write("REMISSION_YNU|");
                        writer.write("SERIOUS_INFECTION_YNU|");
                        writer.write("TYPE_OF_INFECTION|");
                        writer.write("LOWER_GI_DISEASE|");
                        writer.write("UPPER_PROXIMAL_YNU|");
                        writer.write("UPPER_PROXIMAL_YNU_NOT_ASSESSED|");
                        writer.write("UPPER_DISTAL_YNU_NOT_ASSESSED|");
                        writer.write("UPPER_DISTAL_YNU|");
                        writer.write("CROHNS_PHENOTYPE|");
                        writer.write("PERIANAL_PHENOTYPE_YNU|");
                        writer.write("EXTENT_OF_DISEASE|");
                        writer.write("SEVERE_DISEASE_YNU|");
                        writer.write("BIOLOGIC_YNU|");
                        writer.write("FIRST_INDUCTION_DATE|");
                        writer.write("CALORIC_SUPPLEMENT_YNU|");
                        writer.write("ENTERAL_NUTRITION_YNU|");
                        writer.write("PRIMARY_GASTRO");
                        

                    }
                    else
                    {
                         writer.write(line.split("\\|")[13]+"|"); // visit id
                        writer.write(line.split("\\|")[0]+"|"); //patient id
                         writer.write(line.split("\\|")[1]+"|"); //mrn
                         writer.write(line.split("\\|")[3]+", "+line.split("\\|")[2]+" "+line.split("\\|")[4]+"|"); //name
                        writer.write(line.split("\\|")[5]+"|"); //DOB
                         writer.write(line.split("\\|")[6]+"|"); //sex
                         writer.write(line.split("\\|")[7]+"|"); //ethnic group
                        writer.write(line.split("\\|")[8]+"|"); // weight in ounces
                         writer.write(line.split("\\|")[10]+"|"); // height
                         writer.write(line.split("\\|")[12]+"|"); // BMI
                        
                        
                        writer.write(mapEpicField(line.split("\\|")[15])+"|"); // current diagnosis
                        
                         writer.write(line.split("\\|")[14]+"|"); // data entry user id
                        
                        
                        //check if no fields left after this?
                        
                        // had colectomy ynu
                        writer.write(mapYNUfields(line.split("\\|")[16], line.split("\\|")[17])+"|");
                        
                        //collectormy date
                        writer.write(mapRegularField(line.split("\\|")[18])+"|");
                        
                        //HAS_ILEO_COLO_YNU
                        writer.write(mapYNUfields(line.split("\\|")[19], line.split("\\|")[20])+"|");
                        
                        //WORST_SYMPTOMS_7DAY
                        writer.write(mapRegularField(line.split("\\|")[21])+"|");
                        
                        //LIMITATIONS_7DAY
                        writer.write(mapRegularField(line.split("\\|")[22])+"|");
                        
                        //AB_PAIN_7DAY
                         writer.write(mapRegularField(line.split("\\|")[23])+"|");
                        
                        //NUM_STOOLS_7DAY
                        writer.write(mapRegularField(line.split("\\|")[24])+"|");
                        
                        //STOOLS_INTEND_NOANS
                         writer.write(mapRegularField(line.split("\\|")[25])+"|");
                        
                        //STOOL_FORMATION_7DAY
                        writer.write(mapRegularField(line.split("\\|")[26])+"|");
                        
                        //NUM_LIQUID_STOOLS
                        writer.write(mapRegularField(line.split("\\|")[28])+"|");
                        
                        //NUMLIQ_INTEND_NOANS
                         writer.write(mapYNUfields(line.split("\\|")[29], "")+"|");
                        
                        //BLOODY_STOOLS_YNU
                        writer.write(mapYNUfields(line.split("\\|")[30], line.split("\\|")[31])+"|");
                        
                        //AMOUNT_OF_BLOOD
                         writer.write(mapYNUfields(line.split("\\|")[32], "")+"|");
                        
                        //NOCTURNAL_DIARRHEA_YNU
                        writer.write(mapYNUfields(line.split("\\|")[33], line.split("\\|")[34])+"|");
                        //FEVER_3OF7_YNU
                        writer.write(mapYNUfields(line.split("\\|")[35], line.split("\\|")[36])+"|");
                        //DEFINITE_ARTHRITIS_YNU
                        writer.write(mapYNUfields(line.split("\\|")[37], line.split("\\|")[38])+"|");
                        //UVEITIS_YNU
                        writer.write(mapYNUfields(line.split("\\|")[39], line.split("\\|")[40])+"|");
                        //ERYTHEMA_NODOSUM_YNU
                        writer.write(mapYNUfields(line.split("\\|")[41], line.split("\\|")[42])+"|");
                        //PYODERMA_GANGREN_YNU
                        writer.write(mapYNUfields(line.split("\\|")[43], line.split("\\|")[44])+"|");
                        //System.out.println(mapYNUfields(line.split("\\|")[42], line.split("\\|")[43]));
                        
                        //AB_EXAM_FINDINGS
                        writer.write(mapEpicField(line.split("\\|")[45])+"|");
                        //System.out.println(line.split("\\|")[45]);
                        
                        //PERIRECTAL_DISEASE
                        writer.write(mapEpicField(line.split("\\|")[46])+"|");
                        //GLOBAL_ASSESSMENT
                        writer.write(mapRegularField(line.split("\\|")[47])+"|");
                       //NUTRITIONAL_STATUS
                        writer.write(mapEpicField(line.split("\\|")[48])+"|");
                        //GROWTH_STATUS
                        writer.write(mapEpicField(line.split("\\|")[49])+"|");
                        //REMISSION_YNU
                         writer.write(mapYNUfields(line.split("\\|")[50], line.split("\\|")[51])+"|");
                        //SERIOUS_INFECTION_YNU
                        writer.write(mapYNUfields(line.split("\\|")[52], line.split("\\|")[53])+"|");
                        //TYPE_OF_INFECTION
                        writer.write(mapRegularField(line.split("\\|")[54])+"|");
                        //LOWER_GI_DISEASE
                        writer.write(mapEpicField(line.split("\\|")[55])+"|");
                        //UPPER_PROMIXMAL
                        writer.write(mapYNUfields(line.split("\\|")[56], line.split("\\|")[57])+"|");
                        //UPPER_PROXIMAL_YNU_NOT_ASSESSED
                        writer.write(mapYNUfields(line.split("\\|")[58], "")+"|");
                        //UPPER_DISTAL_YNU_NOT_ASSESSED
                        writer.write(mapYNUfields(line.split("\\|")[59], "")+"|");
                        //UPPER_DISTAL_YNU
                        writer.write(mapYNUfields(line.split("\\|")[60], line.split("\\|")[61])+"|");
                        //CROHNS_PHENOTYPE
                        writer.write(mapEpicField(line.split("\\|")[62])+"|");
                        //PERIANAL_PHENOTYPE_YNU
                        writer.write(mapYNUfields(line.split("\\|")[63], line.split("\\|")[64])+"|");
                        //EXTENT_OF_DISEASE
                         writer.write(mapEpicField(line.split("\\|")[65])+"|");
                        //SEVERE_DISEASE_YNU	SEVERE_DISEASE_YNU_UNKNOWN
                        writer.write(mapYNUfields(line.split("\\|")[66], line.split("\\|")[67])+"|");
                        //BIOLOGIC_YNU	BIOLOGIC_YNU_UNKNOWN
                        writer.write(mapYNUfields(line.split("\\|")[68], line.split("\\|")[69])+"|");
                        //FIRST_INDUCTION_DATE
                        writer.write(mapRegularField(line.split("\\|")[70])+"|");
                        //CALORIC_SUPPLEMENT_YNU	CALORIC_SUPPLEMENT_YNU_UNKNOWN
                        writer.write(mapYNUfields(line.split("\\|")[71], line.split("\\|")[72])+"|");
                        //ENTERAL_NUTRITION_YNU	ENTERAL_NUTRITION_YNU_UNKNOWN
                        writer.write(mapYNUfields(line.split("\\|")[73], line.split("\\|")[74])+"|");
                        
                        //System.out.println(line.split("\\|"));
                        //PRIMARY_GASTRO
                        //writer.write(mapRegularField(line.split("\\|")[75]));
                        
                    }
                    //writer.write();
                    //CURRENT_LIST.lastElement().printThisVisit();
                        
                    line = br.readLine();
                    writer.write("\n");
                    count++;
                  //   break;

                }
               System.out.println("Total visits: "+(count-1));
               br.close();
               writer.close();
               
            }
        catch(IOException io)
              {
                  System.out.println("Not found");
              }
        
        
        
       
        
        
    }
}