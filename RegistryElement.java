import java.util.ArrayList;

class RegistryElement
{
    String PAT_ID;
    String MRN;
    String FIRST_NM;
    String LAST_NM;
    String MIDDLE_NM;
    String DOB;
    String SEX;
    String ETHNIC_GRP;
    String WT_OZ;
    String WT_KG;
    String HT_RAW;
    String HT_CM;
    String BMI;
    String VISIT_ID;
    String USER_ID;
    ArrayList<String> Concept_values = new ArrayList<String>(60); //84 elements in registry need to be accessed to create the final extract
    
    static int TOTAL_REGISTRY_ELEMENTS = 60;
    
    RegistryElement(String PAT_ID,
                    String MRN,
                    String FIRST_NM,
                    String LAST_NM,
                    String MIDDLE_NM,
                    String DOB,
                    String SEX,
                    String ETHNIC_GRP,
                    String WT_OZ,
                    String WT_KG,
                    String HT_RAW,
                    String HT_CM,
                    String BMI,
                    String VISIT_ID, String USER_ID, int index,
                    String Concept_value)
    {
        this.PAT_ID = PAT_ID.replaceAll("\"","");
        this.MRN=MRN.replaceAll("\"","");
        this.FIRST_NM=FIRST_NM.replaceAll("\"","");
        this.LAST_NM=LAST_NM.replaceAll("\"","");
        this.MIDDLE_NM=MIDDLE_NM.replaceAll("\"","");
        this.DOB=DOB.replaceAll("\"","");
        this.SEX=SEX.replaceAll("\"","");
        this.ETHNIC_GRP=ETHNIC_GRP.replaceAll("\"","");
        this.WT_OZ=WT_OZ.replaceAll("\"","");
        this.WT_KG=WT_KG.replaceAll("\"","");
        this.HT_RAW=HT_RAW.replaceAll("\"","");
        this.HT_CM=HT_CM.replaceAll("\"","");
        this.BMI=BMI.replaceAll("\"","");
        
        
        this.VISIT_ID = VISIT_ID.replaceAll("\"","");
        this.USER_ID = USER_ID.replaceAll("\"","");
        
        //System.out.println(Concept_value);
        //this.Concept_values.add(0,Concept_value);
        //this.printConceptValues();
        
        //System.out.println(Concept_values.size());
        for(int i=0;i<TOTAL_REGISTRY_ELEMENTS;i++)
        {
            //System.out.println(index);
            if(i==index)
            {
                //System.out.println("here "+i+" "+Concept_value);
                this.Concept_values.add(i,Concept_value.replaceAll("\"",""));
              //  break;
            }
            else
                this.Concept_values.add(i,"");
        }

        //this.printConceptValues();
        
    }
    
    String getVisitID()
    {
        return this.VISIT_ID;
    }
    
    ArrayList getConceptValues()
    {
        return this.Concept_values;
    }
    
    void printConceptValues()
    {
        for(int i=0;i<TOTAL_REGISTRY_ELEMENTS;i++)
        {
          //  if(i==0) System.out.println(i+":"+Concept_values.get(i));
           // if(i==1) System.out.println(i+":"+Concept_values.get(i));
            if(Concept_values.get(i).length()>0)
                System.out.println(i+":"+Concept_values.get(i));
        }
    }
    
    String getReportFormat()
    {
        String report = new String();
        report+=PAT_ID+"|"+
            MRN+"|"+
            FIRST_NM+"|"+
         LAST_NM+"|"+
         MIDDLE_NM+"|"+
         DOB+"|"+
         SEX+"|"+
         ETHNIC_GRP+"|"+
         WT_OZ+"|"+
         WT_KG+"|"+
         HT_RAW+"|"+
         HT_CM+"|"+
        BMI+"|"+
        VISIT_ID+"|"+USER_ID;
        
        for(int i=0;i<TOTAL_REGISTRY_ELEMENTS;i++)
        {
            report+="| "+Concept_values.get(i);
        }
        return report;
    }
    
    void printThisVisit()
    {
        System.out.println("Patient ID: "+PAT_ID+" VISIT_ID: "+VISIT_ID+" Concept Values: ");
        printConceptValues();
    }
    
    void updateConceptValues(RegistryElement e)
    {
        String new_concept_value;
            //compare concept_values between two and update this object
        for(int i=0;i<TOTAL_REGISTRY_ELEMENTS;i++)
        {
            new_concept_value = e.getConceptValues().get(i).toString();
            
            if(new_concept_value.length()>0 //if this value exists in new list
               //--&& this.Concept_values.get(i).length()==0) //if this value doesnt exist in Master list
                )
            {
                System.out.println("new value found");
                System.out.println(new_concept_value);
                this.Concept_values.add(i,new_concept_value);
                break;
            }
            
        }
        
    }
}