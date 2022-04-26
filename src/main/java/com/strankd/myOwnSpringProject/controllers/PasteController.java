package com.strankd.myOwnSpringProject.controllers;

import com.strankd.myOwnSpringProject.Entity.PasteModel;
import com.strankd.myOwnSpringProject.service.IPasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paste-system")
public class PasteController {

    private final IPasteService pasteService;

    @Autowired
    public PasteController(IPasteService service) {
        this.pasteService = service;
    }

    @PostMapping("/create")
    public String createPaste(@RequestBody PasteModel model){
        return pasteService.createPaste(model);
    }

    @GetMapping("/all-paste")
    public List<PasteModel> getAll(){
        return pasteService.getAll();
    }

    @GetMapping("/{hash}")
    public PasteModel getByHash(@PathVariable("hash") String hash){
        return pasteService.getByHash(hash);
    }

}