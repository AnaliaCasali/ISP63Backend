package com.institucional.WebIsp63.Service;
import com.institucional.WebIsp63.Entity.Imagen;
import com.institucional.WebIsp63.Repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public List<Imagen> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<Imagen> getOne(int id){
        return imagenRepository.findById(id);
    }

    public Imagen save(Imagen imagen){
        return imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}
