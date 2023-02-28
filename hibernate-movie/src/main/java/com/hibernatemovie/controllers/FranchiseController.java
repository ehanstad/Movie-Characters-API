package com.hibernatemovie.controllers;

import com.hibernatemovie.mappers.FranchiseMapper;
import com.hibernatemovie.models.dtos.FranchiseDTO;
import com.hibernatemovie.services.franchise.FranchiseService;
import com.hibernatemovie.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchise")
public class FranchiseController {
    private FranchiseService franchiseService;
    private FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @Operation(summary = "Get all franchises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))})
    })
    @GetMapping
    public ResponseEntity<Collection<FranchiseDTO>> getAll() {
        Collection<FranchiseDTO> franchiseDTOs = franchiseMapper.franchiseToFranchiseDto(franchiseService.findAll());
        return  ResponseEntity.ok(franchiseDTOs);
    }

    @Operation(summary = "Get franchise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Character does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity<FranchiseDTO> getById(@PathVariable int id) {
        FranchiseDTO franchiseDTO = franchiseMapper.franchiseToFranchiseDto(franchiseService.findById(id));
        return  ResponseEntity.ok(franchiseDTO);
    }

    @Operation(summary = "Add franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Bad request",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping("add")
    public ResponseEntity add(@RequestBody FranchiseDTO franchiseDTO) {
        franchiseService.add(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Success",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("{id}")
    public ResponseEntity updateFranchise(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if(id != franchiseDTO.getId())
            return ResponseEntity.notFound().build();
        franchiseService.update(franchiseMapper.franchiseDtoToFranchise(franchiseDTO));
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Successfully deleted",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FranchiseDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @DeleteMapping("{id}")
    public ResponseEntity deleteFranchise(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
