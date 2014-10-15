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

public class Results_Merger
{
    
    static Vector<RegistryElement> MASTER_LIST = new Vector<RegistryElement>();
    //should only contain one object for each visit

    
    static RegistryElement generateRegistryElement(String line, int index)
    {
        String patient_id= new String();
        String MRN = new String();
        String FIRST_NM= new String();
        String LAST_NM= new String();
        String MIDDLE_NM= new String();
        String DOB= new String();
        String SEX= new String();
        String ETHNIC_GRP= new String();
        String WT_OZ= new String();
        String WT_KG= new String();
        String HT_RAW= new String();
        String HT_CM= new String();
        String BMI= new String();
        String visit_id= new String();
        String user_id= new String();
        String concept_value= new String();
        
       
       // System.out.println(line.split("\"\t").length);
        int i=0;
       //  StringTokenizer st = new StringTokenizer(line);
       
           patient_id = new String(line.split("\"\t")[i++]);
            //System.out.println(patient_id);
           MRN = new String(line.split("\"\t")[i++]);
           FIRST_NM = new String(line.split("\"\t")[i++]);
           LAST_NM = new String(line.split("\"\t")[i++]);
           MIDDLE_NM = new String(line.split("\"\t")[i++]);
           DOB = new String(line.split("\"\t")[i++]);
           SEX = new String(line.split("\"\t")[i++]);
           ETHNIC_GRP = new String(line.split("\"\t")[i++]);
           WT_OZ = new String(line.split("\"\t")[i++]);
           WT_KG = new String(line.split("\"\t")[i++]);
           HT_RAW = new String(line.split("\"\t")[i++]);
            HT_CM = new String(line.split("\"\t")[i++]);
           BMI = new String(line.split("\"\t")[i++]);
           visit_id = new String(line.split("\"\t")[i++]);
           user_id = new String(line.split("\"\t")[i++]);
           concept_value = new String(line.split("\"\t")[i++]+":"+line.split("\"\t")[i++]);
        
          return new RegistryElement(patient_id,  MRN, FIRST_NM,LAST_NM,MIDDLE_NM, DOB, SEX,  ETHNIC_GRP, WT_OZ, WT_KG, HT_RAW, HT_CM,  BMI, visit_id, user_id,index,concept_value);
        
    }
    
    
    static RegistryElement findMatchingVisitInMaster(RegistryElement e)
    {
        for(int i=0;i<MASTER_LIST.size();i++)
        {
            if(MASTER_LIST.get(i).getVisitID().equals( e.getVisitID()))
                return MASTER_LIST.get(i);
        }
        return null;
        
    }
    static void mergeWithMaster(Vector<RegistryElement> CURRENT_LIST)
    {
        //for each element in the current list , check if its present in master
        RegistryElement temp;
        for(int i=0;i<CURRENT_LIST.size();i++)
        {
            temp =findMatchingVisitInMaster(CURRENT_LIST.get(i));
            if(temp!=null)
            {
                System.out.println("MATCHed visit found "+temp.getVisitID());
                //merge current list instance into the matched master list instance
                temp.updateConceptValues(CURRENT_LIST.get(i));
                temp.printThisVisit();
                
            }
            else
                MASTER_LIST.add(CURRENT_LIST.get(i));
            
        }
        
    }
    
    
    public static void main (String args[])
    {
        System.out.println("Tested");
        Vector<RegistryElement> CURRENT_LIST;
        
        int counter = 0;
        
         try{
             //Write to a final master report
             Writer writer = new BufferedWriter(new OutputStreamWriter(
                                                                       new FileOutputStream("data//master_report.txt"), "utf-8"));
             writer.write("PAT_ID|MRN|FIRST_NM|LAST_NM|MIDDLE_NM|DOB|SEX|ETHNIC_GRP|WT_OZ|WT_KG|HT_RAW|HT_CM|BMI|VISIT_ID|USER_ID");

           
            BufferedReader br1 = new BufferedReader(new FileReader("data//RegistryElementCode"));
            
            String line1 = br1.readLine();
            
            while(line1!=null) //for each registry elemnt
            {
                CURRENT_LIST = new Vector<RegistryElement>();
                String element_filename = line1.split("\\|")[0];
                writer.write("|"+element_filename);
                int index=Integer.parseInt(line1.split("\\|")[1]);//the index for storing values in the registry element object
                System.out.println("Processing for "+line1);
            //reading the a certain regitry element file
                BufferedReader br = new BufferedReader(new FileReader("data//"+element_filename+".txt"));
            
                String line = br.readLine();
                //STep 1: Create the list of objects for this registry element from the data file
                //reading the input data file line-wise
                while (line != null)
                {
                    CURRENT_LIST.add(
                                                    generateRegistryElement(
                                                                            line,index
                                                                            )
                          
                                     );
                    //CURRENT_LIST.lastElement().printThisVisit();
                    line = br.readLine();
                  //   break;

                }
                System.out.println(" The size for the "+element_filename+" list is "+CURRENT_LIST.size());
                
                //Step 2 merge with the master list
                mergeWithMaster(CURRENT_LIST);
                System.out.println(" The size for the Master List is "+MASTER_LIST.size());
                
                
                //for testing just focusing on a single registry element
                counter++;
               // if(counter==61)
                 //   break;
                
                
                line1 = br1.readLine();
                br.close();
            }//while loop ends for each registry element
             
             writer.write("\n");
             for(int i=0;i<MASTER_LIST.size();i++)
             {
                 writer.write(MASTER_LIST.get(i).getReportFormat()+"\n");
             }
       
             writer.close();
             br1.close();
        }
        catch(IOException io)
              {
                  System.out.println("Not found");
              }
        
       
        
        
    }
}
