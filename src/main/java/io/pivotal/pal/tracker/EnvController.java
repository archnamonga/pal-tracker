package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    @Value("${PORT:NOT SET}")
    private String port;
    @Value("${MEMORY_LIMIT:NOT SET}")
    private String memoryLimit;

    public EnvController() {
    }
    @Value("${CF_INSTANCE_INDEX:NOT SET}")
    private String cfInstanceIndex;
    @Value("${CF_INSTANCE_ADDR:NOT SET}")
    private String cfInstanceAdd;

    public EnvController(String port, String memoryLimit, String cfInstanceIndex, String cfInstanceAdd) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAdd = cfInstanceAdd;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map=new HashMap<>();
        map.put("PORT",port);
        map.put("MEMORY_LIMIT",memoryLimit);
        map.put("CF_INSTANCE_INDEX",cfInstanceIndex);
        map.put("CF_INSTANCE_ADDR",cfInstanceAdd);
        return map;
    }
}
