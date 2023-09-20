package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.DTO.BibliografiaDTO;
import com.institucional.WebIsp63.Entity.Bibliografia;
import com.institucional.WebIsp63.Exception.ResourceNotFoundException;
import com.institucional.WebIsp63.Mapper.BibliografiaMapper;
import com.institucional.WebIsp63.Repository.BibliografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliografiaServiceImp implements BibliografiaService {
    @Autowired
    BibliografiaRepository bibliografiaRepository;
    @Autowired
    private BibliografiaMapper bibliografiaMapper;
    @Override

    public BibliografiaDTO guardarBibliografia(BibliografiaDTO bibliografiaDTO){
        Bibliografia bibli =new Bibliografia();
        bibli.setId(bibliografiaDTO.getId());
        bibli.setDescripcion(bibliografiaDTO.getDescripcion());
//        bibli.setTema(bibliotecaDTO.getTema());
        bibli.setNamecreador(bibliografiaDTO.getNamecreador());
        bibli.setTitulo(bibliografiaDTO.getTitulo());
        bibliografiaRepository.save(bibli);
        return bibliografiaDTO;
    }
    public List<BibliografiaDTO> findAll()
    {
        //return bibliotecaRepository.findAll().stream().map(biblioteca -> new BibliotecaDTO(biblioteca.getId(), biblioteca.getDescripcion(), biblioteca.getNamecreador(), biblioteca.getTitulo(), biblioteca.getTema())).collect(Collectors.toList());
        return bibliografiaMapper.toBibliografiasDTO(bibliografiaRepository.findAll());
    }

    @Override
    public List<BibliografiaDTO> findAllBibliografia(String tema) {
        return null;
    }
//    public List<BibliografiaDTO> findAllBiblioteca (String tema){
         //return  bibliotecaRepository.findAllBibliotec(tema).stream().map(car ->
//        return bibliotecaRepository.findBytemaContainingOrderById(tema).stream().map(biblioteca ->
  //                      new BibliotecaDTO(biblioteca.getId(), biblioteca.getTitulo(), biblioteca.getDescripcion(), biblioteca.getTema(), biblioteca.getNamecreador())).collect(Collectors.toList());

//return null;
  //  }
    public void eliminarBibliografia(long id){
        bibliografiaRepository.deleteById(id);}
    @Override
    public BibliografiaDTO modificarBibliografia(long id, BibliografiaDTO bibliografiaDTO){
        Optional <Bibliografia> bibliografiaOptional= bibliografiaRepository.findById(id);
        if (bibliografiaOptional.isEmpty()){
            throw new RuntimeException("Id valido");
        }
    Bibliografia bibli = bibliografiaOptional.get();
        bibli.setId(bibliografiaDTO.getId());
        bibli.setDescripcion(bibliografiaDTO.getDescripcion());
  //      bibli.setTema(bibliotecaDTO.getTema());
        bibli.setNamecreador(bibliografiaDTO.getNamecreador());
        bibli.setTitulo(bibliografiaDTO.getTitulo());
        bibliografiaRepository.save(bibli);
        return bibliografiaDTO;
    }
    @Override
    public BibliografiaDTO buscar (long id ) throws ResourceNotFoundException{
/*       Optional<Biblioteca>bibliotecaOptional=bibliotecaRepository.findById(id);
        if(bibliotecaOptional.isEmpty()){
            throw new RuntimeException("Id valido");
        }
        Biblioteca bibli=bibliotecaOptional.get();
        return  new BibliotecaDTO(bibli.getId(),bibli.getTitulo(),bibli.getDescripcion(), bibli.getNamecreador(), bibli.getTema() );
  */      Bibliografia bibliografia =bibliografiaRepository.findById(id).orElseThrow(    ()-> new ResourceNotFoundException("Biblioteca con id"+ id + "no se encontro"));
        return  bibliografiaMapper.toBibliografiaDTO(bibliografia);
//  return null;
    }

}
