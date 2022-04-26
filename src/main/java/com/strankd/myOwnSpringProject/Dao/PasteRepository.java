package com.strankd.myOwnSpringProject.Dao;

import com.strankd.myOwnSpringProject.Entity.PasteModel;
import com.strankd.myOwnSpringProject.states.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PasteRepository implements IPasteRepository{
    private int id;
    private final List<PasteModel> pastes;

    @Autowired
    public PasteRepository(List<PasteModel> pastes) {
        id = 0;
        this.pastes = pastes;
    }

    @Override
    public String create(PasteModel pasteModelRequest){
        var id = generateId();
        PasteModel pasteModel = new PasteModel();
        pasteModel.setData(pasteModelRequest.getData());
        pasteModel.setId(id);
        pasteModel.setTime(pasteModelRequest.getTime());
        pasteModel.setHash(Integer.toHexString((int) id));
        pasteModel.setAccess(Access.valueOf((pasteModelRequest.getAccess().name())));
        pastes.add(pasteModel);
        return pasteModel.getHash();
    }

    @Override
    public List<PasteModel> getAll(){
        return pastes;
    }

    @Override
    public PasteModel getByHash(String hash) {
        return pastes.stream().filter(x -> x.getHash().equals(hash))
                .findFirst().get();
    }
    private long generateId(){
        return ++id;
    }
}
