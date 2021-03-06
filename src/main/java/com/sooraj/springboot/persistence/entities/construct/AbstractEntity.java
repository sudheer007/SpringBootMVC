package com.sooraj.springboot.persistence.entities.construct;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by SOORAJ on 11-12-2016.
 */
@MappedSuperclass
public abstract class AbstractEntity<E extends Serializable>
        implements Entity<E> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = true, nullable = false, unique = true, updatable = true)
    private E id;

    protected AbstractEntity(Class<? extends Entity> entity) {
        final Class<? extends Entity> entityObject = entity;
        System.out.println(entity.getCanonicalName());
    }

    @Override
    public E getId() {
        return id;
    }

    public void setId(E id) {
        this.id = id;
    }

    @PrePersist
    protected void prePersist() {
    }

    @PreUpdate
    protected void preUpdate() {
    }

    @PreRemove
    protected void preRemove() {
    }

    @Override
    public int compareTo(Object o) {

        if (o instanceof Entity) {
            Entity entity = (Entity) o;
            return 0;
        }
        return 1;
    }

}