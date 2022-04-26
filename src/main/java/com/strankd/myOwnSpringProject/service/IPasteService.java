package com.strankd.myOwnSpringProject.service;

import com.strankd.myOwnSpringProject.Entity.PasteModel;

import java.util.List;

public interface IPasteService {
    PasteModel getByHash(String hash);
    String createPaste(PasteModel pasteModel);
    List<PasteModel> getAll();
}
