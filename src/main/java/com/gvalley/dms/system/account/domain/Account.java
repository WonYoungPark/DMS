package com.gvalley.dms.system.account.domain;

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
    private String userId  ; // 사용자ID

    private String userName; // 사용자명

    private String password; // 패스워드

    @Temporal(TemporalType.TIMESTAMP)
    private Date rgstDtm   ; // 등록일시

    private String rgstUserId; // 등록사용자ID

    @Temporal(TemporalType.TIMESTAMP)
    private Date updtDtm   ; // 수정일시

    private String updtUserId; // 수정사용자ID
}
