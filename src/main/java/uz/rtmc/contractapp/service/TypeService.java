package uz.rtmc.contractapp.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.repo.TypeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public void addType(Type type) {
        typeRepository.save(type);
    }

    public Type getTypeById(String typeId) {

        return typeRepository.findById(UUID.fromString(typeId)).get();

    }

    public void editType(Type type) {
        typeRepository.save(type);
    }

    public void deleteType(String typeId) {
        typeRepository.deleteById(UUID.fromString(typeId));
    }

    public Type getTypeByContractId(String contractId) {
        return typeRepository.findByContractId(UUID.fromString(contractId));
    }
}
