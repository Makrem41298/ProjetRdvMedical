package com.app.rdv.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Rdv {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",shape = JsonFormat.Shape.STRING)
    private LocalDateTime dateRdv;
    private String etat;
    @ManyToOne
    private Patient patient;

    @ManyToOne

    private Medecin medecin;
}
