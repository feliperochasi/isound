package br.com.feliperochasi.isound.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artistics")
public class Artistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TypeArtistic typeArtistic;
    private LocalDate releasedDate;

    @OneToMany(mappedBy = "artistic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics;

    @OneToMany(mappedBy = "artistic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Album> album;

    public Artistic() {}

    public Artistic(String name, String typeArtistic, String releasedDate) {
        this.name = name;
        this.typeArtistic = TypeArtistic.fromString(typeArtistic);
        this.releasedDate = LocalDate.parse(releasedDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeArtistic getTypeArtistic() {
        return typeArtistic;
    }

    public void setTypeArtistic(TypeArtistic typeArtistic) {
        this.typeArtistic = typeArtistic;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        musics.forEach(m -> m.setArtistic(this));
        this.musics = musics;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        album.forEach(a -> a.setArtistic(this));
        this.album = album;
    }

    @Override
    public String toString() {
        return "Artistic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeArtistic=" + typeArtistic +
                ", releasedDate=" + releasedDate +
                ", album=" + album +
                '}';
    }
}
