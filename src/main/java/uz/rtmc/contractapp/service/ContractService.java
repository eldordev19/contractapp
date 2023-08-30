package uz.rtmc.contractapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.rtmc.contractapp.dto.ContractMonthDto;
import uz.rtmc.contractapp.model.Contract;
import uz.rtmc.contractapp.model.Month;
import uz.rtmc.contractapp.model.PaidInfo;
import uz.rtmc.contractapp.model.Type;
import uz.rtmc.contractapp.repo.ContractRepository;
import uz.rtmc.contractapp.repo.PaidInfoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    MonthRepository monthRepository;

    @Autowired
    TypeService typeService;

    @Autowired
    PaidInfoRepository infoRepository;

    public List<Contract> getContractsByTypeId(String typeId) {

        return contractRepository.getByTypeId(UUID.fromString(typeId));
    }

    public void addContract(ContractMonthDto dto) {
        List<Month> months = monthRepository.findAll();
        Type type = typeService.getTypeById(String.valueOf(dto.getType()));
        UUID contractId = UUID.randomUUID();
        Contract contract = new Contract(contractId, dto.getName(), dto.getDebt(), type, months);
        Contract save = contractRepository.save(contract);
        addPayment(dto, save.getId());
    }

    public void addPayment(ContractMonthDto dto, UUID contractId) {
        List<PaidInfo> infoList = new ArrayList<>();
        List<Month> months = monthRepository.findAll();
        if (dto.getJanuary() != null) {
            if (dto.getJanuary().equals("1")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Yanvar")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getFebruary() != null) {
            if (dto.getFebruary().equals("2")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Fevral")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMarch() != null) {
            if (dto.getMarch().equals("3")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Mart")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getApril() != null) {
            if (dto.getApril().equals("4")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Aprel")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMay() != null) {
            if (dto.getMay().equals("5")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("May")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJune() != null) {
            if (dto.getJune().equals("6")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyun")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJuly() != null) {
            if (dto.getJuly().equals("7")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyul")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getAugust() != null) {
            if (dto.getAugust().equals("8")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Avgust")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getSeptember() != null) {
            if (dto.getSeptember().equals("9")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Sentabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getOctober() != null) {
            if (dto.getOctober().equals("10")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Oktabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getNovember() != null) {
            if (dto.getNovember().equals("11")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Noyabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getDecember() != null) {
            if (dto.getDecember().equals("12")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Dekabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        infoRepository.saveAll(infoList);
    }

    private UUID getContractIdByName(String name) {
        return contractRepository.getByName(name);
    }

    public String deleteContract(String contractId) {
        Type type = typeService.getTypeByContractId(contractId);
        contractRepository.deleteById(UUID.fromString(contractId));
        return String.valueOf(type.getId());
    }

    public Contract getContractById(String contractId) {
        return contractRepository.findById(UUID.fromString(contractId)).get();
    }

    public ContractMonthDto getContractMonthDto(String contractId) {
        String january = new String();
        String february = new String();
        String march = new String();
        String april = new String();
        String may = new String();
        String june = new String();
        String july = new String();
        String august = new String();
        String september = new String();
        String october = new String();
        String november = new String();
        String december = new String();

        List<PaidInfo> infos = infoRepository.getPaidInfoByContractId(UUID.fromString(contractId));
        List<Month> months = monthRepository.findAll();

        for (PaidInfo info : infos) {
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Yanvar") && info.is_paid() == true) {
                    january = "1";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Fevral") && info.is_paid() == true) {
                    february = "2";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Mart") && info.is_paid() == true) {
                    march = "3";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Aprel") && info.is_paid() == true) {
                    april = "4";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("May") && info.is_paid() == true) {
                    may = "5";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Iyun") && info.is_paid() == true) {
                    june = "6";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Iyul") && info.is_paid() == true) {
                    july = "7";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Avgust") && info.is_paid() == true) {
                    august = "8";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Sentabr") && info.is_paid() == true) {
                    september = "9";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Oktabr") && info.is_paid() == true) {
                    october = "10";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Noyabr") && info.is_paid() == true) {
                    november = "11";
                    break;
                }
            }
            for (Month month : months) {
                if (info.getMonthId().equals(month.getId()) && month.getName().equals("Dekabr") && info.is_paid() == true) {
                    december = "12";
                    break;
                }
            }
        }

        Contract contract = getContractById(contractId);
        ContractMonthDto dto = new ContractMonthDto(contract.getName(), String.valueOf(contract.getType().getId()),
                contract.getDebt(), january, february, march, april, may, june, july, august,
                september, october, november, december);
        return dto;
    }

    public void editFinish(ContractMonthDto dto) {
        Contract contractByName = getContractByName(dto.getName());
        Type type = typeService.getTypeById(String.valueOf(dto.getType()));
        Contract contract = new Contract(contractByName.getId(), dto.getName(), dto.getDebt(), type);
        Contract save = contractRepository.save(contract);
        editPayment(dto);
    }

    public void editPayment(ContractMonthDto dto) {
        Contract contractByName = getContractByName(dto.getName());
        List<PaidInfo> infoList = new ArrayList<>();
        List<Month> months = monthRepository.findAll();
        if (dto.getJanuary() != null) {
            if (dto.getJanuary().equals("1")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Yanvar")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getFebruary() != null) {
            if (dto.getFebruary().equals("2")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Fevral")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMarch() != null) {
            if (dto.getMarch().equals("3")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Mart")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getApril() != null) {
            if (dto.getApril().equals("4")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Aprel")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMay() != null) {
            if (dto.getMay().equals("5")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("May")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJune() != null) {
            if (dto.getJune().equals("6")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyun")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJuly() != null) {
            if (dto.getJuly().equals("7")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyul")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getAugust() != null) {
            if (dto.getAugust().equals("8")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Avgust")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getSeptember() != null) {
            if (dto.getSeptember().equals("9")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Sentabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getOctober() != null) {
            if (dto.getOctober().equals("10")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Oktabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getNovember() != null) {
            if (dto.getNovember().equals("11")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Noyabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getDecember() != null) {
            if (dto.getDecember().equals("12")) {
                UUID monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Dekabr")) monthId = month.getId();
                }
                PaidInfo paidInfo = new PaidInfo(null, contractByName.getId(), monthId, true);
                infoList.add(paidInfo);
            }
        }
        infoRepository.saveAll(infoList);
    }

    private Contract getContractByName(String name) {
        return contractRepository.getByContractName(name);
    }
}
