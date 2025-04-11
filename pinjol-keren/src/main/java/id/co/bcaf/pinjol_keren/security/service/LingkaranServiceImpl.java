package id.co.bcaf.pinjol_keren.security.service;

import org.springframework.stereotype.Service;

@Service
public class LingkaranServiceImpl implements BentukService {
    @Override
    public double luas(int jari) {
        return (double) 22/7*jari*jari;
    }

    @Override
    public double keliling(int jari) {
        return 2*(22/7)*jari;
    }
}
