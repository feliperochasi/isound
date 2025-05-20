package br.com.feliperochasi.isound.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "musics")
public class Music {
    @Column(unique = true)
    private String title;
    private Double duration;
    private LocalDate releasedDate;
    private Album album;
    private Artistic artistic;

    public Music() {}

    public Music(String title, Double duration, LocalDate releasedDate, Album album, Artistic artistic) {
        this.title = title;
        this.duration = duration;
        this.releasedDate = releasedDate;
        this.album = album;
        this.artistic = artistic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artistic getArtistic() {
        return artistic;
    }

    public void setArtistic(Artistic artistic) {
        this.artistic = artistic;
    }

    @Override
    public String toString() {
        return "Music{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", releasedDate=" + releasedDate +
                ", album=" + album +
                ", artistic=" + artistic +
                '}';
    }
}
