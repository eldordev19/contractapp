package uz.rtmc.contractapp.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import uz.rtmc.contractapp.dto.TypeDto;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.projection.TypeProjection;
import uz.rtmc.contractapp.repo.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public List<TypeDto> getAllTypes() {
        List<TypeDto> dtoS = new ArrayList<>();
        List<TypeProjection> count = typeRepository.getAllTypeWithCount();
        for (TypeProjection projection : count) {
            TypeDto dto = new TypeDto(projection.getName(), projection.getCount(), projection.getId().toString());
            dtoS.add(dto);
        }
        return dtoS;
    }

    public void addType(Type type) {
        typeRepository.save(type);
    }

    public Type getTypeById(String typeId) {

        return typeRepository.findById(UUID.fromString(typeId)).get();

    }

    public void editType(UUID id, String name) {
        Type type = new Type();
        type.setName(name);
        type.setId(id);
        typeRepository.save(type);
    }

    public void deleteType(String typeId) {
        typeRepository.deleteById(UUID.fromString(typeId));
    }

    public Type getTypeByContractId(String contractId) {
        return typeRepository.findByContractId(UUID.fromString(contractId));
    }
}

