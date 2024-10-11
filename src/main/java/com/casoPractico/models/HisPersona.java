package com.casoPractico.models;

import jakarta.persistence.*;

@Table(name = "caso_HisPersona")
@Entity
public class HisPersona {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQPF1")
    @SequenceGenerator(sequenceName = "customer_seqpf1", allocationSize = 1, name = "CUST_SEQPF1")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @ManyToOne // Puedes cambiar a @OneToOne si es una relación uno a uno
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona persona;

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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
