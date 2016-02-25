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
    private Long userId; // 사용자ID

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String fullName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date rgstDt; // 등록일시

    private String rgstUserId; // 등록사용자ID

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDt; // 수정일시

    private String updtUserId; // 수정사용자ID

    private boolean adminYn; // 관리자여부
}
