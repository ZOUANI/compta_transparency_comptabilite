package com.zsmart.comptabilite.ws.rest.converter;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zsmart.comptabilite.service.util.*;
import com.zsmart.comptabilite.bean.TypeOperation; 
import com.zsmart.comptabilite.ws.rest.vo.TypeOperationVo; 

 @Component 
public class TypeOperationConverter extends AbstractConverter<TypeOperation,TypeOperationVo>{ 


 @Override 
 public TypeOperation toItem(TypeOperationVo vo) {
 if (vo == null) {
    return null;
      } else {
TypeOperation item = new TypeOperation();

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
 public TypeOperationVo toVo(TypeOperation item) {
 if (item == null) {
    return null;
      } else {
TypeOperationVo vo = new TypeOperationVo();

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
