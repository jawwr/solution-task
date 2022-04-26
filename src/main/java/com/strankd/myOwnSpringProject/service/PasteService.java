package com.strankd.myOwnSpringProject.service;

import com.strankd.myOwnSpringProject.Dao.IPasteRepository;
import com.strankd.myOwnSpringProject.Dao.PasteRepository;
import com.strankd.myOwnSpringProject.Entity.PasteModel;
import com.strankd.myOwnSpringProject.states.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasteService implements IPasteService{

    private final IPasteRepository repository;

    @Autowired
    public PasteService(PasteRepository repository) {
        this.repository = repository;
    }

    @Override
    public PasteModel getByHash(String hash) {
        var paste = repository.getByHash(hash);
        try{
            var now = LocalDateTime.now();
            if (!paste.getTime().isAfter(now))
                throw new Exception("");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return paste;
    }

    @Override
    public String createPaste(PasteModel pasteModel) {
        return repository.create(pasteModel);
    }

    @Override
    public List<PasteModel> getAll() {
        var now  = LocalDateTime.now();
        return repository.getAll().stream().filter(x -> x.getAccess() == Access.Public)
                .filter(x -> x.getTime().isAfter(now))
                .limit(10)
                .collect(Collectors.toList());
    }
}
