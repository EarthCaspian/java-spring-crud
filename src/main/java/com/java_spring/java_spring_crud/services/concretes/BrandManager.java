package com.java_spring.java_spring_crud.services.concretes;

import com.java_spring.java_spring_crud.entities.Brand;
import com.java_spring.java_spring_crud.repositories.BrandRepository;
import com.java_spring.java_spring_crud.services.abstracts.BrandService;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.AddBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.DeleteBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.GetBrandRequest;
import com.java_spring.java_spring_crud.services.dtos.brand.requests.UpdateBrandRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void add(AddBrandRequest request) {

        if (request.getName().length() < 3)
            throw new RuntimeException("Marka adı 3 karakterden az olamaz.");

        Brand brand = new Brand();
        brand.setName(request.getName());
        brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest request) {
        Brand brandToUpdate = brandRepository.findById(request.getId())
                                             .orElseThrow( () -> new RuntimeException("Marka bulunamadı."));
        brandToUpdate.setName(request.getName());
        brandRepository.save(brandToUpdate);
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


}
