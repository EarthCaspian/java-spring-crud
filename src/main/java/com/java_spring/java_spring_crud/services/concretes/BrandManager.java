package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.core.utilities.mappers.ModelMapperService;
import com.java_spring.java_spring_crud.core.utilities.messages.MessageService;
import com.java_spring.java_spring_crud.core.utilities.results.Result;
import com.java_spring.java_spring_crud.core.utilities.results.SuccessResult;
import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.repositories.BrandRepository;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.constants.Messages;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.responses.GetListBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;

    @Override
    public Result add(AddBrandRequest request) {

        if (request.getName().length() < 3)
            throw new RuntimeException("Marka adı 3 karakterden az olamaz.");

        if (!Character.isUpperCase(request.getName().charAt(0)))
            throw new RuntimeException("Marka adı büyük harfle başlamalıdır.");

        if (brandRepository.existsByName(request.getName()))
            throw new RuntimeException("Bu isimde bir marka mevcut");


        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);

        return new SuccessResult(messageService.getMessage(Messages.Brand.brandAddSuccess));
    }

    @Override
    public Result update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId())
                                             .orElseThrow( () -> new RuntimeException("Marka bulunamadı."));
        if (request.getName().length() < 3)
            throw new RuntimeException("Marka adı 3 karakterden az olamaz.");

        if (brandRepository.existsByName(request.getName())) {
            throw new RuntimeException("Bu isimde bir marka mevcut, lütfen başka bir marka adı giriniz.");
        }

        Brand brand = this.modelMapperService.forRequest().map(request, Brand.class);
        brandRepository.save(brand);

        return new SuccessResult(messageService.getMessage(Messages.Brand.brandUpdateSuccess));
    }

    @Override
    public List<String> getAll() {
        return brandRepository.findAll().stream()
                .map(Brand::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Brand getById(GetBrandRequest request) {
        return brandRepository.findById(request.getId())
                                               .orElseThrow( () -> new RuntimeException("Marka bulunamadı."));
    }

    @Override
    public void deleteById(DeleteBrandRequest request) {
        Brand brandToDelete = brandRepository.findById(request.getId())
                                             .orElseThrow(() -> new RuntimeException("Marka bulunamadı."));
        brandRepository.delete(brandToDelete);
    }

    @Override
    public List<GetListBrandResponse> getByNameDto(String name) {

        return brandRepository.findByName(name).stream()
                .map((brand -> new GetListBrandResponse(brand.getId(),brand.getName())))
                .toList();
    }

    @Override
    public List<Brand> getByName(String name) {
        return brandRepository.findByNameStartsWith(name);
    }

    @Override
    public Brand getById(int id) {
        return brandRepository.findById(id).orElseThrow(() -> new RuntimeException("Marka bulunamadı."));
    }


}
