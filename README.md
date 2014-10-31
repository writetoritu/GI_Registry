GI_Registry
===========
<!--
This repository contains the code to extract the SmartForm elements from the CHOP warehouse and process them to create CHOP's contribution to the ICN GI registry. 

**Content Description**

Generate_ConceptSpecific_Report.sql: contains the query to create a report corresponding to a clinical concept

RegistryElement.java: A Java class that holds an object corresponding to a visit instance 

Results_Merger.java: 
- Creates a new list of RegistryElement objects after reading from a text file specific to a concept
- Merges various lists together, i.e. creates a single record out of different concept values corresponding to a given visit. The output is a master file where each row corresponds to a visit and contains values for various clinical concepts. 
 
GenerateFinalReport.java:  Collapse columns and add additional logic to master report and produce the final report to be submitted to CHOP production 

**Steps**

1. Find concept_keys (in CDW) for all clinical concepts to be populated in the final registry and create a file called RegistryElementCode.txt in the format "ConceptName|Index|Concept_Key" and the folder "reference_data". 
 - This is a manual step
2. Use SQL query (Generate_ConceptSpecific_Report.sql) to generate text files (concept-specific) report for each concept 
 - This is also a manual step - since we dont have provileges for create procedures on CDW. 
 - Run SQL for each concept and export the result (format=csv, header=uncheck) into appropriately named report in the "reports" folder
3. Merge all concept-specific text files together to generate a single file where each row corresponds to a visit and all concept values (Results_Merger.java)
4. Package the final report, e.g. collapse certain columns and add additional target vocabulary logic (GenerateFinalReport.java)


-->
