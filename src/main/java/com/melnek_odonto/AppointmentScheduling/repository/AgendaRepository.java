package com.melnek_odonto.AppointmentScheduling.repository;

import com.melnek_odonto.AppointmentScheduling.model.AgendaConsulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaConsulta, Long> {

    List<AgendaConsulta> findAll();

    Optional<AgendaConsulta> findById(Long id);

    Optional<AgendaConsulta> findByCpfCliente(String cpfCliente);

    boolean existsByDataAgendada(LocalDateTime dataAgendada);
}
