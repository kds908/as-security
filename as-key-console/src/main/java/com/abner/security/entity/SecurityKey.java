package com.abner.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Description for this class
 *
 * <p>
 *
 * @author: Abner Song
 * <p>
 * @date: 2024/4/25 14:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "security_key")
public class SecurityKey {
    /**
     * primary key id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     * the key of security
     */
    @Column(name = "key")
    private String key;
    /**
     * the id of project which use the key
     */
    @Column(name = "project_id")
    private Long projectId;
    /**
     * the name of project which use the key
     */
    @Column(name = "project_name")
    private String projectName;
    /**
     * the id of user/member who apply for the key
     */
    @Column(name = "apply_member_id")
    private Long applyMemberId;
    /**
     * the name of user/member who apply for the key
     */
    @Column(name = "apply_member_name")
    private String applyMemberName;
    /**
     * description of the key
     */
    @Column(name = "description")
    private String description;
    /**
     * the version of the key
     * user may change security key after a project running for a long time
     * after user changing the key, the history data should find their key to decrypt
     */
    @Column(name = "key_version")
    private Long keyVersion;
}
