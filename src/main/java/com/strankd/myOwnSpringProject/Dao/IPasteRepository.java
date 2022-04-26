package com.strankd.myOwnSpringProject.Dao;

import com.strankd.myOwnSpringProject.Entity.PasteModel;

import java.util.List;

public interface IPasteRepository {
    String create(PasteModel pasteModel);
    List<PasteModel> getAll();
    PasteModel getByHash(String hash);
}
