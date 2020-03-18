package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.ClasseComptable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface ClasseComptableDao extends JpaRepository<ClasseComptable,Long> {




}
