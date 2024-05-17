package az.rock.flyjob.js.domain.presentation.dto.request.abstracts;

import java.util.UUID;

public class UpdateRequest <T extends AbstractCommandModel>{
    private UUID targetId;
    private T model;


    public UpdateRequest(UUID targetId, T model) {
        this.targetId = targetId;
        this.model = model;
    }

    public UpdateRequest() {
    }


    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public UUID getTargetId() {
        return targetId;
    }

    public void setTargetId(UUID targetId) {
        this.targetId = targetId;
    }

}
