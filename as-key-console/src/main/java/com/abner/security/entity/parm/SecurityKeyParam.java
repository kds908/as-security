package com.abner.security.entity.parm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecurityKeyParam {
    private Long projectId;
    private Long applyMemberId;
    private Long keyVersion;
}
