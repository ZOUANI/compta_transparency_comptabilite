package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.ClasseComptable;
import com.zsmart.comptabilite.bean.SousClasseComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface SousClasseComptableDao extends JpaRepository<SousClasseComptable,Long> {


	 public SousClasseComptable findByClasseComptable(ClasseComptable classeComptable);

	 public int deleteByClasseComptable(ClasseComptable classeComptable);

}
