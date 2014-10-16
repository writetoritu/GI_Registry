select distinct
  p.PAT_ID as PAT_ID,
  p.pat_MRN_ID as MRN,
  p.FIRST_NM, 
  p.LAST_NM,
  p.MIDDLE_NM,
  TO_CHAR(p.DOB),
  p.SEX,
  p.ETHNIC_GRP,
  TO_CHAR(v2.WT_OZ),
  TO_CHAR(v2.WT_KG),
  TO_CHAR(v2.HT_RAW),
  TO_CHAR(v2.HT_CM),
  TO_CHAR(v2.BMI),
  TO_CHAR(v1.VISIT_KEY) as PAT_ENC_CSN_ID,
  TO_CHAR(v1.APPT_DATE) as APPT_DT,
  TO_CHAR(v1.CURR_VAL_EMP_KEY) as DATA_ENTRY_USER_ID ,
  TO_CHAR(v1.CONCEPT_VAL) as CONCEPT_VALUE, 
  TO_CHAR(c.ABBR) as CONCEPT_ABBR
from 
     CDW.visit_concept v1 
     join  CDW.patient p on v1.pat_key = p.pat_key
     join CDW.visit  v2 on  v1.visit_key = v2.visit_key     
     left join CDW.clinical_concept c on v1.concept_val = c.concept_id
  where v1.concept_key = <<CONCEPT_KEY>>
  and v1.CONCEPT_SRC = 'SmartForm 60523'
  order by 1, 2
