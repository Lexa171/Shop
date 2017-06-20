package by.onlineStore.controller;


import by.onlineStore.dto.CreateProviderDto;
import by.onlineStore.dto.ProviderDto;
import by.onlineStore.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@RequestMapping(value = {"/provider"}, produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public ResponseEntity<List<ProviderDto>> getAllProvider() {

        return ResponseEntity.ok(providerService.getAllProviders());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProviderDto> getProvider(@PathVariable("id") Long id) {

        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProviderDto> addProvider(@RequestBody CreateProviderDto createProviderDto) {

        return ResponseEntity.ok(providerService.saveProvider(createProviderDto));
    }


    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<ProviderDto> updateProvider(@RequestBody ProviderDto providerDto) {

        return ResponseEntity.ok(providerService.updateProvider(providerDto));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProvider(@PathVariable("id") Long id) {
        providerService.deleteProvider(id);

        return ResponseEntity.ok().build();
    }

}
