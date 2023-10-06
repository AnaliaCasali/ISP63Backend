package com.institucional.WebIsp63.Service;



import com.institucional.WebIsp63.DTO.TemaDTO;

import com.institucional.WebIsp63.Entity.Carrera;
import com.institucional.WebIsp63.Entity.Tema;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;

import com.institucional.WebIsp63.Mapper.TemaMapper;
import com.institucional.WebIsp63.Repository.TemaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TemaServiceImp {
    @Autowired
    TemaRepository temaRepository;
    @Autowired
    private TemaMapper temaMapper;

    @Transactional
    public TemaDTO guardartema(TemaDTO temaDTO) {
        Tema tema = new Tema();
        tema.setId(temaDTO.getId());
        tema.setTema(temaDTO.getTema());
        temaRepository.save(tema);
        return temaDTO;
    }

    public List<TemaDTO> findAll() {
        //{return temaRepository.findAll().stream().map(tema -> new TemaDTO(tema.getId(), tema.getNomtema())).collect(Collectors.toList());
        return temaMapper.totemasDTO(temaRepository.findAll());

    }
    public List<TemaDTO> findAllTema (String tema){
        //return  bibliotecaRepository.findAllBibliotec(tema).stream().map(car ->
        return temaRepository.findByTemaContainingOrderById(tema).stream().map(Tema ->
                new TemaDTO(Tema.getId(), Tema.getTema())).collect(Collectors.toList());


    }

    public  void eliminarTema(long id){temaRepository.deleteById(id);}


    public TemaDTO modificartema ( TemaDTO temaDTO) {
        Tema tema = new Tema();
        tema.setId(temaDTO.getId());
        tema.setTema(temaDTO.getTema());
        temaRepository.save(tema);
        return temaDTO;
    }
    public TemaDTO buscar(long id )  throws ResourceNotFoundException {
       // Optional<Tema> temaOptional = temaRepository.findById(id);
     //   if (temaOptional.isEmpty()) {
          //  throw new RuntimeException("Id valido");

     //   }
        //Tema tem= temaOptional.get();
     //   return  new TemaDTO(tem.getId(), tem.getNomtema());
        Tema tema =temaRepository.findById(id).orElseThrow(    ()-> new ResourceNotFoundException("Tema con id"+ id + "no se encontro"));
        return  temaMapper.toTemaDTO(tema);

    }

    public boolean exists (long id){
        return temaRepository.existsById(id);
    }

}
