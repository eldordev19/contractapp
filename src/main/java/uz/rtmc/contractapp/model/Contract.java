package uz.rtmc.contractapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
@Entity(name = "contracts")
public class Contract {

    @Id
    @GeneratedValue
    UUID id;

    String name;

    String debt;

    @ManyToOne
    Type type;

    @ManyToMany
    List<Month> months;
}
