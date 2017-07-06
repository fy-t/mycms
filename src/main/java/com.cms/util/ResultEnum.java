package com.cms.util;

/**
 * 异常码和异常详细描述
 * 400->错误请求 — 请求中有语法问题，或不能满足请求。
 * 400,01->参数为空
 * 400,02->参数格式错误
 * 400,03->必须json格式
 * 400,04->必须数字
 * 400,05->参数过长
 * 400,06->参数过短
 * 400,07->参数过大
 * 400,08->参数过小
 * 401->未授权 : 未授权客户机访问数据。
 * 402->需要付款 : 表示计费系统已有效。
 * 403->禁止 : 即使有授权也不需要访问。
 * 404->找不到 : 服务器找不到给定的资源；文档不存在。
 * 500->内部错误 : 因为意外情况，服务器不能完成请求。
 * 500,01->数据库连接异常
 * 501->未执行 : 服务器不支持请求的工具。
 * 502->错误网关 : 服务器接收到来自上游服务器的无效响应。
 * 503->无法获得服务 : 由于临时过载或维护，服务器无法处理请求。
 * 600->业务错误
 * 600,01->直播
 * 600,01,01->直播不存在
 * 600,01,02->直播已经结束
 * 600,02->视角
 * 600,02,01->视角不存在
 * 600,03->视角
 * 600,03->视角不存在
 * <p>
 * Created by taifuyu on 17/7/6.
 */
public enum ResultEnum {

    SUCCESS("200", "成功"),
    BAD_REQUEST("404", "请求不存在"),
    ILLEGAL_PARAMS("400", "请求参数不合法!"),
    INTERNAL_SERVER_ERROR("500", "接口内部异常!"),
    USER_NOT_EXIST("500,01", "数据获取异常"),
    LIVE_NOT_EXIST("600,01,01", "直播不存在"),
    LIVE_END("600,01,02", "数据获取异常"),
    LIVE_SCENE_NOT_EXIST("600,02,01", "视角不存在");


    private String code;
    private String message;

    private ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
