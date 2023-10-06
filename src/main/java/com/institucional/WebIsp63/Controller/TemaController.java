package com.institucional.WebIsp63.Controller;
import com.institucional.WebIsp63.DTO.CarreraDTO;
import com.institucional.WebIsp63.DTO.TemaDTO;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Service.TemaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tema")

public class TemaController {
    @Autowired
    TemaServiceImp temaService= new TemaServiceImp();
    @GetMapping
    public ResponseEntity<List<TemaDTO>> finAll() throws ResourceNotFoundException {
        List<TemaDTO> list = temaService.findAll();
        return  ResponseEntity.status( HttpStatus.OK).body(list);
    }

    @GetMapping("/temas/{libros}")
    public ResponseEntity<List<TemaDTO>>listarTodostemas(@PathVariable String tema){

        List<TemaDTO> list= temaService.findAllTema(tema);
        return  ResponseEntity.status( HttpStatus.OK).body(list);

    }
    @PostMapping( "/create")
    public ResponseEntity< TemaDTO >guardar (@RequestBody TemaDTO temaDTO)
    {
        TemaDTO temaCreado =  temaService.guardartema(temaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(temaCreado);
    }

    @PutMapping("/update")
    public  ResponseEntity<TemaDTO> modificar ( @RequestBody TemaDTO temaDTO){
        TemaDTO temaModificado= temaService.modificartema(temaDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .body(temaModificado);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<TemaDTO> buscar (@PathVariable Long id) throws ResourceNotFoundException {
        return  ResponseEntity.status( HttpStatus.OK)
                .body( temaService.buscar(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrar(@PathVariable long id){
        if (!temaService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tema no encontrada ID: " + id);
        }

        temaService.eliminarTema(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Tema borrado");

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }



}

