package com.zsmart.comptabilite.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.comptabilite.bean.OperationComptable;
import com.zsmart.comptabilite.bean.Caisse; 
import com.zsmart.comptabilite.bean.TypeOperation; 
import com.zsmart.comptabilite.bean.CompteBanquaire; 
import com.zsmart.comptabilite.bean.CompteComptable; 
public interface OperationComptableService {

public OperationComptable save(OperationComptable operationcomptable); 
public List<OperationComptable>  findAll();
public OperationComptable findById(Long id);
public int delete(OperationComptable operationcomptable);
public void  deleteById(Long id);
public void clone(OperationComptable operationcomptable,OperationComptable operationcomptableClone);
public OperationComptable clone(OperationComptable operationcomptable);
public List<OperationComptable> clone(List<OperationComptable>operationcomptables);
 public List<OperationComptable>  findByCriteria(String libelle,String referenceSociete,String referenceFacture,Long idMin,Long idMax,BigDecimal montantMin,BigDecimal montantMax,Date dateOperationComptableMin,Date dateOperationComptableMax,Date dateSaisieMin,Date dateSaisieMax);

}
