package uz.rtmc.contractapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@PackagePrivate
public class ContractMonthDto {

    String name;

    String type;

    String debt;

    String january;

    String february;

    String march;

    String april;

    String may;

    String june;

    String july;

    String august;

    String september;

    String october;

    String november;

    String december;
}
