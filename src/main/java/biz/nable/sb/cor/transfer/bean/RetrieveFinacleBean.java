/**
 *
 */
package biz.nable.sb.cor.transfer.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author roshan.wijendra
 *
 */

@Setter
@Getter
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "finacle.data.object")
public class RetrieveFinacleBean {
    private String aPPCode;
    private String custId;
    private String controller;
    private String cDCICode;
    private String accountNo;
    private String currencyCode;
    private String solID;
}
