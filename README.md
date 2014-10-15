GI_Registry
===========
RegistryElement.java: A Java class that holds an object corresponding to a visit instance 

Results_Merger.java: (i) Creates a new list of RegistryElement objects after reading from a text file specific to a concept, and (ii) Merges various lists together , 
 e.g. creates a single record out of different concept values corresponding to a given visit. The output is a master file where each row corresponds to a 
 visit and contains values for various clinical concepts. 
 
GenerateFinalReport.java:  Collapse columns and add additional logic to master report and produce the final report to be submitted to CHOP production 
