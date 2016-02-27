package com.gvalley.dms.member.account.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Some descriptions here.
 *
 * @aothor WonYoungPark / wyparks2@gmail.com
 * @Date 2016-02-06
 * @since 0.1
 */

@Entity
@Data
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date rgstDt; // 등록일시

    private String rgstId; // 등록ID

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDt; // 수정일시

    private String updtId; // 수정ID

    private Long companyId; // 기업ID

    private boolean adminYn; // 관리자여부
}
