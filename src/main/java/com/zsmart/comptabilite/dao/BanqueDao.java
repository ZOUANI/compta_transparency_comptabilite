package com.zsmart.comptabilite.dao;
import com.zsmart.comptabilite.bean.Banque;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface BanqueDao extends JpaRepository<Banque,Long> {




}
