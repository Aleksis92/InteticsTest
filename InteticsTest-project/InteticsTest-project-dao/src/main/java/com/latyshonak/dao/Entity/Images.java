package com.latyshonak.dao.Entity;

import javax.persistence.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "images")
public class Images {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;

        @Column(name = "image")
        private byte[] image;

        @Column(name = "name")
        private String name;

        @Column(name = "description")
        private String description;

        @ManyToMany(fetch = FetchType.LAZY, mappedBy = "images")
        private List<Tags> tags;

        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "users_to_images",
            joinColumns = {
                    @JoinColumn(name = "fk_id_images")},
            inverseJoinColumns = { @JoinColumn(name = "fk_id_user") })
        private List<Users> users;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public byte[] getImage() {
            return image;
        }

        public void setImage(byte[] image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Tags> getTags() {
            return tags;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Images images = (Images) o;

            if (!id.equals(images.id)) return false;
            if (!Arrays.equals(image, images.image)) return false;
            if (!name.equals(images.name)) return false;
            if (!description.equals(images.description)) return false;
            return tags.equals(images.tags);
        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + Arrays.hashCode(image);
            result = 31 * result + name.hashCode();
            result = 31 * result + description.hashCode();
            result = 31 * result + tags.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Images{" +
                    "id=" + id +
                    ", image=" + Arrays.toString(image) +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", tags=" + tags +
                    '}';
        }
}
