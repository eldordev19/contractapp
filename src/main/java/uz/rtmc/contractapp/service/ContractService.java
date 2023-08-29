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
        addPayment(dto, String.valueOf(contractId));
        contractRepository.save(contract);
    }

    public void addPayment(ContractMonthDto dto, String contractId) {
        List<PaidInfo> infoList = new ArrayList<>();
        List<Month> months = monthRepository.findAll();
        if (dto.getJanuary() != null) {
            if (dto.getJanuary().equals("1")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Yanvar")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getFebruary() != null) {
            if (dto.getFebruary().equals("2")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Fevral")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMarch() != null) {
            if (dto.getMarch().equals("3")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Mart")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getApril() != null) {
            if (dto.getApril().equals("4")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Aprel")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getMay() != null) {
            if (dto.getMay().equals("5")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("May")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJune() != null) {
            if (dto.getJune().equals("6")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyun")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getJuly() != null) {
            if (dto.getJuly().equals("7")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Iyul")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getAugust() != null) {
            if (dto.getAugust().equals("8")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Avgust")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getSeptember() != null) {
            if (dto.getSeptember().equals("9")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Sentabr")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getOctober() != null) {
            if (dto.getOctober().equals("10")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Oktabr")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getNovember() != null) {
            if (dto.getNovember().equals("11")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Noyabr")) monthId = String.valueOf(month.getId());
                }
                PaidInfo paidInfo = new PaidInfo(null, contractId, monthId, true);
                infoList.add(paidInfo);
            }
        }
        if (dto.getDecember() != null) {
            if (dto.getDecember().equals("12")) {
                String monthId = null;
                for (Month month : months) {
                    if (month.getName().equals("Dekabr")) monthId = String.valueOf(month.getId());
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

        Contract contract = getContractById(contractId);
        ContractMonthDto dto = new ContractMonthDto(contract.getName(), String.valueOf(contract.getType().getId()),
                contract.getDebt(), january, february, march, april, may, june, july, august,
                september, october, november, december);
        return dto;
    }
}
