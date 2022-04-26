package com.strankd.myOwnSpringProject.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.strankd.myOwnSpringProject.states.Access;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

@Entity
public class PasteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private String hash;
    private Access access;

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public PasteModel(Long id, String name, LocalDateTime time, Access access) {
        this.id = id;
        this.data = name;
        this.time = time;
        this.access = access;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public PasteModel() {

    }


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
