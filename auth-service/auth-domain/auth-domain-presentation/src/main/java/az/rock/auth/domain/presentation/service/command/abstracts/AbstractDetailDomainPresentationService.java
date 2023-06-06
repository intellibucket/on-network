package az.rock.auth.domain.presentation.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.lib.annotation.InputPort;

@InputPort
public interface AbstractDetailDomainPresentationService {
    DetailPrivateModelResponse queryDetail();
}
