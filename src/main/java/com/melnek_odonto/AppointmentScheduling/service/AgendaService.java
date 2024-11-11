package com.melnek_odonto.AppointmentScheduling.service;

import com.melnek_odonto.AppointmentScheduling.exceptions.*;
import com.melnek_odonto.AppointmentScheduling.model.AgendaConsulta;
import com.melnek_odonto.AppointmentScheduling.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaService {


    @Autowired
    private AgendaRepository agendaRepository;

    public AgendaConsulta findById(Long id) {
        if (id == null) {
            throw new IdCannotNullException("Por favor informe o ID");
        } else {

            return agendaRepository.findById(id)
                    .orElseThrow(() -> new NotFoundIdException("Não foi localizada nenhuma consulta para o ID: " + id));
        }
    }

    public AgendaConsulta findByCpfCliente(String cpfCliente) {
        if (cpfCliente == null) {
            throw new CpfCannotNullException("Por favor informe o CPF do Cliente");
        } else {

            return agendaRepository.findByCpfCliente(cpfCliente)
                    .orElseThrow(() -> new CpfNotFoundException("Não foi localizada nenhuma consulta para o Cliente de CPF: " + cpfCliente));
        }
    }

    public List<AgendaConsulta> findAllConsultas() {
        return agendaRepository.findAll();
    }

    //POST
    public AgendaConsulta save(AgendaConsulta agendaConsulta) {
        if (agendaRepository.existsByDataAgendada(agendaConsulta.getDataAgendada())) {
            throw new LocalDateTimeAlreadyInUseException("Data e hora de consulta já está reservada por outro Cliente");
        } else {
            return agendaRepository.save(agendaConsulta);
        }
    }

    //PUT
    public AgendaConsulta updateConsulta(Long id, AgendaConsulta agendaUpdated) {
        AgendaConsulta consultaExistente = this.findById(id);

        // Atualizando os campos com os valores de agendaUpdated
        consultaExistente.setClienteName(agendaUpdated.getClienteName());
        consultaExistente.setCpfCliente(agendaUpdated.getCpfCliente());
        consultaExistente.setEspecialidade(agendaUpdated.getEspecialidade());
        consultaExistente.setDraName(agendaUpdated.getDraName());
        consultaExistente.setDataAgendada(agendaUpdated.getDataAgendada());  // Atualizando a data

        // Salvando a consulta atualizada
        return agendaRepository.save(consultaExistente);
    }

    //DELETE
    public void deleteConsulta(Long id) {
        AgendaConsulta agendaConsulta = this.findById(id);
        agendaRepository.deleteById(id);
    }
}
