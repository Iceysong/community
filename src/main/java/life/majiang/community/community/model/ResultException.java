package life.majiang.community.community.model;

import life.majiang.community.community.enums.ResultStatus;
import lombok.Getter;
import lombok.ToString;

/**
 * 定义异常结果类
 */
@Getter
@ToString
public class ResultException extends Exception {

    public ResultStatus resultStatus;

}
