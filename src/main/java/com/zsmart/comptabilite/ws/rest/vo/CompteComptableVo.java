package com.zsmart.comptabilite.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class CompteComptableVo{

private String id ;
private String code ;
private String libelle ;
private SousClasseComptableVo sousClasseComptableVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getCode(){
    return code;
}

public void setCode(String  code){
     this.code = code;
}

public String  getLibelle(){
    return libelle;
}

public void setLibelle(String  libelle){
     this.libelle = libelle;
}

public SousClasseComptableVo  getSousClasseComptableVo (){
    return sousClasseComptableVo ;
}

public void setSousClasseComptableVo (SousClasseComptableVo  sousClasseComptableVo ){
     this.sousClasseComptableVo  = sousClasseComptableVo ;
}




}