package com.bewise.pasantia.local.dto;

public class VentaDto {
    private Long personaId;
    private Long productoId;
    private Long localId;
    private Long diaId;

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Long getDiaId() {
        return diaId;
    }

    public void setDiaId(Long diaId) {
        this.diaId = diaId;
    }
}
