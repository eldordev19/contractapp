package uz.rtmc.contractapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
@Entity(name = "months")
public class Month {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    UUID id;

    String name;

}
