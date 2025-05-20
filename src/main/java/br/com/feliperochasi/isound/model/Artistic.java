package br.com.feliperochasi.isound.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "artistics")
public class Artistic {
    @Column(unique = true)
    private String name;
    private TypeArtistic typeArtistic;
    private LocalDate releasedDate;

    public Artistic() {}

    public Artistic(String name, TypeArtistic typeArtistic, LocalDate releasedDate) {
        this.name = name;
        this.typeArtistic = typeArtistic;
        this.releasedDate = releasedDate;
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

    @Override
    public String toString() {
        return "Artistic{" +
                "name='" + name + '\'' +
                ", typeArtistic=" + typeArtistic +
                ", releasedDate=" + releasedDate +
                '}';
    }
}
