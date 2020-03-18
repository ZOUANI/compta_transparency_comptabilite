package com.zsmart.comptabilite.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.comptabilite.bean.EtatOperationComptable;
public interface EtatOperationComptableService {

public EtatOperationComptable save(EtatOperationComptable etatoperationcomptable); 
public List<EtatOperationComptable>  findAll();
public EtatOperationComptable findById(Long id);
public int delete(EtatOperationComptable etatoperationcomptable);
public void  deleteById(Long id);
public void clone(EtatOperationComptable etatoperationcomptable,EtatOperationComptable etatoperationcomptableClone);
public EtatOperationComptable clone(EtatOperationComptable etatoperationcomptable);
public List<EtatOperationComptable> clone(List<EtatOperationComptable>etatoperationcomptables);
 public List<EtatOperationComptable>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
