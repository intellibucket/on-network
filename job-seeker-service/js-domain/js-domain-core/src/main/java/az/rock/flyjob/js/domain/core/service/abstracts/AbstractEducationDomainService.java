package az.rock.flyjob.js.domain.core.service.abstracts;

import az.rock.flyjob.js.domain.core.root.detail.EducationRoot;
import az.rock.lib.domain.id.js.ResumeID;

import java.util.Optional;

public interface AbstractEducationDomainService {
    EducationRoot validateEducation(ResumeID resumeID, EducationRoot educationRoot);

}
