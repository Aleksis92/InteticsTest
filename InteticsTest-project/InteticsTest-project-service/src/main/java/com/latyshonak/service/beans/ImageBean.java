package com.latyshonak.service.beans;

import java.util.Arrays;

public class ImageBean {

    private Integer id;

    private String name;

    private byte[] image;

    private String description;

    private String tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageBean imageBean = (ImageBean) o;

        if (!id.equals(imageBean.id)) return false;
        if (!name.equals(imageBean.name)) return false;
        if (!Arrays.equals(image, imageBean.image)) return false;
        if (!description.equals(imageBean.description)) return false;
        return tags.equals(imageBean.tags);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + description.hashCode();
        result = 31 * result + tags.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", description='" + description + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }
}
