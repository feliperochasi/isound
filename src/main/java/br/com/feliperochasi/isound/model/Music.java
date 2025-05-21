package br.com.feliperochasi.isound.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    private Double duration;
    private LocalDate releasedDate;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Artistic artistic;

    public Music() {}

    public Music(String title, Double duration, String releasedDate, Album album, Artistic artistic) {
        this.title = title;
        this.duration = duration;
        this.releasedDate = LocalDate.parse(releasedDate);
        this.album = album;
        this.artistic = artistic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releasedDate=" + releasedDate +
                '}';
    }
}
