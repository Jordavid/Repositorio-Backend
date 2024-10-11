package com.casoPractico.models;

import jakarta.persistence.*;

@Table(name = "caso_Persona")
@Entity
public class Persona {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQPF1")
    @SequenceGenerator(sequenceName = "customer_seqpf1", allocationSize = 1, name = "CUST_SEQPF1")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
