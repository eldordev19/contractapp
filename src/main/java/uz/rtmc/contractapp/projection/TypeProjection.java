package uz.rtmc.contractapp.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uz.rtmc.contractapp.dto.TypeDto;

import java.util.UUID;

@Projection(types = TypeDto.class)
public interface TypeProjection {

    String getName();

    UUID getId();

    @Value("#{@typeRepository.getContractCountsByTypeId(target.id)}")
    Integer getCount();
}
