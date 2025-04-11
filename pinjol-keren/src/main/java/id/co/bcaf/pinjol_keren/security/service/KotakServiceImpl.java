package id.co.bcaf.pinjol_keren.security.service;

import org.springframework.stereotype.Service;

@Service
public class KotakServiceImpl implements BentukService {
    @Override
    public double luas(int sisi) {
        return sisi*sisi;
    }

    @Override
    public double keliling(int sisi) {
        return sisi*4;
    }
}
