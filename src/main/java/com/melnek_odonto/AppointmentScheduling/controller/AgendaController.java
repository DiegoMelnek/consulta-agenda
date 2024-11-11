package com.melnek_odonto.AppointmentScheduling.controller;

import com.melnek_odonto.AppointmentScheduling.model.AgendaConsulta;
import com.melnek_odonto.AppointmentScheduling.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class AgendaController {

    @Autowired
    public AgendaService agendaService;

    @GetMapping
    public ResponseEntity<List<AgendaConsulta>> findAll() {
        List<AgendaConsulta> consultas = agendaService.findAllConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AgendaConsulta> findById(@PathVariable Long id) {
        AgendaConsulta agendaConsulta = agendaService.findById(id);
        return ResponseEntity.ok(agendaConsulta);
    }

    @GetMapping({"/cpf/{cpfCliente}", "/cpf"})
    public ResponseEntity<AgendaConsulta> findByCpfCliente(@PathVariable(required = false) String cpfCliente) {
        AgendaConsulta agendaConsulta = agendaService.findByCpfCliente(cpfCliente);
        return ResponseEntity.ok(agendaConsulta);
    }

    @PostMapping
    public ResponseEntity<AgendaConsulta> createConsulta(@RequestBody AgendaConsulta agendaConsulta){
        AgendaConsulta novaConsulta = agendaService.save(agendaConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(agendaConsulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaConsulta> updateConsulta(@PathVariable Long id, @RequestBody AgendaConsulta consultaUpdated) {
        AgendaConsulta consultaModificada = agendaService.updateConsulta(id, consultaUpdated);
        return ResponseEntity.status(HttpStatus.OK).body(consultaModificada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id){
        agendaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
