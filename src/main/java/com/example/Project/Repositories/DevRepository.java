package com.example.Project.Repositories;

import com.example.Project.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DevRepository extends JpaRepository<Dev, Integer> {

    List<Dev> findByUser_Site(int site);
    @Query("SELECT d FROM Dev d WHERE d.cdc.idCdc=:idCdc")
    List<Dev> findByCDC(@Param("idCdc") Integer idCdc);

    List<Dev> findByDll(String dll);
    List<Dev> findByMaj(Maj maj);
    List<Dev> getByUser(User user);


    List<Dev> findByVehicules( Vehicule vehicule);
}
