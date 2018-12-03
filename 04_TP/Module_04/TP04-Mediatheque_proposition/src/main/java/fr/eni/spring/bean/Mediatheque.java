package fr.eni.spring.bean;

import java.util.ArrayList;
import java.util.List;

import fr.eni.spring.bean.type.TypeTheque;

public class Mediatheque {

    private List<Media> collection;
    private TypeTheque type;

    public Mediatheque(List<Media> collection, TypeTheque type) {
        this.collection = collection;
        this.type = type;
    }

    public Mediatheque() {
        this.collection = new ArrayList<>();
    }

    public List<Media> getCollection() {
        return collection;
    }

    public void setCollection(List<Media> collection) {
        this.collection = collection;
    }

    public TypeTheque getType() {
        return type;
    }

    public void setType(TypeTheque type) {
        this.type = type;
    }

}
