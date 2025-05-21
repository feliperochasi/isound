package br.com.feliperochasi.isound.model;

public enum TypeArtistic {
    SOLO("solo"),
    DUE("dupla"),
    BAND("banda");
    private final String type;

    TypeArtistic(String type) {
        this.type = type;
    }

    public static TypeArtistic fromString(String s) {
        for ( TypeArtistic typeArtistic : TypeArtistic.values()) {
            if(typeArtistic.type.equalsIgnoreCase(s)) {
                return typeArtistic;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo de artista encontrado para esta opcao: " + s);
    }
}
