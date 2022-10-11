package com.example.person.controller;

import com.example.person.model.PersonModel;
import com.example.person.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ModelController {
    @Autowired
    ModelRepository modelRepository;

    @GetMapping("/person")
    private List<PersonModel> getAllPersonModel(){
        return modelRepository.findAll();
    }
    @GetMapping("/person/{id}")
    private PersonModel getPersonModel(@PathVariable("id") long id) throws Exception {
        var result = modelRepository.findById(id);
        if(result.isEmpty()){
            throw new Exception("not found");
        }
        return result.get();
    }
    @DeleteMapping("/person/{id}")
    private void deletePerson(@PathVariable("id") long id) throws Exception {
        var result = modelRepository.findById(id);
        if (result.isEmpty()){
            throw new Exception("not found");
        }
        modelRepository.deleteById(id);
    }

    @PostMapping("/person")
    private void savePerson(@RequestBody PersonModel personModel){
        modelRepository.save(personModel);
    }

    @PutMapping("/person/{id}")
    private PersonModel updatePerson(@PathVariable("id") long id, @RequestBody PersonModel personModel) throws Exception {
        var result = modelRepository.findById(id);
        if (result.isEmpty()){
            throw new Exception("not found");
        }
        var data = result.get();
        data.setName(personModel.getName());
        data.setAddress(personModel.getAddress());
        data.setPostcode(personModel.getPostcode());
        data.setAge(personModel.getAge());
        data.setJob(personModel.getJob());
        data.setEmail(personModel.getEmail());
        data.setPhoneno(personModel.getPhoneno());
        modelRepository.save(data);
        return data;
    }

}
