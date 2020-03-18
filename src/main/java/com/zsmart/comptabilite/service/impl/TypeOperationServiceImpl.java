
package com.zsmart.comptabilite.service.impl ;
import com.zsmart.comptabilite.service.facade.TypeOperationService ; 
import com.zsmart.comptabilite.dao.TypeOperationDao ;
import com.zsmart.comptabilite.service.util.SearchUtil;
import com.zsmart.comptabilite.bean.TypeOperation;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TypeOperationServiceImpl implements TypeOperationService  {


 @Autowired 

 private TypeOperationDao typeoperationDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TypeOperation  save (TypeOperation typeoperation){

if(typeoperation== null){ 
 return null; 
}else {
 typeoperationDao.save(typeoperation);
return typeoperation;
}
}

 @Override 
public List< TypeOperation>  findAll(){
 return typeoperationDao.findAll();
}

 @Override 
public TypeOperation findById(Long id){
 return typeoperationDao.getOne(id);
}

 @Override 
public int delete(TypeOperation typeoperation){
if(typeoperation== null){ 
  return -1; 
}else {
 typeoperationDao.delete(typeoperation);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       typeoperationDao.deleteById(id);
}
public void clone(TypeOperation typeoperation,TypeOperation typeoperationClone){
if(typeoperation!= null && typeoperationClone != null){
typeoperationClone.setId(typeoperation.getId());
typeoperationClone.setLibelle(typeoperation.getLibelle());
typeoperationClone.setCode(typeoperation.getCode());
}
}
public TypeOperation clone(TypeOperation typeoperation){
if(typeoperation== null){       return null ;
}else{TypeOperation typeoperationClone= new TypeOperation();
typeoperationClone.setId(typeoperation.getId());
typeoperationClone.setLibelle(typeoperation.getLibelle());
typeoperationClone.setCode(typeoperation.getCode());
return typeoperationClone;
}
}
public List<TypeOperation> clone(List<TypeOperation>typeoperations){
if(typeoperations== null){
       return null ;
}else{List<TypeOperation> typeoperationsClone = new ArrayList();
	 	 	 typeoperations.forEach((typeoperation)->{typeoperationsClone.add(clone(typeoperation));
});return typeoperationsClone;
}
}
 @Override 
 public List< TypeOperation>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT t FROM TypeOperation t where 1=1 ";
query += SearchUtil.addConstraint( "t", "libelle","=",libelle);
query += SearchUtil.addConstraint( "t", "code","=",code);
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);

  return query; 
}
}
