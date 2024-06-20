package org.example.autres;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Film {
    private String titre;
    private String realisateur;
    private LocalDate dateDeSortie;
    private String genre;

    public Film() {
    }

    public Film(String titre, String realisateur, LocalDate dateDeSortie, String genre) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.dateDeSortie = dateDeSortie;
        this.genre = genre;
    }

    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public LocalDate getDateDeSortie() {
        return dateDeSortie;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public void setDateDeSortie(LocalDate dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = dateDeSortie.format(formatter);

        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", dateDeSortie=" + formattedDate +
                ", genre='" + genre + '\'' +
                '}';
    }
}
