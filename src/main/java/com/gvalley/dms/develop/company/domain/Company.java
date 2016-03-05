package com.gvalley.dms.develop.company.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wyPark on 2016. 2. 27..
 */
@Entity
@Data
public class Company {

    @Id @GeneratedValue
    private Long companyId;

    private String companyName;
}
