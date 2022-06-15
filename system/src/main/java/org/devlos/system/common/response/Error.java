package org.devlos.system.common.response;

import lombok.Data;

/**
 * com.winitech.node.common.response
 * ㄴ Error.java
 * @author : 박준희 과장 (부설연구소)
 * @since : 2021-12-14 오전 10:07
 * @see : None
 **/
@Data
public class Error {
    private String field;
    private String message;
    private String invalidValue;
}
