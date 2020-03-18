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
import com.zsmart.comptabilite.service.facade.EtatOperationComptableService;
import com.zsmart.comptabilite.bean.EtatOperationComptable;
import com.zsmart.comptabilite.ws.rest.vo.EtatOperationComptableVo;
import com.zsmart.comptabilite.ws.rest.converter.EtatOperationComptableConverter;
import com.zsmart.comptabilite.service.util.* ;
@RestController
@RequestMapping("/comptabilite/EtatOperationComptable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatOperationComptableRest {

 @Autowired 
 private EtatOperationComptableService etatOperationComptableService;

 @Autowired 
private EtatOperationComptableConverter etatOperationComptableConverter ;

@PostMapping("/")
public EtatOperationComptableVo save(@RequestBody EtatOperationComptableVo etatOperationComptableVo){
EtatOperationComptable etatOperationComptable= etatOperationComptableConverter.toItem(etatOperationComptableVo);
return etatOperationComptableConverter.toVo(etatOperationComptableService.save(etatOperationComptable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
etatOperationComptableService.deleteById(id);
}
@GetMapping("/")
public List<EtatOperationComptableVo> findAll(){
return etatOperationComptableConverter.toVo(etatOperationComptableService.findAll());
}

 public EtatOperationComptableConverter getEtatOperationComptableConverter(){
return etatOperationComptableConverter;
}
 
 public void setEtatOperationComptableConverter(EtatOperationComptableConverter etatOperationComptableConverter){
this.etatOperationComptableConverter=etatOperationComptableConverter;
}

 public EtatOperationComptableService getEtatOperationComptableService(){
return etatOperationComptableService;
}
 
 public void setEtatOperationComptableService(EtatOperationComptableService etatOperationComptableService){
this.etatOperationComptableService=etatOperationComptableService;
}

}