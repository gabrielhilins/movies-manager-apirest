package com.example.GerenciaFilmes.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int rating; // Nota atribuída ao filme, por exemplo, de 1 a 5

    @Column(length = 500)
    private String review; // Comentário sobre o filme

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie; // Referência ao filme que está sendo avaliado

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Referência ao usuário que fez a avaliação
}