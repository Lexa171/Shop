package by.onlineStore.mapper;

import by.onlineStore.bean.Provider;
import by.onlineStore.dto.CreateProviderDto;
import by.onlineStore.dto.ProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProviderMapper {

    @Autowired
    private ProductMapper productMapper;

    public Provider convertToProvider(ProviderDto providerDto) {
        return Optional.of(providerDto).map(localProviderDto -> {
            Provider provider=new Provider();
            provider.setId(localProviderDto.getId());
            provider.setName(localProviderDto.getName());
            provider.setMail(localProviderDto.getMail());
            provider.setPhone(localProviderDto.getPhone());
            return provider;
        }).orElse(null);
    }

    public ProviderDto convertToProviderDto(Provider provider) {
        return Optional.of(provider).map(localProvider -> {
            ProviderDto providerDto=new ProviderDto();
            providerDto.setId(localProvider.getId());
            providerDto.setName(localProvider.getName());
            providerDto.setMail(localProvider.getMail());
            providerDto.setPhone(localProvider.getPhone());
            providerDto.setProducts(productMapper.convertToListProductDto(provider.getProducts()));
            return providerDto;
        }).orElse(null);
    }

    public Provider convertToProvider(CreateProviderDto createProviderDto) {
        return Optional.of(createProviderDto).map(localCreateProviderDto -> {
            Provider provider=new Provider();
            provider.setName(localCreateProviderDto.getName());
            provider.setMail(localCreateProviderDto.getMail());
            provider.setPhone(localCreateProviderDto.getPhone());
            return provider;
        }).orElse(null);
    }

    public List<ProviderDto> convertToListProviderDto(List<Provider> providerList) {

        return Optional.ofNullable(providerList).map(localProductList ->
                localProductList.stream()
                        .map(this::convertToProviderDto)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }
}
