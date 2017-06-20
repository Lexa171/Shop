package by.onlineStore.service.impl;

import by.onlineStore.dto.CreateProviderDto;
import by.onlineStore.dto.ProviderDto;
import by.onlineStore.exception.NotFoundException;
import by.onlineStore.mapper.ProviderMapper;
import by.onlineStore.repository.ProviderRepository;
import by.onlineStore.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public ProviderDto getProviderById(Long providerId) {
        return providerMapper.convertToProviderDto(providerRepository.findOneById(providerId)
                .orElseThrow(() -> new NotFoundException("Provider not found")));
    }

    @Override
    public List<ProviderDto> getAllProviders() {
        return providerMapper.convertToListProviderDto(providerRepository.findAll());
    }

    @Override
    public void deleteProvider(Long providerId) {
        providerRepository.delete(providerId);
    }

    @Override
    public ProviderDto saveProvider(CreateProviderDto createProviderDto) {
        return providerMapper.convertToProviderDto(providerRepository.saveAndFlush(
                providerMapper.convertToProvider(createProviderDto)));
    }

    @Override
    public ProviderDto updateProvider(ProviderDto providerDto) {
        return providerMapper.convertToProviderDto(providerRepository.saveAndFlush(
                providerMapper.convertToProvider(providerDto)));
    }
}
