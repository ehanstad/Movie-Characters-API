package com.hibernatemovie.controllers;

import com.hibernatemovie.models.Character;
import com.hibernatemovie.models.Franchise;
import com.hibernatemovie.services.franchise.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchise")
public class FranchiseController {
    private FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping
    public ResponseEntity<Collection<Franchise>> getAll() {
        return  ResponseEntity.ok(franchiseService.findAll());
    }
}
