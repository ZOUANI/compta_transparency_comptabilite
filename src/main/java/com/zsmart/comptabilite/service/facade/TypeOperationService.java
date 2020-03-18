package com.zsmart.comptabilite.service.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Date; 
import java.math.BigDecimal; 
import com.zsmart.comptabilite.bean.TypeOperation;
public interface TypeOperationService {

public TypeOperation save(TypeOperation typeoperation); 
public List<TypeOperation>  findAll();
public TypeOperation findById(Long id);
public int delete(TypeOperation typeoperation);
public void  deleteById(Long id);
public void clone(TypeOperation typeoperation,TypeOperation typeoperationClone);
public TypeOperation clone(TypeOperation typeoperation);
public List<TypeOperation> clone(List<TypeOperation>typeoperations);
 public List<TypeOperation>  findByCriteria(String libelle,String code,Long idMin,Long idMax);

}
