package com.dh.Clinica.repository;

import com.dh.Clinica.entity.Domicilio;
import com.dh.Clinica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
