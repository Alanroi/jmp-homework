module jmp.cloud.service.impl {
    exports com.jmp.cloud.service.impl;
    requires transitive jmp.service.api;
    requires jmp.dto;
    provides com.jmp.service.api.Service with
            com.jmp.cloud.service.impl.CloudService;
}