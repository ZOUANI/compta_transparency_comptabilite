package com.zsmart.comptabilite.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.comptabilite.service.util.*;
import com.zsmart.comptabilite.bean.EtatOperationComptable; 
import com.zsmart.comptabilite.ws.rest.vo.EtatOperationComptableVo; 

 @Component 
public class EtatOperationComptableConverter extends AbstractConverter<EtatOperationComptable,EtatOperationComptableVo>{ 


 @Override 
 public EtatOperationComptable toItem(EtatOperationComptableVo vo) {
 if (vo == null) {
    return null;
      } else {
EtatOperationComptable item = new EtatOperationComptable();

 if (StringUtil.isNotEmpty(vo.getLibelle())) {
 item.setLibelle(vo.getLibelle());
} 

 if (StringUtil.isNotEmpty(vo.getCode())) {
 item.setCode(vo.getCode());
} 

 if (vo.getId() != null) {
 item.setId(NumberUtil.toLong(vo.getId()));
} 

return item;
 }
 }

  @Override 
 public EtatOperationComptableVo toVo(EtatOperationComptable item) {
 if (item == null) {
    return null;
      } else {
EtatOperationComptableVo vo = new EtatOperationComptableVo();

 if (StringUtil.isNotEmpty(item.getLibelle())) {
 vo.setLibelle(item.getLibelle());
} 

 if (StringUtil.isNotEmpty(item.getCode())) {
 vo.setCode(item.getCode());
} 

 if (item.getId() != null) {
 vo.setId(NumberUtil.toString(item.getId()));
} 

return vo;
 }
 }
public void init() { 
}
 } 
