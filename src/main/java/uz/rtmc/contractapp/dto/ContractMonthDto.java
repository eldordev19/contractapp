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

    UUID id;

    String name;

    String type;

    String debt;

    String january;

    String february;

    public ContractMonthDto(String name, String type, String debt, String january,
                            String february, String march, String april, String may,
                            String june, String july, String august, String september,
                            String october, String november, String december) {
        this.name = name;
        this.type = type;
        this.debt = debt;
        this.january = january;
        this.february = february;
        this.march = march;
        this.april = april;
        this.may = may;
        this.june = june;
        this.july = july;
        this.august = august;
        this.september = september;
        this.october = october;
        this.november = november;
        this.december = december;
    }

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
