package com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyWebsiteCreatedCommand {
   private String website;
}
