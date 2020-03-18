package com.zsmart.comptabilite.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.comptabilite.bean.SousClasseComptable;
import com.zsmart.comptabilite.bean.ClasseComptable; 
public interface SousClasseComptableService {

public SousClasseComptable save(SousClasseComptable sousclassecomptable); 
public SousClasseComptable  saveWithCompteComptables (SousClasseComptable sousclassecomptable);public List<SousClasseComptable>  findAll();
public SousClasseComptable findById(Long id);
public int delete(SousClasseComptable sousclassecomptable);
public void  deleteById(Long id);
public void clone(SousClasseComptable sousclassecomptable,SousClasseComptable sousclassecomptableClone);
public SousClasseComptable clone(SousClasseComptable sousclassecomptable);
public List<SousClasseComptable> clone(List<SousClasseComptable>sousclassecomptables);
 public List<SousClasseComptable>  findByCriteria(String libelle,Long idMin,Long idMax,Integer numeroMin,Integer numeroMax);

}
