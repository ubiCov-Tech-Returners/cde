package com.ubicov.app.service;

import com.ubicov.app.domain.Furlough;
import com.ubicov.app.repository.FurloughRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurloughService {

    private FurloughRepository furloughRepository;

    public FurloughService(FurloughRepository furloughRepository) {
        this.furloughRepository = furloughRepository;
    }

    public Furlough getFurloughByDistrictAndDate(String district) {
        return furloughRepository.findByDistrict(district);
    }

    public List<Furlough> getAllFurlough() {
        return furloughRepository.findAll();
    }
}
