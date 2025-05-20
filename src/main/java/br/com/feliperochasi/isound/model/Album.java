package br.com.feliperochasi.isound.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;
    @ManyToOne
    private Artistic artistic;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Music> music;

    public Album() {}

    public Album(String title, Artistic artistic, List<Music> music) {
        this.title = title;
        this.artistic = artistic;
        this.music = music;
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

    public Artistic getArtistic() {
        return artistic;
    }

    public void setArtistic(Artistic artistic) {
        this.artistic = artistic;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistic=" + artistic +
                ", music=" + music +
                '}';
    }
}
