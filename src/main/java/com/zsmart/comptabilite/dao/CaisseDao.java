package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.Caisse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface CaisseDao extends JpaRepository<Caisse,Long> {




}
