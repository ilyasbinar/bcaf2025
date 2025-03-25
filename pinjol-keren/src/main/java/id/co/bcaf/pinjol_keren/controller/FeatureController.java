package id.co.bcaf.pinjol_keren.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @GetMapping("/{featureName}")
    public String getFeature(@PathVariable String featureName) {
        return "You have access to: " + featureName;
    }
}
