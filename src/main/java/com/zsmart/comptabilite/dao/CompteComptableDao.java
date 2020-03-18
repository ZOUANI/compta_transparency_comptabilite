package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.SousClasseComptable;
import com.zsmart.comptabilite.bean.CompteComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CompteComptableDao extends JpaRepository<CompteComptable,Long> {


	 public CompteComptable findBySousClasseComptable(SousClasseComptable sousClasseComptable);

	 public int deleteBySousClasseComptable(SousClasseComptable sousClasseComptable);

}
