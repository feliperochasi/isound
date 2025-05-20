package br.com.feliperochasi.isound.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "albums")
public class Album {
    @Column(unique = true)
    private String title;
    private Artistic artistic;
    private Music music;

    public Album() {}

    public Album(String title, Artistic artistic, Music music) {
        this.title = title;
        this.artistic = artistic;
        this.music = music;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artistic getArtistic() {
        return artistic;
    }

    public void setArtistic(Artistic artistic) {
        this.artistic = artistic;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artistic=" + artistic +
                ", music=" + music +
                '}';
    }
}
