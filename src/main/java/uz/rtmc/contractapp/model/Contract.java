package uz.rtmc.contractapp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
@Entity(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    String name;

    String debt;

    @ManyToOne
    Type type;

    @ManyToMany
    List<Month> months;

    public Contract(UUID id, String name, String debt, Type type) {
        this.id = id;
        this.name = name;
        this.debt = debt;
        this.type = type;
    }
}
