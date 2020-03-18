package com.zsmart.comptabilite.ws.rest.provided ;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.comptabilite.service.facade.TypeOperationService;
import com.zsmart.comptabilite.bean.TypeOperation;
import com.zsmart.comptabilite.ws.rest.vo.TypeOperationVo;
import com.zsmart.comptabilite.ws.rest.converter.TypeOperationConverter;
import com.zsmart.comptabilite.service.util.* ;
@RestController
@RequestMapping("/comptabilite/TypeOperation")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeOperationRest {

 @Autowired 
 private TypeOperationService typeOperationService;

 @Autowired 
private TypeOperationConverter typeOperationConverter ;

@PostMapping("/")
public TypeOperationVo save(@RequestBody TypeOperationVo typeOperationVo){
TypeOperation typeOperation= typeOperationConverter.toItem(typeOperationVo);
return typeOperationConverter.toVo(typeOperationService.save(typeOperation));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeOperationService.deleteById(id);
}
@GetMapping("/")
public List<TypeOperationVo> findAll(){
return typeOperationConverter.toVo(typeOperationService.findAll());
}

 public TypeOperationConverter getTypeOperationConverter(){
return typeOperationConverter;
}
 
 public void setTypeOperationConverter(TypeOperationConverter typeOperationConverter){
this.typeOperationConverter=typeOperationConverter;
}

 public TypeOperationService getTypeOperationService(){
return typeOperationService;
}
 
 public void setTypeOperationService(TypeOperationService typeOperationService){
this.typeOperationService=typeOperationService;
}

}