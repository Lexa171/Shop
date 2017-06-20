package by.onlineStore.service;

import by.onlineStore.dto.CreateProviderDto;
import by.onlineStore.dto.ProviderDto;

import java.util.List;

public interface ProviderService {

    ProviderDto getProviderById(Long providerId);

    List<ProviderDto> getAllProviders();

    void deleteProvider(Long providerId);

    ProviderDto saveProvider(CreateProviderDto createProviderDto);

    ProviderDto updateProvider(ProviderDto providerDto);
}