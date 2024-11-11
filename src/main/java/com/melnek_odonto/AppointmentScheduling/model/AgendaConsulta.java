package com.melnek_odonto.AppointmentScheduling.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Agenda")
public class AgendaConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 80)
    private String clienteName;

    @Column(nullable = false, length = 11)
    private String cpfCliente;

    @Column(nullable = false, length = 80)
    private String draName;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAgendada;

    @Column(nullable = false, length = 20)
    private String especialidade;

    public AgendaConsulta(){};

    public AgendaConsulta(Long id, String clienteName, String cpfCliente, String draName, LocalDateTime dataAgendada, String especialidade) {
        this.id = id;
        this.clienteName = clienteName;
        this.cpfCliente = cpfCliente;
        this.draName = draName;
        this.dataAgendada = dataAgendada;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClienteName() {
        return clienteName;
    }

    public void setClienteName(String clienteName) {
        this.clienteName = clienteName;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getDraName() {
        return draName;
    }

    public void setDraName(String draName) {
        this.draName = draName;
    }

    public LocalDateTime getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDateTime dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
