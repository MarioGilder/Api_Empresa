package com.codigo.pumaachullagildermario.controller;
import com.codigo.pumaachullagildermario.entity.EmpresaEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codigo.pumaachullagildermario.service.EmpresaService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v1/empresa")
@AllArgsConstructor
@Tag(
name ="API DE MANTENIMIENTO DE DATOS DE EMPRESAS",
description ="Esta api contiene todos los end points para realizar el mantenimiento a los datos de la entidad Empresa"
)
public class EmpresaController {

    private final EmpresaService empresaService;

    @PostMapping("/Crear")
    @Operation(summary = "crea y guarda una nueva empresa en la base de datos",
            description = "Para usar endPoint debes enviar un objeto EmpresaEntity, la cual se guardara en la base de datos previa validacion",
            parameters = {@Parameter(name = "entity", description = "filtro de empresas")})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
            description = "HTTP STATUS 200 Significa registro exitoso",
            content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "201",
                    description = "HTTP STATUS 201 Significa que se creo exitoso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "HTTP STATUS 400 Significa que el request esta mal",
                    content = @Content(mediaType = "application/json"))

    })
    public ResponseEntity<EmpresaEntity>Crear(@RequestBody EmpresaEntity entity){

        return ResponseEntity.ok(empresaService.crearEmpresa(entity));
    }
    @GetMapping("/BuscarxId/{id}")

    @Operation(summary = "Busca una empresa por id",
            description = "Para usar endPoint se debes de ejecutar, se debe de enviar un objeto de tipo empresaEntity, la cual extraera de la base de datos previa validacion",
            parameters = {@Parameter(name = "filtro", description = "Filtra por Id")})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "HTTP STATUS 200 significa que se localizo exitosamente la empresa",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",
                    description = "HTTP STATUS 404 Significa que no se encontro a la empresa por Id",
                    content = @Content(mediaType = "application/json"))
    })    public ResponseEntity<Optional<EmpresaEntity>>BuscarxId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }
    @GetMapping("/BuscarAll")
    @Operation(summary = "listar empresa",
            description = "Para usar endPoint se debes de ejecutar, Lista todas las empresas que se han guardado en la base de datos previa validacion",
            parameters = {@Parameter(name = "sin filtro", description = "muestra una lista de empresas")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "HTTP STATUS 200 Significa lista exitosa",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404",
                    description = "HTTP STATUS 404 Significa que que no se encontro lista",
                    content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<List<EmpresaEntity>>BuscarAll(){
        return ResponseEntity.ok(empresaService.listarTodo());
    }
    @PutMapping("/Actualizar/{id}")
    @Operation(summary = "Actauliza y guarda una empresa en la base de datos",
            description = "Para usar endPoint debes enviar un Id de tipo Long y objetos de tipo EmpresaEntity, la cual actualizara y guardara en la base de datos previa validacion",
            parameters = {@Parameter(name = "id", description = "filtro de empresas")})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "HTTP STATUS 200 Significa registro se actualizo exitosamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "201",
                    description = "HTTP STATUS 201 Significa que se guardo exitoso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "HTTP STATUS 404 Significa que el request esta mal",
                    content = @Content(mediaType = "application/json"))

    })
    public ResponseEntity<EmpresaEntity>Actualizar(@PathVariable long id,@RequestBody EmpresaEntity entity){
        return ResponseEntity.ok(empresaService.actualizarEmpresa(id,entity));
    }
    @DeleteMapping("/Borrar/{id}")
    @Operation(summary = "Cambia el estado a 0 y guarda una empresa en la base de datos",
            description = "Para usar endPoint debes enviar un Id de tipo Long y objetos de tipo EmpresaEntity, la cual actualizara y cambiara a 0 el estado en la base de datos previa validacion",
            parameters = {@Parameter(name = "id", description = "filtro de empresas")})

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "HTTP STATUS 200 Significa que el registro se elimino exitosamente",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "201",
                    description = "HTTP STATUS 201 Significa que se guardo exitoso",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400",
                    description = "HTTP STATUS 404 Significa que el request esta mal",
                    content = @Content(mediaType = "application/json"))

    })
    public ResponseEntity<EmpresaEntity>Borrar(@PathVariable Long id){
        return  ResponseEntity.ok(empresaService.borrarEmpresa(id));
    }

}
