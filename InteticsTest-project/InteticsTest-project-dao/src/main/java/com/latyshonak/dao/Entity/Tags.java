package com.latyshonak.dao.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "tag")
    private String tag;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "images_to_tags",
            joinColumns = {
                    @JoinColumn(name = "fk_tags_id")},
            inverseJoinColumns = {@JoinColumn(name = "fk_images_id")})
    private List<Images> images;

    public Tags() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public void addImage(Images image) {
        this.images.add(image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (!id.equals(tags.id)) return false;
        if (!tag.equals(tags.tag)) return false;
        return images.equals(tags.images);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tag.hashCode();
        result = 31 * result + images.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", images=" + images +
                '}';
    }
}
