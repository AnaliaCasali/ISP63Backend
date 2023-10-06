package com.institucional.WebIsp63.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.institucional.WebIsp63.DTO.CarreraDTO;

import com.institucional.WebIsp63.DTO.MensajeDTO;

import com.institucional.WebIsp63.Entity.Imagen;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import com.institucional.WebIsp63.Service.CarreraServiceImpl;
import com.institucional.WebIsp63.Service.CloudinaryService;
import com.institucional.WebIsp63.Service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.MediaType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrera")
//@CrossOrigin(origins = "https://localhost:4200/carrera")

public class CarreraController {

    @Autowired
    CarreraServiceImpl carreraService ;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;
    @GetMapping
    public ResponseEntity<List<CarreraDTO>>  finAll() throws ResourceNotFoundException {
        //return carreraService.findAll();
        List<CarreraDTO> list = carreraService.findAll();
        return  ResponseEntity.status( HttpStatus.OK).body(list);
    }
    @GetMapping("/sede/{sede}")
    public ResponseEntity<List<CarreraDTO>> finAllBySede(@PathVariable String sede) throws ResourceNotFoundException {
        List<CarreraDTO> list=carreraService.findAllBySede(sede);
        return  ResponseEntity.status( HttpStatus.OK)
                .body(list);
    }
    @PostMapping("/createSolo")
    public ResponseEntity<CarreraDTO> guardarsolo(@RequestBody CarreraDTO carreraDTO) {

/*        CarreraDTO carreraCreada = carreraService.GuardarCarrera(carreraDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(carreraCreada);
  */return null;
    }
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<CarreraDTO> guardar(
            @RequestPart("carreraDTO") String carreraDTOJson,
            @RequestPart("multipartFile") MultipartFile multipartFile) throws IOException
    {
        CarreraDTO carreraDTO= carreraService.JontoCarreraDTO(carreraDTOJson);
        if (carreraDTO ==null)
            return new ResponseEntity(new MensajeDTO("no se convirto a json" + carreraDTOJson ), HttpStatus.BAD_REQUEST);

        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
            return new ResponseEntity(new MensajeDTO("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);

        Imagen imagen = new Imagen();
        imagen.setName  ((String) result.get("original_filename"));
        imagen.setImagenUrl((String) result.get("url"));
        imagen.setImagenId((String) result.get("public_id"));

        CarreraDTO carreraCreada = carreraService.save(carreraDTO, imagen);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carreraCreada);
    }


    @GetMapping ("/detail/{id}")
    public ResponseEntity<CarreraDTO> findId(@PathVariable long id) throws ResourceNotFoundException {
        //return carreraService.finId(id);
        return  ResponseEntity.status( HttpStatus.OK)
                              .body(carreraService.finId(id));

    }
       @PutMapping(value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
        public ResponseEntity<CarreraDTO> modificar(
                @RequestPart("carreraDTO") String carreraDTOJson,
                @RequestPart("multipartFile") MultipartFile multipartFile) throws IOException
        {


        CarreraDTO carreraDTO= carreraService.JontoCarreraDTO(carreraDTOJson);
            if (carreraDTO ==null)
                return new ResponseEntity(new MensajeDTO("no se convirto a json" + carreraDTOJson ), HttpStatus.BAD_REQUEST);

        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
            if(bi == null){
            return new ResponseEntity(new MensajeDTO("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.upload(multipartFile);
            Imagen imagen = new Imagen();
            imagen.setName  ((String) result.get("original_filename"));
            imagen.setImagenUrl((String) result.get("url"));
            imagen.setImagenId((String) result.get("public_id"));

            CarreraDTO carreraModificada = carreraService.save(carreraDTO, imagen);

    //        CarreraDTO carreraModificada= carreraService.modificarCarrera(id, carreraDTO);
            return ResponseEntity.status(HttpStatus.OK)
                                .body(carreraModificada);
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
/*        carreraService.Delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Carrera borrada");*/
        if (!carreraService.exists(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Carrera not found with ID: " + id);
        }

        carreraService.Delete(id);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Carrera borrada");

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }


}
