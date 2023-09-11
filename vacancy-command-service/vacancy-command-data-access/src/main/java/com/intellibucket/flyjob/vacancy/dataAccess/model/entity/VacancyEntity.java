package com.intellibucket.flyjob.vacancy.dataAccess.model.entity;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.WorkingTimeLine;
import az.rock.lib.valueObject.WorkingType;
import az.rock.lib.valueObject.vacancy.VacancyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "vacancy", name = "vacancies")
@Entity(name = "VacancyEntity")
public class VacancyEntity extends BaseEntity {

    @Column(name = "company_id",nullable = false,updatable = false)
    private UUID companyID;

    @Enumerated(EnumType.STRING)
    @Column(name = "vacancy_status",nullable = false)
    private VacancyStatus vacancyStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp planningDate;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "about",nullable = false)
    private String about;

    @Column(name = "requeriments",nullable = false)
    private String requeriments;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endDate;

    @Enumerated(EnumType.STRING)
    private WorkingTimeLine workingTimeLine;

    @Enumerated(EnumType.STRING)
    private WorkingType workingType;

    @OneToOne(mappedBy = "vacancy")
    private SalaryEntity salary;

    @OneToOne(mappedBy = "vacancy")
    private LocationEntity location;

    @OneToMany(mappedBy = "vacancy")
    private List<MarkEntity> marks;

    @OneToMany(mappedBy = "vacancy")
    private List<AppliedUserEntity> appliedUsers;

    @OneToMany(mappedBy = "vacancy")
    private List<VacancyTagEntity> vacancyTagEntities;

    @OneToMany(mappedBy = "vacancy")
    private List<ViewerEntity> viewers;

    @OneToOne(mappedBy = "vacancy")
    private VacancySettingEntity setting;
}
